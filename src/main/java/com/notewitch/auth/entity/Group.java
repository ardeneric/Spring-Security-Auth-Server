package com.notewitch.auth.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "Group_Table")
public class Group implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4583308295640633843L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "group_id")
	private String id;
	
	private String name;
	
	@NotNull
	private String createdBy;
	
	private LocalDateTime createdDate;
	
	@NotNull
	private String modifiedBy;
	
	private LocalDateTime modifiedDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "groupId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<UserGroupBridge> userGroupBridge;
}
