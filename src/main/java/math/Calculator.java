package math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public final class Calculator {
    private static MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
    public static double add(double a, double b){
        BigDecimal paramOne = BigDecimal.valueOf(a);
        BigDecimal paramTwo = BigDecimal.valueOf(b);
        double result = paramOne.add(paramTwo).doubleValue();
        return result;
    }

    public static double subst(double a, double b){
        BigDecimal paramOne = BigDecimal.valueOf(a);
        BigDecimal paramTwo = BigDecimal.valueOf(b);
        double result = paramOne.subtract(paramTwo).doubleValue();
        return result;
    }

    public static double div(double a, double b){
        BigDecimal paramOne = BigDecimal.valueOf(a);
        BigDecimal paramTwo = BigDecimal.valueOf(b);
        double result = paramOne.divide(paramTwo, mc).doubleValue();
        return result;
    }

    public static double mult(double a, double b){
        BigDecimal paramOne = BigDecimal.valueOf(a);
        BigDecimal paramTwo = BigDecimal.valueOf(b);
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
        double result = paramOne.multiply(paramTwo,mc).doubleValue();
        return result;
    }
    public static double mathOperation(char operator, double a, double b){
        switch (operator){
            case '+': return  add(a,b);
            case '-': return  subst(a,b);
            case '*': return  mult(a,b);
            case '/': return  div(a,b);
        }
        return Double.NaN;//ОШИБКА!!!!
    }

    public static double pars(String[] str){
        char operator = str[0].charAt(0);
        double paramOne = Double.parseDouble(str[1]);
        double paramTwo = Double.parseDouble(str[2]);
        double result = mathOperation(operator,paramOne,paramTwo);
        System.out.println("Калькулятор: " +
                paramOne +" " + operator + " " + paramTwo +
                " = "+result);
        return result;
    }
}
