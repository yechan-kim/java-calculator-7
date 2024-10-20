package calculator.model;

import calculator.view.Message;
import java.util.Arrays;

public class SumCalculatorImpl implements SumCalculator {

    @Override
    public String calculate(long[] numbers) {
        long sum = Arrays.stream(numbers)
                .reduce(0L, (currentSum, number) -> {
                    if (willOverflow(currentSum, number)) {
                        throw new IllegalArgumentException(Message.SUM_LONG_OVERFLOW.getMessage());
                    }
                    return currentSum + number;
                });

        return String.valueOf(sum);
    }

    @Override
    public boolean willOverflow(long currentSum, long newNumber) {
        return newNumber > 0 && currentSum > Long.MAX_VALUE - newNumber;
    }
}
