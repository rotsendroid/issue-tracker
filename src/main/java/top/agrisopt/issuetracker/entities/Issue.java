package top.agrisopt.issuetracker.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "issues")
public class Issue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private String type;
	
	private String assignedTo;
	
	private String createdAt;
	
	private String lastEditAt;
	
	private String lastUserEdited;
	
	private String userCreated;
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getLastEditAt() {
		return lastEditAt;
	}

	public void setLastEditAt(String lastEditAt) {
		this.lastEditAt = lastEditAt;
	}

	public String getLastUserEdited() {
		return lastUserEdited;
	}

	public void setLastUserEdited(String lastUserEdited) {
		this.lastUserEdited = lastUserEdited;
	}

	public String getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
