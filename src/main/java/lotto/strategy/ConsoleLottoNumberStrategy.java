package lotto.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.io.InputUtils.*;

public class ConsoleLottoNumberStrategy implements LottoNumberStrategy{
    @Override
    public List<Integer> generateNumbers() {
        String[] numbers = readConsole().split(",");
        Arrays.asList(numbers).stream()
                .forEach(number -> validateOnlyNumber(number));

        return Arrays.asList(numbers)
                .stream()
                .map(number -> new Integer(number))
                .sorted()
                .collect(Collectors.toList());
    }

    public void validateOnlyNumber(String input){
        if(!Pattern.matches("^\\d*$", input)){
            throw new IllegalArgumentException("숫자 외 값이 입력되었습니다.");
        }
    }
}
