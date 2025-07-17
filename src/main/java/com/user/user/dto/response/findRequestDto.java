package com.user.user.dto.response;

import com.user.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class findRequestDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    public static findRequestDto fromEntity(User user){
        return new findRequestDto(user.getId(),user.getName(),user.getEmail(),user.getPhoneNumber(),user.getAddress());
    }
}
