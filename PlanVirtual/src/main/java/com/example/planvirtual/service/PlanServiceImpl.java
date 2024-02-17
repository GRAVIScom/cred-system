package com.example.planvirtual.service;

import com.example.planvirtual.dto.PlanDto;
import com.example.planvirtual.entities.Loan_offers;
import com.example.planvirtual.interfaces.PlanService;
import com.example.planvirtual.planUtils.PlanUtils;
import com.example.planvirtual.repositories.LoanOffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    LoanOffersRepository loanOffersRepository;

    @Override
    public PlanDto getPlan(int loanId){
        System.out.println(loanId);
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
            planDto.setPaymentDate(cl.getTime().toString());
            summ -= annuityPayment;
            month++;
        }
        return planDto;
    }
}
