package org.launchcode.techjobs.mvc.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;

public class TechJobsController {

    private static HashMap<String, String> actionChoices = new HashMap<>();
    private static HashMap<String, String> columnChoices = new HashMap<>();

    public TechJobsController() {
        this.actionChoices.put("search", "Search");
        this.actionChoices.put("list", "List");

        this.columnChoices.put("all", "All");
        this.columnChoices.put("employer", "Employer");
        this.columnChoices.put("location", "Location");
        this.columnChoices.put("positionType", "Position Type");
        this.columnChoices.put("coreCompetency", "Skill");
    }


    @ModelAttribute("actions")
    public static HashMap<String, String> getActionChoices() {
        return actionChoices;
    }

    @ModelAttribute("columns")
    public static HashMap<String, String> getColumnChoices() {
        return columnChoices;
    }


}
