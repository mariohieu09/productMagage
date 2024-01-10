package com.example.stewie.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseException extends RuntimeException{

    private String message;

    private int status;

    private String timestamp;


}
