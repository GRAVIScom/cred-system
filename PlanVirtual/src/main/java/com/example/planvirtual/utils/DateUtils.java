package com.example.planvirtual.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * Метод преобразования из Date в String c форматом yyyy-MM-dd
     * @param paymentDay
     */
    public static String dateToString(Date paymentDay){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(paymentDay);
    }
}
