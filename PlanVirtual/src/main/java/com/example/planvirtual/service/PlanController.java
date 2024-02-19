package com.example.planvirtual.service;

import com.example.planvirtual.dto.CredInfoDto;
import com.example.planvirtual.dto.PlanDto;
import com.example.planvirtual.interfaces.PlanService;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class PlanController {
    private static final Logger logger = LoggerFactory.getLogger(PlanController.class);
    private final PlanService planService;

    @Autowired
    public  PlanController(PlanService planService){
        this.planService = planService;
    }

    @QueryMapping(value = "getPlan")
    public List<PlanDto> getPlan(@Argument Integer loanId){
        logger.info("Начат процесс рассчета графика платежей для кредита с id = " + loanId);
        return planService.getPlan(loanId);
    }

    @QueryMapping(value = "getInfo")
    public CredInfoDto getInfo(@Argument Integer loanId){
        logger.info("Начат процесс сбора информации по кредиту с id = " + loanId);
        return planService.getInfo(loanId);
    }
}
