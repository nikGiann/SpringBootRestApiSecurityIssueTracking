package com.nikgian.controller;

import com.nikgian.model.Issue;
import com.nikgian.model.User;
import com.nikgian.service.IssueService;
import com.nikgian.service.UserService;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IssueController {

    @Autowired
    IssueService issueService;

    @Autowired
    UserService userService;

    @GetMapping("/issues")
    public List<Issue> findAll() {
        return issueService.findAll();
    }

    @GetMapping("/issues/assignedto/{username}")
    public List<Issue> issuesAssignedToUser(@PathVariable String username) {

        User theUser = userService.findByUserName(username);

        return issueService.findAllIssuesAssigedto(theUser);

    }

    @GetMapping("/issues/statusissue/{status}")
    public List<Issue> issuesWithStatus(@PathVariable String status) {

        return issueService.findAllIssueWithStatus(status);

    }

    @PostMapping("/createissue")
    public Issue createIssue(
            @Valid @RequestBody Issue theIssue
    ) {

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        theIssue.setCreatedateissue(calendar.getTime());
        theIssue.setEditdateissue(calendar.getTime());

        theIssue.setUsercreateissue(getCurrentUser());
        theIssue.setLastuseredit(getCurrentUser());
        
        issueService.save(theIssue);
        return theIssue;
    }

    @DeleteMapping("/deleteissue/{issueId}")
    public String deleteIssue(@PathVariable int issueId) {

        Issue theIssue = issueService.findById(issueId);

        if (theIssue == null) {
            throw new RuntimeException("Issue id not found - " + issueId);
        }

        issueService.deleteById(issueId);

        return "Deleted issue id - " + issueId;
    }

    @PutMapping("/updateissue")
    public Issue updateIssue(@RequestBody Issue theIssue) {

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        theIssue.setEditdateissue(calendar.getTime());
        issueService.save(theIssue);
        
        
        theIssue.setLastuseredit(getCurrentUser());
        
        return theIssue;
    }
    
    
    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User currentUser = userService.findByUserName(currentPrincipalName);
        return currentUser;
    }

    
    //this is new
}
