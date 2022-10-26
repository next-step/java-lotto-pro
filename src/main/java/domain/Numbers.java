package domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers of(String[] split) {
        List<Integer> numbers = parIntegers(split);
        return new Numbers(numbers);
    }

    private static List<Integer> parIntegers(String[] split) {
        List<Integer> numbers = new ArrayList<>();
        for (String stringNum : split) {
            numbers.add(parseInteger(stringNum));
        }
        return numbers;
    }

    private static int parseInteger(String stringNum) {
        int i = Integer.parseInt(stringNum);
        if(i < 0){
            throw new RuntimeException("음수는 계산할 수 없습니다");
        }
        return i;
    }

    public int size() {
        return numbers.size();
    }

    public int sum() {
        int sum = 0;
        for (Integer num : this.numbers) {
            sum += num;
        }
        return sum;
    }
}
