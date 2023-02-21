package net.cbarker;

import com.google.common.annotations.VisibleForTesting;

import java.util.stream.DoubleStream;

public class Calculator {

    @VisibleForTesting
    public static double add(double... operands) {
        return DoubleStream.of(operands)
                .sum();
    }

    @VisibleForTesting
    public static double multiply(double... operands) {
        return DoubleStream.of(operands)
                .reduce(1, (a, b) -> a * b);
    }
}