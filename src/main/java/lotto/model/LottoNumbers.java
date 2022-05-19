package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.LottoConstant.*;
import static lotto.utils.RandomUtils.createRandomNumbers;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }
    }

    public static LottoNumbers createLottoNumbers() {
        List<Integer> randomNumbers = createRandomNumbers(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_PICK_COUNT);
        return new LottoNumbers(randomNumbers);
    }

    public static LottoNumbers createWinningNumbers(List<Integer> numbers) {
        checkNumberDuplicate(numbers);
        checkNumberSize(numbers);
        return new LottoNumbers(numbers);
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
        System.out.println();
        System.out.println(copiedWinningNumbers);
        System.out.println(lottoNumbers);
        System.out.println();
        copiedWinningNumbers.retainAll(lottoNumbers);
        System.out.println(">> " + copiedWinningNumbers);
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
