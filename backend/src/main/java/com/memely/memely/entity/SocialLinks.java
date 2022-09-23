package com.memely.memely.entity;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class SocialLinks {
   private String website;
   private String linkedin;
   private String twitter;
   private String instagram;
   private String github;
}
