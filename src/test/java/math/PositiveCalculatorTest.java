package math;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import math.Calculator;

import java.math.BigDecimal;

import static org.testng.Assert.*;

public class PositiveCalculatorTest {
    @DataProvider
    public Object[][]testEquals() {
        return new Object[][]{
                {"+", "1.5", "4.8", 6.3},
                {"-", "1.5", "4.8", -3.3},
                {"/", "1.5", "4.8", 0.3125},
                {"*", "1.5", "4.8", 7.2},
                {"+", "0.0", "0.0", 0.0},
                {"*", "0.0", "0.0", 0.0},
                {"-", "4.4", "0.4", 4.0},
                {"-", "4.4", "4.0", 0.4},
                {"-", "1.8", "0.2", 1.6},
                {"*", "1.8", "0.2", 0.36},
                {"/", "1.8", "0.2", 9.0},
                {"+", "256.86", "35.4", 292.26},
                {"+", "-256.86", "35.4", -221.46},
                {"/", "-256.86", "35.4", -7.255932203},
                {"/", "25.86", "35.4", 0.7305084746},
                {"/", "-132.3", "23.8", -5.558823529},
                {"*", "0.000098", "0.00054", 5.292E-8},
                {"/", "5.0", "10000000000000.0", 5.0E-13},
                //граничные значения:
                {"-","-1.7976931348623157E+308", "-1.7976931348623157E+308", 0.0},//Double.MIN_VALUE
                {"/","-1.7976931348623157E+308", "-1.7976931348623157E+308", 1.0},
                {"+","1.7976931348623157E+308", "1.7976931348623157E+308", Double.POSITIVE_INFINITY},//Double.MAX_VALUE
                {"*","1.7976931348623157E+308", "1.7976931348623157E+308", Double.POSITIVE_INFINITY},
                {"*","-1.7976931348623157E+308", "1.7976931348623157E+308", Double.NEGATIVE_INFINITY},
                {"/","1.7976931348623157E+308", "1.7976931348623157E+308", 1.0},
                {"/","-1.7976931348623157E+308", "1.7976931348623157E+308", -1.0},
                {"/","0.0", "1.7976931348623157E+308", 0.0},//Double.MAX_VALUE
        };
    }

    @Test(dataProvider = "testEquals")
    public void testMathOperation(String oper, String a, String b, double expect) {
        String[] callValues = new String[3];
        callValues[0] = oper;
        callValues[1] = a;
        callValues[2] = b;
        //double result = Calculator.mathOperation(oper,a,b);
        double result = Calculator.pars(callValues);
        assertEquals(result,expect);
    }

}