package com.example.planvirtual.service;

import com.example.planvirtual.dto.CredInfoDto;
import com.example.planvirtual.dto.PlanDto;
import com.example.planvirtual.interfaces.PlanService;
import com.example.planvirtual.utils.DateUtils;
import com.example.planvirtual.utils.PlanUtils;
import com.example.planvirtual.repositories.LoanOffersRepository;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PlanServiceImpl implements PlanService {
    private static final Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);

    @Autowired
    LoanOffersRepository loanOffersRepository;

    /**
     * Метод по рассчету графика платежей
     */
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
        List<PlanDto> planDtoList = new ArrayList<>(); // создаем лист DTO
        int month = 0;
        while (periods>0){
            cl.add(Calendar.MONTH, month);
            double percentPayment = PlanUtils.calcPercent(summ, rate, cl);
            double percentSum = Math.round(percentPayment * 100) / 100;
            double mainSum = Math.round((annuityPayment - percentPayment) * 100) / 100;
            String paymentDay = DateUtils.dateToString(cl.getTime());
            if (summ < annuityPayment) {
                monthPayment = summ;
            }
            else {
                monthPayment = annuityPayment;;
            }
            PlanDto planDto = buildPlanDto((Math.round(monthPayment * 100) / 100),mainSum, percentSum, paymentDay);
            planDtoList.add(planDto); // Добавляем в лист DTO по платежам текущего месяца
            summ -= monthPayment;
            month = 1;
            periods--;
            monthPayment = 0;
        }
        logger.info("Формирование графика платежей окончено");
        return planDtoList;
    }

    /**
     * Метод по получению информации о кредите
     */
    @Override
    public CredInfoDto getInfo(int loanId) {
        double summ = loanOffersRepository.getSumById(loanId);
        double limit = loanOffersRepository.getLimitById(loanId);
        double rate = loanOffersRepository.getRateById(loanId);
        Date dateLoan = loanOffersRepository.getDateById(loanId);
        double annuityPayment = PlanUtils.calcAnnuityPayment(summ,rate,limit);
        double percentSum = PlanUtils.calcPercentSum(annuityPayment, (int) limit, summ);
        CredInfoDto credInfoDto = new CredInfoDto();
        credInfoDto.setSumma(summ);
        credInfoDto.setLimit((int) limit);
        credInfoDto.setRate(rate);
        credInfoDto.setDate_payment(dateLoan.toString());
        credInfoDto.setPercentSum(percentSum);
        logger.info("Сбор информации о кредите окончен");
        return credInfoDto;
    }

    /**
     * Метод позволяющий билдить DTO для планирования
     * @param annuityPayment
     * @param mainSum
     * @param percentSum
     * @param paymentDate
     * @return
     */
    private PlanDto buildPlanDto(double annuityPayment, double mainSum, double percentSum, String paymentDate){
        PlanDto.Builder builder = new PlanDto.Builder();
        builder.setAnnuityPayment(annuityPayment)
                .setMainSum(mainSum)
                .setPercentSum(percentSum)
                .setPaymentDate(paymentDate);
        return builder.build();
    }
}
