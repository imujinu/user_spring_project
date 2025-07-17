package com.user.user.dto.request;

import com.user.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userCreateRequest {
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;

    public User createToEntity(){
        return new User(name,password,email,phoneNumber,address);
    }
}
