package com.memely.memely.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.memely.memely.enums.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
//@Builder
public class User {
  
	@Id
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(name="username", unique=true)
    private String username;
    @Column(name="full_name")
    private String fullName;
    @Column(name="description")
    private String description;
	private String email;
    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(unique=true)
    @JsonIgnore
    @Schema(format = "password")
	private String password;
    @Schema(description="Role of User")
//    @Enumerated(EnumType.STRING)
    private String role;
    private boolean active;
    private boolean enabled;
    private SocialLinks socialLinks;

    
//    @JsonManagedReference
//	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
//	@JoinTable(name = "user_permissions", joinColumns = { @JoinColumn(name = "user_id") }, 
//	inverseJoinColumns = { @JoinColumn(name = "permission_id") })
//    private Collection<Permission> permissions;
	
}
