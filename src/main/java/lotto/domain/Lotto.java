package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int CONTAIN_VALUE = 1;
    public static final int NOT_CONTAIN_VALUE = 0;
    public static final int NUMBER_COUNT = 6;
    private List<LottoNumber> numbers;
    private Lotto(){}
    public static Lotto create(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicateLottoNumber(numbers);
        Lotto lotto = new Lotto();
        lotto.numbers = numbers.stream()
                .sorted()
                .map(number -> LottoNumber.create(number))
                .collect(Collectors.toList());

        return lotto;
    }

    private static void validateDuplicateLottoNumber(List<Integer> numbers) {
        Set<Integer> convertedNumbers = new HashSet<>(numbers);
        if(convertedNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("로또 번호 내 중복된 번호가 존재합니다.");
        }
    }

    private static void validateCount(List<Integer> numbers){
        if(numbers.size() != NUMBER_COUNT){
            throw new IllegalArgumentException("입력받은 숫자는 6개여야 합니다.");
        }
    }

    public boolean isContain(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public int getContainNumberCount(Lotto target) {
        int result = 0;
        for (LottoNumber number : this.numbers) {
            result += target.getContainResult(number);
        }
        return result;
    }

    private int getContainResult(LottoNumber number){
        if(isContain(number)){
            return CONTAIN_VALUE;
        }
        return NOT_CONTAIN_VALUE;
    }

    @Override
    public String toString() {
        String result = "";
        for(LottoNumber number : numbers){
            result += number.toString() + ", ";
        }
        return "[" + result.substring(0, result.length()-2) + "]";
    }
}
