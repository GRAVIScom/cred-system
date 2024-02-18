package com.example.planvirtual.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlanDto extends ValidationResultDto{

    /**
     * Сумма ануитетного платежа
     */
    String annuityPayment;

    /**
     * Сумма основного долга
     */
    String mainSum;

    /**
     * Сумма процентов
     */
    String percentSum;

    /**
     *Дата платежа
     */
    String paymentDate;

    public PlanDto() {
    }

    public static class Builder {
        PlanDto planDto;

        public Builder(){
            planDto = new PlanDto();
        }

        public Builder setAnnuityPayment(@NotBlank String annuityPayment){
            this.planDto.annuityPayment = annuityPayment;
            return this;
        }
        public Builder setMainSum(@NotBlank String mainSum){
            this.planDto.mainSum = mainSum;
            return this;
        }
        public Builder setPercentSum(@NotBlank String percentSum){
            this.planDto.percentSum = percentSum;
            return this;
        }
        public Builder setPaymentDate(@NotBlank String paymentDate){
            this.planDto.paymentDate = paymentDate;
            return this;
        }

        public PlanDto build() {
            return planDto;
        }
    }
}
