package com.user.user.dto.response;

import com.user.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class findAllRequestDto {
    private Long id;
    private String name;

    public static findAllRequestDto fromEntity(User user){
        return new findAllRequestDto(user.getId(),user.getName());
    }
}
