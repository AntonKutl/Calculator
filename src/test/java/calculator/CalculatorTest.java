package calculator;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalculatorTest {
    Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        calculator=new Calculator();
    }

    @DataProvider
    public Object[][] testAddition() {
        return new Object[][]{
                {4, 2, 2},
                {0, -1, 1},
                {8, 4, 4},
                {-1, 0, -1},
                {5, 2, 3}
        };
    }

    @DataProvider
    public Object[][] testSubtraction() {
        return new Object[][]{
                {0,1,1},
                {-3,2,5},
                {1.75,4,2.25},
                {0,0.3,0.3},
                {-4.3,0.3,4.6}
        };
    }

    @DataProvider
    public Object[][] testMultiplication() {
        return new Object[][]{
                {0,1,0},
                {-25,5,-5},
                {2.25,1.5,1.5},
                {0,2.123,0},
                {20,-4,-5}
        };
    }

    @DataProvider
    public Object[][] testDivision() {
        return new Object[][]{
                {2,4,2},
                {15,30,2},
                {5,25,5},
                {1.5,3,2},
                {20,40,2}
        };
    }

    @DataProvider
    public Object[][] testObject() {
        return new Object[][]{
                {"five", 2, 2},
                {1, -1, "one"},
                {100, "four", 4},
                {"seven", "0", -1},
                {3, null, 3}
        };
    }



    @Test(dataProvider = "testAddition")
    public void resultAddition(double one, double two, double tree) {
        double sum=calculator.resultOperation("+",two,tree);
        Assert.assertEquals(one,sum, "Значения не равны!");
    }

    @Test(dataProvider = "testSubtraction")
    public void resultSubtraction(double one, double two, double tree) {
        double sum=calculator.resultOperation("-",two,tree);
        Assert.assertEquals(one,sum, "Значения не равны!");
    }

    @Test(dataProvider = "testMultiplication")
    public void resultMultiplication(double one, double two, double tree) {
        double sum=calculator.resultOperation("*",two,tree);
        Assert.assertEquals(one,sum, "Значения не равны!");
    }

    @Test(dataProvider = "testDivision")
    public void resultDivision(double one, double two, double tree) {
        double sum=calculator.resultOperation("/",two,tree);
        Assert.assertEquals(one,sum, "Значения не равны!");
    }

    @Test(dataProvider = "testDivision")
    public void testEqualsNegative(double one, double two, double tree) {
        double sum=calculator.resultOperation("+",two,tree);
        Assert.assertNotEquals(one, sum, "Значения равны!");
    }

    @Test(dataProvider = "testObject", expectedExceptions = {ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void testNegativeObject(Object one, Object two, Object tree) {
        double sum=calculator.resultOperation("+",(double)two,(double)tree);
        Assert.assertEquals(one, sum, "Значения не равны!");
    }
}