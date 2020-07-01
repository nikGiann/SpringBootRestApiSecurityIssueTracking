
package com.nikgian.repos;

import com.nikgian.model.Issue;
import com.nikgian.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IssueRepository extends JpaRepository<Issue, Integer> {
    
    List<Issue> findByAssignedto(User theUser);
    
    List<Issue> findByStatusissue(String status);
}
