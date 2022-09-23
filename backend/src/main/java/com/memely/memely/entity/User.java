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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id", scope = User.class)
public class User extends BaseEntity{
  

    @Column(name="username", unique=true)
    private String username;
    @Column(name="full_name")
    private String fullName;
    private String avatar;
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

    private Long followersCount;
    private SocialLinks socialLinks;

    
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id", nullable = false, columnDefinition = "integer")
	
//    @OneToMany(mappedBy="user")
//	private Collection<Meme> memes;

    
    @JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "reactions", joinColumns = { @JoinColumn(name = "user_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "meme_id") })
    private Collection<Meme> reactions;
	
    @JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "favorites", joinColumns = { @JoinColumn(name = "user_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "meme_id") })
    private Collection<Meme> favorites;
	
    @JsonIgnore
    @OneToMany(mappedBy = "meme")
	private Collection<Comment> comments;
    
    @JsonIgnore
    @OneToMany(mappedBy = "meme")
	private Collection<Mention> mentions;
    
    @JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "followers", joinColumns = { @JoinColumn(name = "follower_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "followed_id") })
    private Collection<User> followers;
    
    @JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "followers", joinColumns = { @JoinColumn(name = "followed_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "follower_id") })
    private Collection<User> followings;
	
    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = true, columnDefinition = "integer")
	private Collection<Notification> notifications;
	
    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sender_id", nullable = true, columnDefinition = "integer")
	private Collection<Message> messagesSent;
	
    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "reciver_id", nullable = true, columnDefinition = "integer")
	private Collection<Message> messagesRecived;
	
    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = true, columnDefinition = "integer")
	private Collection<Contact> contacts;
	
    @JsonIgnore
    @OneToMany(mappedBy = "user")
	private Collection<Report> reports;
    
    @JsonIgnore
    @OneToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "token_id", nullable = true, columnDefinition = "integer")
    private Token token;
}
