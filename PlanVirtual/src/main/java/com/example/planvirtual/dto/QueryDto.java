package com.example.planvirtual.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QueryDto {

    Long summ;
    Long limit;
    double rate;
    String paymentDate;

    public QueryDto(Long summ, Long limit, double rate, String paymentDate) {
        this.summ = summ;
        this.limit = limit;
        this.rate = rate;
        this.paymentDate = paymentDate;
    }

}
