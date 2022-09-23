package com.memely.memely.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "mentions")
public class Mention extends BaseEntity{
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(columnDefinition="integer", name="meme_id", nullable =true)
	private Meme meme;
	
	@JsonIgnore
	@ManyToOne(optional = true)
	@JoinColumn(columnDefinition="integer", name="comment_id", nullable =true)
	private Comment comment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "taggeduser_id")
	private User user;

}
