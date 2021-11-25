package com.example.eksamensprojektvinter2021.Resporsitories;

import com.example.eksamensprojektvinter2021.Models.Project;
import com.example.eksamensprojektvinter2021.Utility.JDBC;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRepo {

    public void insertProjectIntoDatabase(Project p) {
        try {
            PreparedStatement stmt = JDBC.getConnection().prepareStatement
                    ("INSERT INTO heroku_7aba49c42d6c0f0.projects (`title`, `project_deadline`, " +
                            "`status`, `base_price`, `customer_id`, `manager_id`, `description`) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?);");
            stmt.setString(1, p.getProjectTitle());
            stmt.setDate(2, (Date) p.getProjectDeadline());
            stmt.setString(3, p.getStatus());
            stmt.setDouble(4, p.getBasePrice());
            stmt.setInt(5, p.getCustomerId());
            stmt.setInt(6, p.getManagerId());
            stmt.setString(7, p.getDescription());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Project could not be inserted into database");
            System.out.println(e.getMessage());
        }
    }


    public Project getProjectFromDatabase(int id) {
        Project p = new Project();
        try {
            PreparedStatement stmt = JDBC.getConnection().prepareStatement("SELECT * FROM " +
                    "heroku_7aba49c42d6c0f0.projects WHERE project_id=?;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            String name = rs.getString("name");
            Date date = rs.getDate("project_deadline");
            String status = rs.getString("status");
            Double price = rs.getDouble("base_price");
            int customerId = rs.getInt("customer_id");
            int managerId = rs.getInt("manager_id");
            p = new Project(name, date, status, price, customerId, managerId);

            //Kan ikke sætte total_price til null i condition, så det virker nok ikke, da databasen forventes at
            // returnere null og ikke 0. Jeg vil gerne teste dette, inden jeg finder på en mere kompliceret løsning.
            if (rs.getDouble("total_price") != 0){
                p.setTotalPrice(rs.getDouble("total_price"));
            }

            if (rs.getString("total_time") != null){
                p.setTotalPrice(rs.getInt("total_time"));
            }

            if (rs.getString("description") != null){
                p.setDescription(rs.getString("description"));
            }

            p.setProjectId(rs.getInt("project_id"));

        } catch(SQLException e){
            System.out.println("Couldn't get project with id " + id + " from database");
            System.out.println(e.getMessage());
        }
        return p;
    }

    public void deleteProjectFromDatabase(int id) {
        try {
            PreparedStatement stmt = JDBC.getConnection().prepareStatement
                    ("DELETE FROM `heroku_7aba49c42d6c0f0`.`projects` WHERE (`project_id` = '" + id + "');");
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Couldn't delete project with id " + id + " from database");
            System.out.println(e.getMessage());
        }

    }

    //Skal jeg evt. lave if-statements til de attributter, der ikke er NN?
    public void updateProjectInDatabase(Project p) {
        try {
            PreparedStatement stmt = JDBC.getConnection().prepareStatement
                    ("UPDATE `heroku_7aba49c42d6c0f0`.`projects` SET `name` = ?, `project_deadline` = ?, " +
                            "`status` = ?, `base_price` = ?, `total_price` = ?, `total_time` = ?, " +
                            "`customer_id` = ?, `manager_id` = ?, `description` = ? WHERE (`project_id` = ?;");
            stmt.setString(1, p.getProjectTitle());
            stmt.setDate(2, (Date) p.getProjectDeadline());
            stmt.setString(3, p.getStatus());
            stmt.setDouble(4, p.getBasePrice());
            stmt.setDouble(5, p.getTotalPrice());
            stmt.setInt(6, p.getTotalTime());
            stmt.setInt(7, p.getCustomerId());
            stmt.setInt(8, p.getManagerId());
            stmt.setString(9, p.getDescription());
            stmt.setInt(9, p.getProjectId());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Couldn't update project with id " + p.getProjectId() + " in database");
            System.out.println(e.getMessage());
        }

    }

}
