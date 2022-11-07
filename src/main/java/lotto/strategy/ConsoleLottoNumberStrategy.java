package lotto.strategy;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.domain.Lotto.*;
import static lotto.domain.LottoNumber.*;
import static lotto.io.InputUtils.*;

public class ConsoleLottoNumberStrategy implements LottoNumberStrategy{

    private Logger log = LoggerFactory.getLogger(ConsoleLottoNumberStrategy.class);
    public static final String ONLY_NUMBER_REGEX = "^\\d*$";

    @Override
    public List<Integer> generateNumbers() {
        List<String> numberStrings = Arrays.asList(readConsole().split(","));

        if (!validateInput(numberStrings)) {
            return generateNumbers();
        }

        return numberStrings
                .stream()
                .map(number -> new Integer(number))
                .sorted()
                .collect(Collectors.toList());
    }

    private boolean validateInput(List<String> numberStrings) {
        try{
            numberStrings.stream()
                    .forEach(number -> {
                        validateOnlyNumber(number);
                        validateRange(number);
                    });
            validateCount(numberStrings);
            validateDuplicateNumber(numberStrings);
        }catch(IllegalArgumentException e){
            log.error("[ERROR] 입력에 오류가 있습니다. 다시 입력해주세요.");
            return false;
        }
        return true;
    }

    private void validateOnlyNumber(String input){
        if(!Pattern.matches(ONLY_NUMBER_REGEX, input)){
            throw new IllegalArgumentException("숫자 외 값이 입력되었습니다.");
        }
    }

    private void validateCount(List<String> numberStrings){
        if(numberStrings.size() != NUMBER_COUNT){
            throw new IllegalArgumentException("입력받은 숫자는 6개여야 합니다.");
        }
    }

    private void validateDuplicateNumber(List<String> numberStrings){
        Set<String> convertSet = new HashSet<>(numberStrings);
        if(convertSet.size() != numberStrings.size()){
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    private void validateRange(String input){
        if(MIN_NUMBER > Integer.parseInt(input) ||
                MAX_NUMBER < Integer.parseInt(input)){
            throw new IllegalArgumentException(
                    "로또 번호는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이 숫자로 이루어져야 합니다."
            );
        }
    }
}
