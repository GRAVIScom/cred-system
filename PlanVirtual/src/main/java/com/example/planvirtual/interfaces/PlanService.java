package com.example.planvirtual.interfaces;

import com.example.planvirtual.dto.CredInfoDto;
import com.example.planvirtual.dto.PlanDto;

import java.util.List;

public interface PlanService {
    List<PlanDto> getPlan(int loanId);

    CredInfoDto getInfo(int loanId);
}
