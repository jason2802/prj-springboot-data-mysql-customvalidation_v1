package com.perso.customvalidation.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

/* 
 * how to use Bean Validation’s constraints to constrain the name and email fields.
 */
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@Data
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
     
    @NotBlank(message = "Name is mandatory")
    private String name;
     
    @NotBlank(message = "Email is mandatory")
    private String email;

    private String username;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public User(String name, String email, String username) {
	// TODO Auto-generated constructor stub
	this.name = name;
	this.email = email;
	this.username = username;
    }
 
    // standard constructors / setters / getters / toString
         
}