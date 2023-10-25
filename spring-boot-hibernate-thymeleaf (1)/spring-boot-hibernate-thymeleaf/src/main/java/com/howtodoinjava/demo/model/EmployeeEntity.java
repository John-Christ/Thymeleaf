package com.howtodoinjava.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.Valid;

@Valid
@Entity
@Table(name="TBL_EMPLOYEES")
public class EmployeeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


	@NotNull
    @Column(name="first_name")
    private String firstName;
    
   @NotNull(message="Please, enter your Last Name")
   @Size(min=2, max=30)
    @Column(name="last_name")
    private String lastName;
    
  // @Email(message="Please, enter a valid email")
   @NotNull(message="Please, enter your email")
   @Column(name="email", nullable=false, length=200)
    private String email;



    @NotNull(message="Please, enter your Phone Number")
    @Column(name="phone")
	private String phone;




    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	//Add getMeth
	public String getPhone () { return phone;}


	//Add setMeth
	public void setPhone(String phone) {this.phone = phone; }



	@Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email   + ", phone=" + phone +"]";
    }
}