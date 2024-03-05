package com.boathouse.gokul.Model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.boathouse.gokul.enumerated.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
// @Getter
// @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User implements UserDetails {
    // @Id    
    // @Column(name="email", nullable = false)
    // private String email;
    
    // @Column(name="password", nullable = false)
    // private String password;

    // @Column(name="name", nullable = false)
    // private String name;

    // @Column(name="phoneno", nullable = false)
    // private String phoneno;

    // @Column(name="firstname")
    // private String firstname;

    // @Column(name="lastname")
    // private String lastname;

    // @Column(name="birthday")
    // private String birthday;

    // @Column(name="gender")
    // private String gender;

    // @Column(name="address")
    // private String address; 
    
    // @Column(name="residenttype")
    // private String residenttype; 

    // @Column(name="city")
    // private String city; 

    // @Column(name="zipcode")
    // private String zipcode; 

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;


    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
