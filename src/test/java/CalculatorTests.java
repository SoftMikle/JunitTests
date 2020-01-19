import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sandbox.Calculator;

public class CalculatorTests {

    Calculator calculator;

    @Before
    public void initialization(){
        calculator = new Calculator(100, 10);
    }

    @Test
    public void testGetSummation(){
        Assert.assertEquals(110, calculator.getSummation());
    }

    @Test
    public void testGetDiff(){
        Assert.assertEquals(90, calculator.getDiff());
    }
}
