package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.constants.LottoConstants;

public class Lotto {

    private static final String ERROR_MESSAGE_NUMBER_LIST_NULL_OR_EMPTY = "[ERROR] numberList is null or empty.";
    private static final String ERROR_MESSAGE_NUMBER_LIST_SIZE_WRONG = "[ERROR] numberList size is wrong.";

    private final List<LottoNumber> numberList;

    public Lotto(final List<LottoNumber> list) {
        validate(list);

        numberList = new ArrayList<>(list);
        numberList.sort(Comparator.comparing(LottoNumber::getNumber));
    }

    public LottoNumber get(int index) {
        return numberList.get(index);
    }

    public int size() {
        return numberList.size();
    }

    public LottoMatchingResult match(Lotto lotto) {
        LottoMatchingResult matchingResult = new LottoMatchingResult();

        for (int index = 0; index < lotto.size(); index++) {
            addMatchingCount(matchingResult, lotto.get(index));
        }

        return matchingResult;
    }

    private void addMatchingCount(LottoMatchingResult matchingResult, LottoNumber lottoNumber) {
        if (hasNumber(lottoNumber)) {
            matchingResult.addCountOfMatch();
        }
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return numberList.contains(lottoNumber);
    }

    private void validate(List<LottoNumber> list) {
        validateNullOrEmpty(list);
        validateSize(list);
    }

    private void validateNullOrEmpty(List<LottoNumber> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_LIST_NULL_OR_EMPTY);
        }
    }

    private void validateSize(List<LottoNumber> list) {
        if (list.size() != LottoConstants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_LIST_SIZE_WRONG);
        }
    }
}
