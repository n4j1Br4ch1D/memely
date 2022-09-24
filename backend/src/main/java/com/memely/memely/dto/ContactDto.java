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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import com.memely.memely.entity.Tag;
import com.memely.memely.entity.Token;
import com.memely.memely.entity.User;
import com.memely.memely.enums.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto {
	private Long id;  
    private String name;  
    private String email;   
    private Boolean seen;   
    private String message;    
}
