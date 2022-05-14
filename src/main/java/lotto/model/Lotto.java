package lotto.model;

import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public final static int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto() {
        List<Integer> numbers = createLottoNumbers();

        validateNumbers(numbers);

        this.numbers = toLottoNumbers(numbers);
    }

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);

        this.numbers = toLottoNumbers(numbers);
    }

    private List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        List<LottoNumber> resultNumbers = new ArrayList<>();

        //numbers.sort((o1, o2) -> Integer.compare(o1, o2));
        //numbers.sort(Comparator.comparingInt(o -> o));
        numbers.sort(Integer::compareTo);

        for (int number : numbers) {
            resultNumbers.add(new LottoNumber(number));
        }

        return resultNumbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBERS_SIZE){
            throw new IllegalArgumentException("숫자의 개수는 6개여야 합니다.");
        }

        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ResultView.ERROR_DUPLICATION_NUMBER);
        }
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> shuffleLottoNumbers = shuffleNumbers();

        List<Integer> resultLottoNumbers = new ArrayList<>();
        for (int i = 0; i < Lotto.LOTTO_NUMBERS_SIZE; i++) {
            resultLottoNumbers.add(shuffleLottoNumbers.get(i));
        }

        return resultLottoNumbers;
    }

    private List<Integer> shuffleNumbers() {
        List<Integer> shuffleLottoNumbers = new ArrayList<>();

        for (int i = LottoNumber.MIN_LOTTO_NUMBER; i < LottoNumber.MAX_LOTTO_NUMBER; i++) {
            shuffleLottoNumbers.add(i);
        }

        Collections.shuffle(shuffleLottoNumbers);

        return shuffleLottoNumbers;
    }

    public int findMatchCount(Lotto winningLotto) {
        int count = 0;

        for (LottoNumber number : winningLotto.numbers) {
            count = count + getAddCount(number);
        }

        return count;
    }

    private int getAddCount(LottoNumber number) {
        if(isContainsNumber(number)) {
            return 1;
        }

        return 0;
    }

    private boolean isContainsNumber(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public String numbersToString() {
        return this.numbers.toString();
    }

    public boolean isMatchBonus(LottoNumber bonusBall) {
        return isContainsNumber(bonusBall);
    }
}
