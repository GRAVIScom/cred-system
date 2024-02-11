package com.example.planvirtual.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlanDto extends ValidationResultDto{
    /**
     * Код вида задолженности (Основной долг или проценты)
     */
    String debtCode;

    /**
     * Сумма задолженности
     */
    int debtSum;

    /**
     *
     */
}
