package com.example.eksamensprojektvinter2021.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LoginController {
    //Her laver vi noget log-in logik
    //Benyt sessions
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(WebRequest wr, HttpSession session) throws SQLException {
        String name = wr.getParameter("name");
        String password = wr.getParameter("password");

        //Evaluer hvis login matcher database
        //boolean validPass = LogingService.login(id, password);

        //Sæt en bruger som enten Manager eller Medarbejder allerede ved login
        //if (validPass) {
            //int userId = LoginService.findUserId(name, password);
            //session.setAttribute("id", userId);
            //if (isManager.userId) {
            //session.setAttribute ("manager", true)
            //}
            //return "redirect:/show-projects";
        //}
        //else {
            return "login";
        //}
    }
}
