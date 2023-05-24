package com.snap.calculator.service;

import com.snap.calculator.helper.Operations;

public class OperatorService {

    public static String operate(String x, String y, String operator) {
        String result = "";

        switch(operator) {
            case Operations.ADD:
                result = add(x,y);
                break;
            case Operations.SUBTRACT:
                result = subtract(x,y);
                break;
            case Operations.MULTIPLY:
                result = multiply(x,y);
                break;
            case Operations.DIVIDE:
                result = divide(x,y);
                break;
            default:
                break;
        }

        return result;
    }

    public static String add(String x, String y) {

        double xVal = Double.valueOf(x);
        double yVal = Double.valueOf(y);

        double result = xVal + yVal;

        return String.valueOf(result);
    }

    public static String subtract(String x, String y) {

        double xVal = Double.valueOf(x);
        double yVal = Double.valueOf(y);

        double result = xVal - yVal;

        return String.valueOf(result);
    }

    public static String multiply(String x, String y) {

        double xVal = Double.valueOf(x);
        double yVal = Double.valueOf(y);

        double result = xVal * yVal;

        return String.valueOf(result);
    }

    public static String divide(String x, String y) {

        double xVal = Double.valueOf(x);
        double yVal = Double.valueOf(y);

        double result = xVal / yVal;

        return String.valueOf(result);
    }
}
