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

    //Jeg har ikke integreret, hvordan metoden får ændringerne fra brugeren.
    public void updateProject(Project p, String name, Date projectDeadline, String status, double basePrice,
                              int costumerId, int managerId, String description) {
        p.setName(name);
        p.setProjectDeadline(projectDeadline);
        p.setStatus(status);
        p.setBasePrice(basePrice);
        p.setCustomerId(costumerId);
        p.setManagerId(managerId);
        p.setDescription(description);
        pr.updateProjectInDatabase(p);
    }

}
