package com.example.planvirtual.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlanDto extends ValidationResultDto{

    /**
     * Сумма ануитетного платежа
     */
    double annuityPayment;

    /**
     * Сумма основного долга
     */
    double mainSum;

    /**
     * Сумма процентов
     */
    double percentSum;

    /**
     *Дата платежа
     */
    String paymentDate;

    public PlanDto() {
    }

    public PlanDto(double annuityPayment, double mainSum, double percentSum, String paymentDate) {
        this.annuityPayment = annuityPayment;
        this.mainSum = mainSum;
        this.percentSum = percentSum;
        this.paymentDate = paymentDate;
    }
}
