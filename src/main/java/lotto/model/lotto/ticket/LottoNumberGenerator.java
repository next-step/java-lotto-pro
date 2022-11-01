package lotto.model.lotto.ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    protected static final int NUMBER_COUNT_IN_SINGLE_LOTTO_TICKET = 6;
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    protected final List<LottoNumber> lottoNumbers;

    public LottoNumberGenerator() {
        final List<Integer> candidates = intsFromOneToFortyFive();
        Collections.shuffle(candidates);
        final List<Integer> numbers = candidates.subList(0, NUMBER_COUNT_IN_SINGLE_LOTTO_TICKET);
        Collections.sort(numbers);
        lottoNumbers = toLottoNumbers(numbers);
    }

    private List<Integer> intsFromOneToFortyFive() {
        final List<Integer> fullCandidateList = new ArrayList<>(LOTTO_MAXIMUM_NUMBER);
        for (int i = LOTTO_MINIMUM_NUMBER; i <= LOTTO_MAXIMUM_NUMBER; ++i) {
            fullCandidateList.add(i);
        }
        return fullCandidateList;
    }

    private List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        final List<LottoNumber> lottoNumbersData = new ArrayList<>(numbers.size());
        for (int number : numbers) {
            lottoNumbersData.add(new LottoNumber(number));
        }
        return lottoNumbersData;
    }

    public List<LottoNumber> generate() {
        return lottoNumbers;
    }
}
