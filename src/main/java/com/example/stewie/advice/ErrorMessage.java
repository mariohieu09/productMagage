package com.example.stewie.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The ErrorMessage class simplifies the process of building and conveying error information in a Spring Boot application, especially when you want to return structured and readable error messages in your APIs.
 *
 * @param <T> Generic type data relate to ErrorMessage
 * @author [mariohieu09]
 * @since [10/1/2024]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage<T> {
    /**
     * The error status
     */
    private int status;
    /**
     * The error message
     */
    private String message;

    /**
     * Type of data error message contains
     */
    T data;
}
