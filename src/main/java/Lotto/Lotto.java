package Lotto;

import Lotto.enums.CompareEnum;
import Lotto.error.ErrorMessage;
import Lotto.utils.StringSplitUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final ArrayList<Integer> RANGE_NUMBERS = RangeNumbers.getRangeNumbers();
    private static int RANGE_NUMBERS_START_INDEX = 0;
    private static int RANGE_NUMBERS_END_INDEX = 6;
    private static int LOTTO_STRING_MINIMUM_INDEX = 2;
    private LottoNumbers numbers = new LottoNumbers();

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    public Lotto() { }

    public Lotto(String customNumbers) {
        generate(customNumbers);
    }

    private List<Integer> drawNumbers() {
        return new ArrayList<>(RANGE_NUMBERS.subList(RANGE_NUMBERS_START_INDEX, RANGE_NUMBERS_END_INDEX));
    }

    public void generate() {
        Collections.shuffle(RANGE_NUMBERS);
        this.numbers = new LottoNumbers(drawNumbers());
        numbers.sort();
    }

    public void generate(String customNumbers) {
        List<Integer> customNumbersToInt = StringSplitUtils.basicDetermiterSplit(customNumbers);
        if(!validCustomNumbers(customNumbersToInt))
            throw new IllegalArgumentException(ErrorMessage.LastPrizeNumberGenerate.getErrorMsg());
        Collections.sort(customNumbersToInt);
        this.numbers = new LottoNumbers(customNumbersToInt);
    }

    public CompareEnum compare(WinLotto winLotto) {
        long hitCount = winLotto.getLotto()
                        .getNumbers()
                        .stream()
                        .filter(num -> getNumbers().contains(num))
                        .count();

        boolean isBonus = getNumbers().contains(winLotto.getBonusNumber());

        return CompareEnum.valueOf(hitCount, isBonus);
    }

    private boolean validCustomNumbers(List<Integer> customNumbers) {
        return customNumbers.stream()
                            .filter(num -> RANGE_NUMBERS.contains(num))
                            .distinct()
                            .count() == 6;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int number : getNumbers()) {
            sb.append(number + ", ");
        }

        if(sb.length() < LOTTO_STRING_MINIMUM_INDEX)
            return "";

        sb.delete(sb.length() - LOTTO_STRING_MINIMUM_INDEX, sb.length());
        return "[" + sb + "]";
    }
}
