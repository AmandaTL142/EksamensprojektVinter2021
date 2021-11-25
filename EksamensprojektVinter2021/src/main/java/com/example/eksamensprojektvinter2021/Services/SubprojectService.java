package com.example.eksamensprojektvinter2021.Services;

import com.example.eksamensprojektvinter2021.Models.Subproject;
import com.example.eksamensprojektvinter2021.Resporsitories.SubprojectRepo;

import java.util.Date;

public class SubprojectService {

    SubprojectRepo spr = new SubprojectRepo();

    public void createNewSubproject(String title, Date deadline, String status, int projectId) {
        Subproject sp = new Subproject(title, deadline, status, projectId);
        spr.insertSubprojectIntoDatabase(sp);
    }

    //Jeg har ikke integreret, hvordan metoden får ændringerne fra brugeren.
    public void updateSubproject(Subproject sp, String title, String description, Date subprojectDeadline, String status) {
        sp.setSubprojectTitle(title);
        sp.setSubprojectDescription(description);
        sp.setSubprojectDeadline(subprojectDeadline);
        sp.setSubprojectStatus(status);
        spr.updateSubprojectInDatabase(sp);
    }

    public Subproject showSubproject (int subprojectId) {
        return spr.getSubprojectFromDatabase(subprojectId);
    }
}
