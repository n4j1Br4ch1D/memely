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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "memes")
@Getter
@Setter
@NoArgsConstructor
//@Builder
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")

public class Meme extends BaseEntity{
  
    @Column(name="title", unique=true)
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="img")
    private String img;
    private boolean enabled;
    private boolean story;
    private Long sharedCount;

    
    @ManyToOne
	private User user;
 
    
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "meme_tags", joinColumns = { @JoinColumn(name = "meme_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    private Collection<Tag> tags;
    
    @ManyToMany(mappedBy = "reactions", fetch = FetchType.LAZY)
	private Collection<User> reactors;
//    
//    @ManyToMany(mappedBy = "favorites", fetch = FetchType.LAZY)
//	private Collection<User> savers;
//    
    @OneToMany(mappedBy = "meme", fetch = FetchType.LAZY)	
	private Collection<Comment> comments;
//    
    @OneToMany(mappedBy = "meme", fetch = FetchType.LAZY)	
	private Collection<Mention> mentions;
//    
//    
//    @OneToMany(mappedBy = "meme", fetch = FetchType.LAZY)	
//	private Collection<Comment> reports;
    
    @ManyToMany(mappedBy = "favorites", fetch = FetchType.LAZY)
	private Collection<User> savers;
    
    
    //owner
    //tags
    //comments
    //reactions
    //mentions


    
//    @JsonManagedReference
//	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
//	@JoinTable(name = "user_permissions", joinColumns = { @JoinColumn(name = "user_id") }, 
//	inverseJoinColumns = { @JoinColumn(name = "permission_id") })
//    private Collection<Permission> permissions;
	
}
