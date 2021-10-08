package math;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NegativeCalculatorTest {
    @DataProvider
    public Object[][] testEqualsNegative() {
        return new Object[][]{
                {"+", "s", "-1.7976931348623157E+308", new java.lang.NumberFormatException()},
                {"*","one", "two", new java.lang.NumberFormatException()},
                {"-","true", "false", new java.lang.NumberFormatException()},
                {"+","s", "m",new java.lang.NumberFormatException()},
                {"/", "0.0", "0.0", new ArithmeticException("Division undefined")},
                {"/", "34.65", "0.0", new ArithmeticException("Division by zero")},
        };
    }

    @Test(dataProvider = "testEqualsNegative")
    public void testMathOperationNegative(String oper, String a, String b, Exception expect) {
        String[] callValues = new String[3];
        callValues[0] = oper;
        callValues[1] = a;
        callValues[2] = b;
        try{
            double result = Calculator.pars(callValues);
        }catch (Exception ex){
            assertEquals(ex.getClass().getName(),expect.getClass().getName());
        }
    }

    @DataProvider
    public Object[][] testEquals() {
        return new Object[][]{
                {"r", "0.34", "54.3", Double.NaN},
                {"0","45.3", "35.2", Double.NaN},
                {"#","53.3", "34.5",  Double.NaN},
                {"&","34.56", "34.6", Double.NaN},
                {"?", "45.6", "7.0", Double.NaN},
                {".", "34.65", "0.0", Double.NaN},
                {"rw", "34.65", "0.0", Double.NaN},
                {"343.9", "34.65", "0.0", Double.NaN},
        };
    }
    @Test(dataProvider = "testEquals")
    public void testMathOperation(String oper, String a, String b, double expect) {
        String[] callValues = new String[3];
        callValues[0] = oper;
        callValues[1] = a;
        callValues[2] = b;
        double result = Calculator.pars(callValues);
        assertEquals(result,expect);
    }
}
