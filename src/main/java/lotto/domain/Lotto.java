package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_FIRST_INDEX = 0;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_BONUS_NUMBER_INDEX = 6;
    public static final int LOTTO_FIXED_PRICE = 1_000;
    private static final int IS_MATCHES = 1;
    private static final int IS_NOT_MATCHES = 0;
    private static final List<Integer> candidates = createLottoNumbers();

    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public Lotto() {
        this.numbers = createSixRandomNumbers();
        this.bonusNumber = createBonusNumber();
    }

    private List<Integer> createSixRandomNumbers() {
        Collections.shuffle(candidates);
        final List<Integer> sixNumbers = new ArrayList<>(candidates.subList(LOTTO_FIRST_INDEX, LOTTO_SIZE));
        Collections.sort(sixNumbers);
        return sixNumbers;
    }

    private Integer createBonusNumber() {
        return candidates.get(LOTTO_BONUS_NUMBER_INDEX);
    }

    private static List<Integer> createLottoNumbers() {
        final List<Integer> candidates = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            candidates.add(i);
        }
        return candidates;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    public int getNumbersCount() {
        return numbers.size();
    }

    public Integer getNumberByIndex(int index) {
        return numbers.get(index);
    }

    public int matchesWinningNumber(final LottoWinningNumbers winningNumbers) {
        int matchesCount = 0;
        for (int i = 0; i < winningNumbers.getWinningNumbersSize(); i++) {
            matchesCount += matchesWinningNumberThenOneElseZero(winningNumbers.getWinningNumber(i));
        }
        return matchesCount;
    }

    private int matchesWinningNumberThenOneElseZero(final Integer winningNumber) {
        if (this.numbers.contains(winningNumber)) {
            return IS_MATCHES;
        }
        return IS_NOT_MATCHES;
    }

    public int matchesWinningNumberUsingBonus(final LottoWinningNumbers winningNumbers, final boolean isEqualBonus) {
        int matchesCount = 0;
        for (int i = 0; i < winningNumbers.getWinningNumbersSize(); i++) {
            matchesCount += matchesWinningNumberUsingBonusThenOneElseZero(winningNumbers.getWinningNumber(i),
                    winningNumbers.getBonusNumber(), isEqualBonus);
        }
        return matchesCount;
    }

    private int matchesWinningNumberUsingBonusThenOneElseZero(final Integer winningNumber, final Integer bonusNumber,
                                                              final boolean isEqualBonus) {
        if (isEqualBonus) {
            return matchesWinningNumberAndEqualBonusThenOneElseZero(winningNumber, bonusNumber);
        }
        return matchesWinningNumberAndNotEqualBonusThenOneElseZero(winningNumber, bonusNumber);
    }

    private int matchesWinningNumberAndEqualBonusThenOneElseZero(final Integer winningNumber,
                                                                 final Integer bonusNumber) {
        if (this.numbers.contains(winningNumber) &&
                isEqualBonusNumber(bonusNumber)) {
            return IS_MATCHES;
        }
        return IS_NOT_MATCHES;
    }

    private int matchesWinningNumberAndNotEqualBonusThenOneElseZero(final Integer winningNumber,
                                                                    final Integer bonusNumber) {
        if (this.numbers.contains(winningNumber) &&
                isNotEqualBonusNumber(bonusNumber)) {
            return IS_MATCHES;
        }
        return IS_NOT_MATCHES;
    }

    private boolean isEqualBonusNumber(final Integer bonusNumber) {
        return this.bonusNumber.equals(bonusNumber);
    }

    private boolean isNotEqualBonusNumber(final Integer bonusNumber) {
        return !this.bonusNumber.equals(bonusNumber);
    }
}
