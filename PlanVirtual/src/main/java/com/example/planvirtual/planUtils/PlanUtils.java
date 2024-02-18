package com.example.planvirtual.planUtils;

import java.util.Calendar;

public class PlanUtils {
    /**
     * Функция для расчета аннуитетного платежа
     * @param credSum - сумма кредита
     * @param rate - процентная ставка
     * @param limit - срок кредита
     * @return annuityPayment
     */
    public static double calcAnnuityPayment(double credSum, double rate, double limit){
        double monthRate = rate / 12 / 100; // Рассчитаем месячную процентную ставку
        System.out.println(monthRate);
        double annuityPayment;
        annuityPayment = ((monthRate * Math.pow((1 + monthRate), limit))/(Math.pow((1 + monthRate),limit) - 1)) * credSum;
        System.out.println(annuityPayment);
        return Math.round(annuityPayment);
    }

    /**
     * Функция для расчета процентов по платежу
     * @param remainder - остаток долга
     * @param rate - процентная ставка по кредиту
     */
    public static double calcPercent(double remainder, double rate, Calendar cl){
        int dayOfMnth = cl.getActualMaximum(Calendar.DAY_OF_MONTH); //Получить количество дней в месяце
        int dayOfYear = cl.getActualMaximum(Calendar.DAY_OF_YEAR); //Получить количество дней в году
        return (remainder * rate / 100 * ((double) dayOfMnth / dayOfYear));
    }
}
