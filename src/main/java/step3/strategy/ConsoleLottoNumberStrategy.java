package step3.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static step3.io.InputUtils.*;

public class ConsoleLottoNumberStrategy implements LottoNumberStrategy{
    @Override
    public List<Integer> generateNumbers() {
        Arrays.asList(readConsole().split(",")).stream()
                .forEach(number -> validateOnlyNumber(number));

        return Arrays.asList(readConsole().split(","))
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
