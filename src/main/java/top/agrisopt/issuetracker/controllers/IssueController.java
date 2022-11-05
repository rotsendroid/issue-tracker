package top.agrisopt.issuetracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import top.agrisopt.issuetracker.services.IssueService;
import top.agrisopt.issuetracker.services.UserService;
import top.agrisopt.issuetracker.entities.Issue;
import top.agrisopt.issuetracker.entities.User;

import java.util.List;

@Controller
public class IssueController {
	
	@Autowired
	IssueService issueService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/add-issue")
	public String addIssue(@ModelAttribute("message") String message, Model model) {
		Issue issue = new Issue();
		List<User> users = userService.getAllUsers();
		model.addAttribute("issue", issue);
		model.addAttribute("users", users);
		model.addAttribute("message", message);
		return "add_issue";
	}
	
	@PostMapping("/post-issue")
	public String postIssue(Issue issue, RedirectAttributes redirectAttributes) {
		if (issueService.saveOrUpdateIssue(issue)) {
			redirectAttributes.addFlashAttribute("message", "Saved Successfully!");
			return "redirect:/issues";
		}
		
		return "redirect:/add_issue";
	}
	
	@GetMapping("/issues")
	public String findAllIssues(@ModelAttribute("message") String message, Model model) {
		List<Issue> issues = issueService.getAllIssues();
		
		model.addAttribute("issues", issues);
		model.addAttribute("message", message);
		return "issues";
	}
	
	@GetMapping("/view-issue/{id}")
	public String findAnIssue(@PathVariable Long id, @ModelAttribute("message") String message, Model model) {
		Issue issue = issueService.getAnIssue(id);
		
		if (issue != null) {
			model.addAttribute("issue", issue);
			model.addAttribute("message", message);
			return "view_issue";
		}
		
		return "issues";
	}
	
	@GetMapping("/edit-issue/{id}")
	public String editIssue(@PathVariable Long id, @ModelAttribute("message") String message, Model model) {
		Issue issue = issueService.getIssueById(id);
		List<User> users = userService.getAllUsers();
		model.addAttribute("issue", issue);
		model.addAttribute("users", users);
		model.addAttribute("message", message);
		
		return "edit_issue";
	}
	
	@PostMapping("/post-edit-issue")
	public String postEditIssue(@ModelAttribute("issue") Issue issue, RedirectAttributes redirectAttributes) {
		if (issueService.saveOrUpdateIssue(issue)) {
			redirectAttributes.addFlashAttribute("message", "Edited Successfully.");
			return "redirect:/issues";
		}
		
		redirectAttributes.addFlashAttribute("message", "Edit failed.");
		return "redirect:/edit_issue";
	}
	
	@GetMapping("/delete-issue/{id}")
	public String deleteIssue(@PathVariable Long id,  RedirectAttributes redirectAttributes) {
		if (issueService.deleteIssue(id)) {
			redirectAttributes.addFlashAttribute("message", "Deleted successfully.");
			return "redirect:/issues";
		}
		
		redirectAttributes.addFlashAttribute("message", "Deletion failed.");
		return "redirect:/issues";
	}
	
	
	
}
