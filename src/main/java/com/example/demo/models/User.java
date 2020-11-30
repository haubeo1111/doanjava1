package com.example.demo.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user1")
public class User implements Serializable{
	 

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "password")
	    private String password;
	 
	    @ManyToMany(fetch = FetchType.EAGER) 
	    @JoinTable(name = "user_role", 
	      joinColumns = 
	        @JoinColumn(name = "user_id", referencedColumnName = "id"),
	      inverseJoinColumns = 
	        @JoinColumn(name = "role_id", referencedColumnName = "id")) 
	    private Set<Role> roles;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public Set<Role> getRoles() {
	        return roles;
	    }

	    public void setRoles(Set<Role> roles) {
	        this.roles = roles;
	    }
	 
	    
}
