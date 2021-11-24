package com.example.eksamensprojektvinter2021.Services;

import com.example.eksamensprojektvinter2021.Models.Project;
import com.example.eksamensprojektvinter2021.Resporsitories.ProjectRepo;

import java.util.Date;

public class ProjectService {
    ProjectRepo pr = new ProjectRepo();

    public void createNewProject(String name, Date projectDeadline, String status, double basePrice,
                                 int customerId, int managerId) {
        Project p = new Project(name, projectDeadline, status, basePrice, customerId, managerId);
        pr.insertProjectIntoDatabase(p);
    }



}
