package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите арифметическую операцию.");
        Scanner input = new Scanner(System.in);
        String enter = input.next();
        enter = enter.replaceAll("\\s", "");
        if (!enter.matches("[0-9]*[+*/-][0-9]*")) {
            System.out.println("Ошибка. Можно использовать только целые числа и одну из арифметических операций: +, -, /, *");
            return;
        }
        String operator = "";
        if (enter.contains("+")) {
            operator = "+";
        } else if (enter.contains("-")) {
            operator = "-";
        } else if (enter.contains("*")) {
            operator = "*";
        } else if (enter.contains("/")) {
            operator = "/";
        }
        int index = enter.indexOf(operator);
        String number1 = enter.substring(0, enter.indexOf(operator));
        String number2 = enter.substring(enter.indexOf(operator) + 1);
        if (number2.equals("0") && operator == "/") {
            System.out.println("Ошибка. На ноль делить нельзя");
        } else {
            double value3 = Double.parseDouble(number1);
            double value2 = Double.parseDouble(number2);
            double result;
            switch (operator) {
                case "+":
                    result = value3 + value2;
                    System.out.println(enter + "=" + result);
                    break;
                case "-":
                    result = value3 - value2;
                    System.out.println(enter + "=" + result);
                    break;
                case "*":
                    result = value3 * value2;
                    System.out.println(enter + "=" + result);
                    break;
                case "/":
                    result = value3 / value2;
                    System.out.println(enter + "=" + result);
            }
        }
    }
}
