package com.memely.memely.dto;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.memely.memely.entity.Comment;
import com.memely.memely.entity.Contact;
import com.memely.memely.entity.Meme;
import com.memely.memely.entity.Mention;
import com.memely.memely.entity.Message;
import com.memely.memely.entity.Notification;
import com.memely.memely.entity.Report;
import com.memely.memely.entity.SocialLinks;
import com.memely.memely.entity.Token;
import com.memely.memely.entity.User;
import com.memely.memely.enums.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	    @NotNull
	 	private Long id;
		@NotEmpty
	    @Schema(description="FirstName should not be blank",required = true,example = "Suresh")
		@Column(unique=true)
	    private String username;
		@NotNull
	    private String fullName;
		@NotNull
	    private String avatar;
	    private String description;
		@NotEmpty
		@Column(unique=true)
		private String email;
		@NotEmpty
//		@JsonIgnore
		private String password;
		@Enumerated(EnumType.STRING)
		private Role role;
		@NotNull
	    private boolean enabled;
	    private boolean active;
	    private Long followersCount;
	    private SocialLinks socialLinks;
	    
	    private Boolean followed;
	    
	    private Boolean following;
	    
//		private Collection<Meme> memes;
//
//	    private Collection<Meme> reactions;
//
//	    private Collection<Meme> favorites;
//		
//		private Collection<Comment> comments;
//	    
//		private Collection<Mention> mentions;
//	    
//	    private Collection<User> followers;
//
//	    private Collection<User> followings;
//		
//		private Collection<Notification> notifications;	
//
//		private Collection<Message> messagesSent;
//
//		private Collection<Message> messagesRecived;
//
//		private Collection<Contact> contacts;
//		
//		private Collection<Report> reports;
//
//	    private Token token;
	    
		public void setPassword(String password) {
			this.password = new BCryptPasswordEncoder().encode(password);
	        //user.setPassword(new BCryptPasswordEncoder().encode(password));

		}

	    
//
//	    // title should not be null  or empty
//	    // title should have at least 2 characters
//	    @ApiModelProperty(value = "Blog post title")
//	    @NotEmpty
//	    @Size(min = 2, message = "Post title should have at least 2 characters")
//	    private String title;
//
//	    // post description should be not null or empty
//	    // post description should have at least 10 characters
//	    @ApiModelProperty(value = "Blog post description")
//	    @NotEmpty
//	    @Size(min = 10, message = "Post description should have at least 10 characters")
//	    private String description;
//
//	    // post content should not be null or empty
//	    @ApiModelProperty(value = "Blog post conent")
//	    @NotEmpty
//	    private String content;
//
//	    @ApiModelProperty(value = "Blog post comments")
//	    private Set<CommentDto> comments; 
}
