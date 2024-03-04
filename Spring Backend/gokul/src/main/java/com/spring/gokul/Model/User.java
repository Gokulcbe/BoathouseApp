package com.spring.gokul.Model;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="email", nullable = false)
    private String email;
    
    @Column(name="password", nullable = false)
    private String password;


    // public String getEmail() {
	// 	return email;
	// }
	
	// public void setEmail(String email) {
	// 	this.email = email;
	// }

    // public String getPassword() {
	// 	return password;
	// }
	
	// public void setPassword(String password) {
	// 	this.password = password;
	// }

    // public String getRole() {
	// 	return role;
	// }
	
	// public void setRole(String role) {
	// 	this.role = role;
	// }

    // public String getPhoneNo() {
	// 	return phoneno;
	// }
	
	// public void setPhoneNo(String phoneno) {
	// 	this.phoneno = phoneno;
	// }

    // public User(String email, String password, String role, String phoneno){
    //     super();
    //     this.email = email;
    //     this.password = password;
    //     this.role = role;
    //     this.phoneno = phoneno;
    // }

    // public User(){
        
    // }
    
}
