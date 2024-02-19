package com.example.planvirtual.utils;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

@Slf4j
public class PlanUtils {
    private static final Logger logger = LoggerFactory.getLogger(PlanUtils.class);
    /**
     * Функция для расчета аннуитетного платежа
     * @param credSum - сумма кредита
     * @param rate - процентная ставка
     * @param limit - срок кредита месяцах
     * @return annuityPayment
     */
    public static double calcAnnuityPayment(double credSum, double rate, double limit){
        double monthRate = rate / 12 / 100; // Рассчитаем месячную процентную ставку
        double annuityPayment;
        annuityPayment = ((monthRate * Math.pow((1 + monthRate), limit))/(Math.pow((1 + monthRate),limit) - 1)) * credSum;
        logger.info("Аннуитет по кредиту равен " +  Math.round(annuityPayment));
        return Math.round(annuityPayment);
    }

    /**
     * Функция для расчета процентов по платежу
     * @param remainder - остаток долга
     * @param rate - процентная ставка по кредиту
     * @return проценты по платежу
     */
    public static double calcPercent(double remainder, double rate, Calendar cl){
        int dayOfMnth = cl.getActualMaximum(Calendar.DAY_OF_MONTH); //Получить количество дней в месяце
        int dayOfYear = cl.getActualMaximum(Calendar.DAY_OF_YEAR); //Получить количество дней в году
        return (remainder * rate / 100 * ((double) dayOfMnth / dayOfYear));
    }

    /**
     * Функция по рассчету переплаты по процентам
     * @param annuityPayment - ежемесячный платеж
     * @param limit - срок кредита в месяцах
     * @param remainder - сумма кредита
     */
    public static double calcPercentSum(double annuityPayment, int limit, double remainder){
        logger.info("Сумма процентов равна " + (annuityPayment * limit - remainder));
        return annuityPayment * limit - remainder;
    }
}
