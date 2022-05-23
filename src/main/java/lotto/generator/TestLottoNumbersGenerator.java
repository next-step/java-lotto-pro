package lotto.generator;

import lotto.model.LottoNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.LottoConstant.LOTTO_PICK_COUNT;
import static lotto.utils.InputUtils.convertToIntegerList;
import static lotto.utils.InputUtils.splitWithDelimiter;

public class TestLottoNumbersGenerator implements LottoNumbersGenerator {
    private final List<LottoNumber> lottoNumbers;

    public TestLottoNumbersGenerator(String input) {
        List<Integer> numbers = convertToIntegerList(splitWithDelimiter(input));
        checkNumberDuplicate(numbers);
        checkNumberSize(numbers);

        lottoNumbers = new ArrayList<>();
        numbers.forEach(number -> lottoNumbers.add(LottoNumber.of(number)));
    }

    @Override
    public List<LottoNumber> drawNumbers() {
        return lottoNumbers;
    }

    private static void checkNumberDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        boolean hasDuplicate = numberSet.size() <  LOTTO_PICK_COUNT;
        if (hasDuplicate) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복 값이 존재합니다!");
        }
    }

    private static void checkNumberSize(List<Integer> numbers) {
        boolean isOverSize = numbers.size() != LOTTO_PICK_COUNT;
        if (isOverSize) {
            String message = String.format("[ERROR] 로또 번호는 %d개 입력해 주세요!", LOTTO_PICK_COUNT);
            throw new IllegalArgumentException(message);
        }
    }
}
