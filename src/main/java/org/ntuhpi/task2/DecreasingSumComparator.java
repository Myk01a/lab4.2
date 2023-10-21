package org.ntuhpi.task2;

import java.util.Comparator;

public class DecreasingSumComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
        int sum1 = calculateDigitSum(num1);
        int sum2 = calculateDigitSum(num2);
        return Integer.compare(sum2, sum1);
    }

    private int calculateDigitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
