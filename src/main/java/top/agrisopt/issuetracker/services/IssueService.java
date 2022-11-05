package top.agrisopt.issuetracker.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.agrisopt.issuetracker.entities.Issue;
import top.agrisopt.issuetracker.repository.IssueRepository;

@Service
public class IssueService {
	
	@Autowired
	IssueRepository issueRepository;
	
	List<Issue> issues = Arrays.asList();
	
	public List<Issue> getAllIssues() {
		List<Issue> issues = new ArrayList<>();
		issueRepository.findAll().forEach(issue -> issues.add(issue));
		
		return issues;
	}
	
	public Issue getAnIssue(Long id) {
		Optional<Issue> tempIssue = issueRepository.findById(id);
		
		try {
			return tempIssue.get();
		} catch (NoSuchElementException e) {
			return null;
		}
		
	}
	
	public Issue getIssueById(Long id) {
		return issueRepository.findById(id).get();
	}
	
	public boolean saveOrUpdateIssue(Issue issue) {
		Issue myIssue = issueRepository.save(issue);
		
		if (issueRepository.findById(myIssue.getId()) != null) {
			return true;
		}
		
		return false;
		
	}
	
	public boolean deleteIssue(Long id) {
		issueRepository.deleteById(id);	
		if (issueRepository.findById(id) != null) {
			return true;
		}
		
		return false;
	
	}
	
}
