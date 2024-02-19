package com.example.planvirtual.service;

import com.example.planvirtual.dto.PlanDto;
import com.example.planvirtual.interfaces.PlanService;
import com.example.planvirtual.planUtils.PlanUtils;
import com.example.planvirtual.repositories.LoanOffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    LoanOffersRepository loanOffersRepository;
    @Override
    public List<PlanDto> getPlan(int loanId){
        Calendar cl = Calendar.getInstance();
        double summ = loanOffersRepository.getSumById(loanId);
        double limit = loanOffersRepository.getLimitById(loanId);
        double rate = loanOffersRepository.getRateById(loanId);
        Date dateLoan = loanOffersRepository.getDateById(loanId);
        cl.setTime(dateLoan);
        double annuityPayment = PlanUtils.calcAnnuityPayment(summ,rate,limit);
        double monthPayment = 0;
        int periods = (int) (summ / annuityPayment); // подсчитаем кол-во платежей по кредиту
        List<PlanDto> planDtoList = new ArrayList<>();
        int month = 0;
        while (periods>0){
            cl.add(Calendar.MONTH, month);
            double percentPayment = PlanUtils.calcPercent(summ, limit, cl);
            String percentSum = String.valueOf(Math.round(percentPayment * 100) / 100);
            String mainSum = String.valueOf(Math.round((annuityPayment - percentPayment) * 100) / 100);
            String paymentDay = cl.getTime().toString();
            if (summ < annuityPayment) {
                monthPayment = summ;
            }
            else {
                monthPayment = annuityPayment;;
            }
            PlanDto planDto = buildPlanDto(String.valueOf(Math.round(monthPayment * 100) / 100),mainSum,percentSum,paymentDay);
            planDtoList.add(planDto);
            summ -= monthPayment;
            month = 1;
            periods--;
            monthPayment = 0;
        }
        return planDtoList;
    }

    private PlanDto buildPlanDto(String annuityPayment, String mainSum, String percentSum, String paymentDate){
        PlanDto.Builder builder = new PlanDto.Builder();
        builder.setAnnuityPayment(annuityPayment)
                .setMainSum(mainSum)
                .setPercentSum(percentSum)
                .setPaymentDate(paymentDate);
        return builder.build();
    }
}
