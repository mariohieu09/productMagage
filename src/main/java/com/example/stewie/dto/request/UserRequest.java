package com.example.stewie.dto.request;

import com.example.stewie.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest extends BaseDto {
    private String username;

    private String password;

}
