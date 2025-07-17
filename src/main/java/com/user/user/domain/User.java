package com.user.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(unique = true)
    private String email;
    @Column(length = 15, unique = true)
    private String phoneNumber;
    private String address;
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean leaveYn;
    @CreationTimestamp
    private LocalDateTime createdTime;

    public User(String name, String password, String email, String phoneNumber, String address) {
        this.name=name;
        this.password=password;
        this.email =email;
        this.phoneNumber =phoneNumber;
        this.address=address;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public void leave(){
        this.leaveYn = true;
    }
}
