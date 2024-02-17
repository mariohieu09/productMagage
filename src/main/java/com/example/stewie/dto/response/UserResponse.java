package com.example.stewie.dto.response;

import com.example.stewie.dto.base.BaseDto;
import com.example.stewie.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author [mariohieu09]
 * @since [9/1/2024]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse extends BaseDto {


    private Long id;

    private Date createdAt;
    private String username;
    private UserRole userRole;

}
