package edu.hw10.task1.generators;

import edu.hw10.task1.annotations.Maximum;
import edu.hw10.task1.annotations.Minimum;
import java.lang.reflect.Parameter;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings({"InnerAssignment"})
public class IntegerGenerator extends Generator {
    @Override
    public Object generate(Parameter parameter) {
        if (!isInteger(parameter)) {
            return generateNext(parameter);
        }

        var minValue = Integer.MIN_VALUE;
        var maxValue = Integer.MAX_VALUE;
        for (var annotation : parameter.getAnnotations()) {
            switch (annotation) {
                case Minimum minAnnotation -> minValue = minAnnotation.value();
                case Maximum maxAnnotation -> maxValue = maxAnnotation.value();
                default -> { }
            }
        }
        return ThreadLocalRandom.current().nextInt(minValue, maxValue);
    }

    private static boolean isInteger(Parameter parameter) {
        return parameter.getType().equals(int.class) || parameter.getType().equals(Integer.class);
    }

}
