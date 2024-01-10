package com.example.stewie.utils;

import java.time.LocalDate;
import java.util.Date;

public class DateUtils {


    public static String getCurrentDateToString(){
        return LocalDate.now().toString();
    }
}
