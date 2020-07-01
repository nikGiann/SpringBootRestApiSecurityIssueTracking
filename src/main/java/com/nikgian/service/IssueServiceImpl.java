
package com.nikgian.service;

import com.nikgian.model.Issue;
import com.nikgian.model.User;
import com.nikgian.repos.IssueRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;
    
    @Override
    public List<Issue> findAll() {
        return issueRepository.findAll();
    }
    
    @Override
    public List<Issue> findAllIssuesAssigedto(User theUser) {
        return issueRepository.findByAssignedto(theUser);
                
    }
    
    @Override
    public List<Issue> findAllIssueWithStatus(String status) {
        return issueRepository.findByStatusissue(status);
    }

    @Override
    public void save(Issue theIssue) {
        issueRepository.save(theIssue);
    }

    @Override
    public Issue findById(int issueId) {
    
		Optional<Issue> result = issueRepository.findById(issueId);
		
		Issue theIssue = null;
		
		if (result.isPresent()) {
			theIssue = result.get();
		}
		else {
			
			throw new RuntimeException("Did not find Issue id - " + issueId);
		}
		
		return theIssue;
	}

    @Override
    public void deleteById(int issueId) {
        issueRepository.deleteById(issueId);
    }
 
}
