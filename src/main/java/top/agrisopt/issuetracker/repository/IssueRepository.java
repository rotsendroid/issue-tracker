package top.agrisopt.issuetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.agrisopt.issuetracker.entities.Issue;
import top.agrisopt.issuetracker.entities.User;

@Repository
public interface IssueRepository  extends JpaRepository<Issue, Long>{
	
}
