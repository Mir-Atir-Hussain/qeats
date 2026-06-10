package com.jsp.qeats.userModule.model;

import com.jsp.qeats.resturantModule.model.Resturant;
import com.jsp.qeats.userModule.dto.UserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name="user-seq",allocationSize=1, initialValue = 1000)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String email;
    private long phone;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean active;

    @OneToOne(mappedBy="manager")
    private Resturant resturant;


    public User(UserRequest userRequest){
        this.name=userRequest.getName();
        this.email=userRequest.getEmail();
        this.phone=userRequest.getPhone();
    }
}
