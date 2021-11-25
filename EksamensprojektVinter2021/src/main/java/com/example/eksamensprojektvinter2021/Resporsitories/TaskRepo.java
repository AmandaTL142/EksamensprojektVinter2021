package com.example.eksamensprojektvinter2021.Resporsitories;

import com.example.eksamensprojektvinter2021.Models.Project;
import com.example.eksamensprojektvinter2021.Models.Task;
import com.example.eksamensprojektvinter2021.Utility.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRepo {

    Connection conn = JDBC.getConnection();

    public void insertNewTaskToDB(Task task){

        int projectID = getProjectId(Project project);

        String insertTaskSQL ="INSERT INTO tasks(task_id, title, description,estimated_time, " +
                "time_used, status, project_id,subproject_id) values (?,?,?,?,?,?,?,?)";


        try{
            //TODO hente et foreign key id til at indgå her i sql-statement

            PreparedStatement stmt = conn.prepareStatement(insertTaskSQL);
            stmt.setInt(1,task.getTaskID());
            stmt.setString(2,task.getTitle());
            stmt.setString(3,task.getDescription());
            stmt.setDouble(4,task.getEstimatedTime());
            stmt.setDouble(5,task.getTimeUsed());
            stmt.setString(6,task.getStatus());
            stmt.setInt(7,);
            stmt.setInt(8);

        } catch (SQLException e) {
            System.out.println("connection not found");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public int getProjectId(Project project) {
        int projectId = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT project_id FROM project WHERE title= ?");
            stmt.setString(1, String.valueOf(project.getProjectId()));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                projectId = rs.getInt(7);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
        return projectId;
    }


    public int getSubProjectId(Project project) {
        int subProjectId = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT subproject_id FROM subprojects WHERE title= ?");
            stmt.setString(1, String.valueOf(project.getProjectId()));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                subProjectId = rs.getInt(8);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
        return projectId;
    }

}
