package calculator;

public class Calculator {
    public  Double resultOperation(String signMathematical, Double one, Double two) {
        Double result=null;
        switch (signMathematical) {
            case "+":
                result=one + two;
                break;
            case "-":
                result=(one - two);
                break;
            case "*":
                result=(one * two);
                break;
            case "/":
                result= (one/two);
        }
        return result;
    }

}
