package com.snap.calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RPNEvaluatorTest {

    RPNEvaluator evaluator;

    @BeforeEach
    void setUp() {
        evaluator = new RPNEvaluator();
    }

    @Test
    void evaluateWithSingleValidInputs() throws Exception {
        String input = "5";
        evaluator.evaluate(input);

        String input2 = "8";
        evaluator.evaluate(input2);

        String input3 = "+";
        Double result = Double.valueOf(evaluator.evaluate(input3));

        Assertions.assertEquals(13.0, result);
    }

    @Test
    void evaluateWithFullRPN() throws Exception {
        String input = "5 5 5 8 + + -";
        Double result = Double.valueOf(evaluator.evaluate(input));
        Assertions.assertEquals(-13.0, result);

        input = "13 +";
        result = Double.valueOf(evaluator.evaluate(input));
        Assertions.assertEquals(0.0, result);
    }

    @Test
    void evaluateWithNegativeNumbers() throws Exception {
        String input = "-3";
        evaluator.evaluate(input);

        String input2 = "-2";
        evaluator.evaluate(input2);

        String input3 = "*";
        evaluator.evaluate(input3);

        String input4 = "5";
        evaluator.evaluate(input4);

        String input5 = "+";
        Double result = Double.valueOf(evaluator.evaluate(input5));

        Assertions.assertEquals(11.0, result);
    }

    @Test
    void evaluateWithFractionalOutcome() throws Exception {
        String input = "5";
        evaluator.evaluate(input);

        String input2 = "9";
        evaluator.evaluate(input2);

        String input3 = "1";
        evaluator.evaluate(input3);

        String input4 = "-";
        evaluator.evaluate(input4);

        String input5 = "/";
        Double result = Double.valueOf(evaluator.evaluate(input5));

        Assertions.assertEquals(0.625, result);
    }

    @Test
    void evaluateWithBadData() throws Exception {

        assertThrows(NumberFormatException.class,
            ()->{
                String input2 = "w";
                evaluator.evaluate(input2);
            });
    }

    @Test
    void evaluateWithTooFewNumbers() throws Exception {

        String input = "8";
        evaluator.evaluate(input);

        String input2 = "+";

        Exception thrown = assertThrows(
                Exception.class,
                () -> evaluator.evaluate(input2),
                "Not enough numbers available to perform the operation!"
        );

        assertTrue(thrown.getMessage().contentEquals("Not enough numbers available to perform the operation!"));
    }
}