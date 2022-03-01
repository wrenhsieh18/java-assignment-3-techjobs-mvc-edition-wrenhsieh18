package org.launchcode.techjobs.mvc.controllers;

import org.launchcode.techjobs.mvc.models.Job;
import org.launchcode.techjobs.mvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController extends TechJobsController {

    @GetMapping(value = "")
    public String search(Model model) {
//        model.addAttribute("columns", columnChoices);
        model.addAttribute("searchType", "all");
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        List<Job> jobs;
        if (searchTerm.equals("all") || searchTerm == null || searchTerm.isEmpty()) {
            jobs = JobData.findAll();
        } else if ( !searchType.equals("all") ) {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        } else {
            jobs = JobData.findByValue(searchTerm);
        }
        model.addAttribute("jobs", jobs);
//        model.addAttribute("columns", columnChoices);
        model.addAttribute("searchType", searchType);
        return "search";
    }


}
