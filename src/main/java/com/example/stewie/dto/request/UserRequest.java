package com.example.stewie.dto.request;

import com.example.stewie.dto.base.BaseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The data transfer object that contains user information such as username and password,...
 *
 * @author [mariohieu09]
 * @since [9/1/2024]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest extends BaseDto {

    /**
     * The unique username associated with the user.
     */
    @NotBlank
    @NotNull
    @Size(min = 6, max = 15, message = "Username must be over 6 characters long and under 15 characters")
    private String username;

    /**
     * The encoded string representation associated with the user.
     * This string must follow the regex rule, at least 1 special character, 1 number, 1 Uppercase character
     * and have at least 6 characters long
     */

    @Pattern(regexp = "^(?=.*[!@#$%^&*()-_+=])(?=.*[A-Z])(?=.*[0-9]).{6,}$")
    private String password;

}
