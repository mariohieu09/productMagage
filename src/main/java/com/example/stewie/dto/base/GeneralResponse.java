package com.example.stewie.dto.base;

import com.example.stewie.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.DateTimeUtils;

import java.util.Date;

/**
 *
 *
 * @param <T> Generic type relate to General Response
 * @author [mariohieu09]
 * @since [10/1/2024]
 */
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GeneralResponse <T>{

    private int status;
    private T data;

    private String message;

    private String timestamp;

    public static <T> GeneralResponse<T> of(int status, T data, String message){
        return GeneralResponse.of(status, data, message, DateUtils.getCurrentDateToString());
    }

    public static <T> GeneralResponse<T> ofSuccess(T data, String message){
        return GeneralResponse.of(200, data, message, DateUtils.getCurrentDateToString());
    }

    public static <T> GeneralResponse<T> ofCreate(T data, String message){
        return GeneralResponse.of(201, data, message, DateUtils.getCurrentDateToString());
    }
}
