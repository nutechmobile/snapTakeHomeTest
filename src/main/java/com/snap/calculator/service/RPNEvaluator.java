package com.snap.calculator.service;

import com.snap.calculator.helper.Operations;

import java.util.Stack;

public class RPNEvaluator {

    public static String validOperands = Operations.ADD + Operations.SUBTRACT + Operations.MULTIPLY + Operations.DIVIDE;

    public Stack<String> currentStack = new Stack<>();

    public String evaluate(String input) throws Exception {


        if(input.isEmpty()) {
            return "";
        }

        int start = 0;

//        Stack<String> stack = new Stack<>();

        while( start < input.length()) {

            //find the next space (input has space delimiters)
            int space = input.substring(start).indexOf(' ');
            int end = space == -1 ? input.length() : start + space;

            //get the next number or operand
            String current = input.substring(start, end);

            //if current char is an operand, then apply it to thr top 2 numbers on the stack LIFO
            if(validOperands.indexOf(current.charAt(0)) != -1) {

                if(currentStack.size() < 2) {
                    throw new Exception("Not enough numbers available to perform the operation!");
                }

                String y =  currentStack.pop();
                String x = currentStack.pop();
                String operator = String.valueOf(current.charAt(0));

                currentStack.push(OperatorService.operate(x, y, operator));
            } else {
                //parsing as a double to ensure it's in fact a number
                String doubleCurrent = Double.toString(Double.parseDouble(current));
                currentStack.push(doubleCurrent);
            }
            //start over at the index just after the last space
            start = end + 1;
        }

        String result = currentStack.peek(); //we dont want to remove the last value

        return result;
    }

    public Stack<String> getCurrentStack() {
        return currentStack;
    }
}
