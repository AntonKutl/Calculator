package calculator;

import java.util.Scanner;

public class СalculatorUI {
    String signMathematical;
    Double one;
    Double two;
    Calculator calculator=new Calculator();


    public void enterActions() {
        System.out.println("Введите одно из дейсвий: +,-,*,/");
        do {
            Scanner in = new Scanner(System.in);
            signMathematical = in.nextLine();

            if (!(signMathematical.equals("+") || signMathematical.equals("-")
                    || signMathematical.equals("*") || signMathematical.equals("/"))) {
                System.out.println("Операция не поддерживаеться калькулятором. Введите оператор заново");
            }
        } while (!(signMathematical.equals("+") || signMathematical.equals("-")
                || signMathematical.equals("*") || signMathematical.equals("/")));
    }

    public void enterNum() {
        one = enteringNumber("Введите первое число");
        two = enteringNumber("Введите второе число");
        if (two == 0) {
            System.out.println("На ноль делить нельзя.Введите другое число");
            two = enteringNumber("Введите второе число");
        }
    }

    private Double enteringNumber(String phrase) {
        System.out.println(phrase);
        Scanner in = new Scanner(System.in);
        return in.nextDouble();
    }

    public void printResult(){
        System.out.println(one + " "+signMathematical+" " + two + " = "+calculator.resultOperation(signMathematical,one,two));
    }
}



