package com.example.eksamensprojektvinter2021.Services;

import com.example.eksamensprojektvinter2021.Models.Project;
import com.example.eksamensprojektvinter2021.Resporsitories.ProjectRepo;

import java.util.Date;

public class ProjectService {
    ProjectRepo pr = new ProjectRepo();

    public void createNewProject(String title, Date projectDeadline, String status, double basePrice,
                                 int customerId, int managerId) {
        Project p = new Project(title, projectDeadline, status, basePrice, customerId, managerId);
        pr.insertProjectIntoDatabase(p);
    }

    //Jeg har ikke integreret, hvordan metoden får ændringerne fra brugeren.
    public void updateProject(Project p, String title, Date projectDeadline, String status, double basePrice,
                              int costumerId, int managerId, String description) {
        p.setProjectTitle(title);
        p.setProjectDeadline(projectDeadline);
        p.setStatus(status);
        p.setBasePrice(basePrice);
        p.setCustomerId(costumerId);
        p.setManagerId(managerId);
        p.setDescription(description);
        pr.updateProjectInDatabase(p);
    }

    public Project showProject (int projectId) {
        return pr.getProjectFromDatabase(projectId);
    }

}
