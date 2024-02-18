package com.example.planvirtual.service;

import com.example.planvirtual.dto.PlanDto;
import com.example.planvirtual.interfaces.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlanController {
    private final PlanService planService;

    @Autowired
    public  PlanController(PlanService planService){
        this.planService = planService;
    }

    @QueryMapping(value = "getPlan")
    public List<PlanDto> getPlan(@Argument Integer loanId){
        return planService.getPlan(loanId);
    }
}
