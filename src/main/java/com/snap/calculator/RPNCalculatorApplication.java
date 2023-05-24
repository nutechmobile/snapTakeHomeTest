package com.snap.calculator;

import com.snap.calculator.service.RPNEvaluator;

import java.util.Scanner;

public class RPNCalculatorApplication {

    public static String QUIT = "q";

    public static void main(String[] args) {

        System.out.println("RPN Calculator");
        System.out.println("Operands allowed: + - * /");
        System.out.println("Type 'q' or do CTRL-D to exit the application...");
        System.out.println();
        System.out.println("Input an RPN expression or a number(integer/decimal)");

        String input = "";

        Scanner inpScan = new Scanner(System.in);

        RPNEvaluator rpnEvaluator = new RPNEvaluator();

        while(!input.equalsIgnoreCase(QUIT)) {
            System.out.print("> ");

            input = inpScan.nextLine();

            try {
                System.out.println(rpnEvaluator.evaluate(input));
            } catch(Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again or type 'q' to quit the app.");
            }

        }




    }
}