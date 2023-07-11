package com.example.gooty_project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gooty")
public class Gooty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "FirstName") 
    private String FirstName;

    @Column(name = "LastName")
    private String LastName;

    @Column(name = "Email")
    private String Email;

    @Column(name = "Password")
    private String Password;

    @Column(name = "ConfirmPassword")
    private String ConfirmPassword;


    public Gooty() {

    }


    public Gooty(String FirstName, String LastName, String Email, String Password, String ConfirmPassword) {
		this.FirstName = FirstName;
		this.LastName = LastName;
        this.Email = Email;
		this.Password = Password;
        this.ConfirmPassword = ConfirmPassword;
	}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
		this.LastName = LastName;
	}

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
		this.Email = Email;
	}

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
		this.Password = Password;
	}

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String ConfirmPassword) {
		this.ConfirmPassword = ConfirmPassword;
	}


    @Override
    public String toString(){
        return "gooty [id=" + id + ", FirstName=" + FirstName + ",LastName=" + LastName + ",Email=" + Email +",Password=" + Password +",ConfirmPassword=" + ConfirmPassword +"]";

    }
     

     
}

// public class Gooty {
    
// }
