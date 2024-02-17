package com.example.planvirtual.service;

import com.example.planvirtual.dto.PlanDto;
import com.example.planvirtual.interfaces.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PlanController {
    private final PlanService planService;

    @Autowired
    public  PlanController(PlanService planService){
        this.planService = planService;
    }

    @QueryMapping(value = "getPlan")
    public PlanDto getPlan(@Argument Integer loanId){
        return planService.getPlan(loanId);
        /*System.out.println(loanId);
        PlanDto planDto = new PlanDto();
        Calendar cl = Calendar.getInstance();
        Optional<Loan_offers> eqw = loanOffersRepository.getAllByClientId(12L);
        System.out.println("eqw = " + eqw);
        double summ = loanOffersRepository.getSumById(loanId);
        Long limit = loanOffersRepository.getLimitById(loanId);
        double rate = loanOffersRepository.getRateById(loanId);
        Date dateLoan = loanOffersRepository.getDateById(loanId);
        cl.setTime(dateLoan);
        double annuityPayment = PlanUtils.calcAnnuityPayment(summ,rate,limit);
        double periods = Math.ceil(summ / annuityPayment); // подсчитаем кол-во платежей по кредиту
        //double remainder = summ;
        int month = 0;
        for(int i = 0; i < periods; i++){
            if (summ < annuityPayment) {
                planDto.setAnnuityPayment(summ); // сделано для последних платежей по кредиту, когда остаток меньше аннуитета
            }
            else {
                planDto.setAnnuityPayment(annuityPayment);
            }
            cl.add(Calendar.MONTH, month);
            double percentPayment = PlanUtils.calcPercent(summ, limit, cl);
            planDto.setPercentSum(percentPayment);
            planDto.setMainSum(annuityPayment - percentPayment);
            planDto.setDebtDate(cl.getTime().toString());
            summ -= annuityPayment;
            month++;
        }
        return planDto;*/
    }
}
