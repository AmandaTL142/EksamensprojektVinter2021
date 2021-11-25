package com.example.eksamensprojektvinter2021.Resporsitories;

import com.example.eksamensprojektvinter2021.Models.Project;
import com.example.eksamensprojektvinter2021.Models.Subproject;
import com.example.eksamensprojektvinter2021.Utility.JDBC;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubprojectRepo {

    public void insertSubprojectIntoDatabase(Subproject p) {
        try {
            PreparedStatement stmt = JDBC.getConnection().prepareStatement
                    ("INSERT INTO `heroku_7aba49c42d6c0f0`.`subprojects` (`title`, `description`, " +
                            "`subproject_deadline`, `status`, `project_id`) " +
                            "VALUES (?, ?, ?, ?, ?);");
            stmt.setString(1, p.getSubprojectTitle());
            stmt.setString(2, p.getSubprojectDescription());
            stmt.setDate(3, (Date) p.getSubprojectDeadline());
            stmt.setString(4, p.getSubprojectStatus());
            stmt.setInt(5, p.getProjectId());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Subproject could not be inserted into database");
            System.out.println(e.getMessage());
        }
    }


    public Subproject getSubprojectFromDatabase(int id) {
        Subproject sp = new Subproject();
        try {
            PreparedStatement stmt = JDBC.getConnection().prepareStatement("SELECT * FROM " +
                    "heroku_7aba49c42d6c0f0.subprojects WHERE subproject_id=?;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            String title = rs.getString("title");
            Date date = rs.getDate("subproject_deadline");
            String status = rs.getString("status");
            int projectId = rs.getInt("project_id");
            sp = new Subproject(title, date, status, projectId);

            //Kan ikke sætte total_price til null i condition, så det virker nok ikke, da databasen forventes at
            // returnere null og ikke 0. Jeg vil gerne teste dette, inden jeg finder på en mere kompliceret løsning.
            if (rs.getString("description") != null){
                sp.setSubprojectDescription(rs.getString("description"));
            }

            sp.setSubprojectId(rs.getInt("subproject_id"));

        } catch(SQLException e){
            System.out.println("Couldn't get subproject with id " + id + " from database");
            System.out.println(e.getMessage());
        }
        return sp;
    }

    public void deleteSubprojectFromDatabase(int id) {
        try {
            PreparedStatement stmt = JDBC.getConnection().prepareStatement
                    ("DELETE FROM `heroku_7aba49c42d6c0f0`.`subprojects` WHERE (`subproject_id` = '" + id + "');");
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Couldn't delete subproject with id " + id + " from database");
            System.out.println(e.getMessage());
        }

    }

    //Skal jeg evt. lave if-statements til de attributter, der ikke er NN?
    public void updateSubprojectInDatabase(Subproject sp) {
        try {
            PreparedStatement stmt = JDBC.getConnection().prepareStatement
                    ("UPDATE `heroku_7aba49c42d6c0f0`.`subprojects` SET `title` = ?, " +
                            "`description` = ?, `subproject_deadline` = ?, " +
                            "`status` = ? WHERE (`subproject_id` = ?);");
            stmt.setString(1, sp.getSubprojectTitle());
            stmt.setString(2, sp.getSubprojectDescription());
            stmt.setDate(3, (Date) sp.getSubprojectDeadline());
            stmt.setString(4, sp.getSubprojectStatus());
            stmt.setInt(5, sp.getSubprojectId());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Couldn't update subproject with id " + sp.getSubprojectId() + " in database");
            System.out.println(e.getMessage());
        }

    }

}
