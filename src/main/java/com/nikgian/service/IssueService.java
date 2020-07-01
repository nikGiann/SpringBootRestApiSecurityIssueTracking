
package com.nikgian.service;

import com.nikgian.model.Issue;
import com.nikgian.model.User;
import java.util.List;

public interface IssueService {

    public List<Issue> findAll();

    public void save(Issue theIssue);

    public Issue findById(int issueId);

    public void deleteById(int issueId);

    public List<Issue> findAllIssuesAssigedto(User theUser);
    
    public List<Issue> findAllIssueWithStatus(String status);
}
