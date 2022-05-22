package lotto.model;

import lotto.generator.LottoNumbersGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.LottoConstant.*;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers createLottoNumbers(LottoNumbersGenerator lottoNumbersGenerator) {
        return new LottoNumbers(lottoNumbersGenerator.drawNumbers());
    }

    public static LottoNumbers createLottoNumbers(List<Integer> numbers) {
        checkNumberDuplicate(numbers);
        checkNumberSize(numbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        numbers.forEach(number -> lottoNumbers.add(LottoNumber.of(number)));
        return new LottoNumbers(lottoNumbers);
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

    public int matchCount(LottoNumbers winningNumbers) {
        List<LottoNumber> copiedWinningNumbers = new ArrayList<>(winningNumbers.lottoNumbers);
        copiedWinningNumbers.retainAll(lottoNumbers);
        return copiedWinningNumbers.size();
    }

    public int size() {
        return lottoNumbers.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
