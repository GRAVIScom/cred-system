package com.example.planvirtual.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CredInfoDto extends ValidationResultDto {
    /**
     * Срок кредита в месяцах
     */
    int limit;
    /**
     * Переплата по процентам
     */
    double percentSum;
    /**
     * Сумма кредита
     */
    double summa;
    /**
     * Процентная ставка по кредиту
     */
    double rate;
    /**
     * Дата выдачи кредита
     */
    String date_payment;
}
