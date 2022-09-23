package com.memely.memely.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{
	private String comment;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "meme_id")
	private User user;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Meme meme;
	
	@JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)	
	private Collection<Comment> comments;

//	@JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)	
	private Collection<Mention> mentions;
	
}
