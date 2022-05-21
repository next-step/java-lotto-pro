package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final String ERROR_MESSAGE_NUMBER_LIST_NULL_OR_EMPTY = "[ERROR] numberList is null or empty.";
    private static final String ERROR_MESSAGE_NUMBER_LIST_SIZE_WRONG = "[ERROR] numberList size is wrong.";
    private static final String ERROR_MESSAGE_NUMBER_LIST_DUPLICATION = "[ERROR] numberList has duplicated number";

    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numberList;

    public Lotto(final List<LottoNumber> list) {
        validate(list);
        numberList = list;
    }

    public LottoNumber get(int index) {
        return numberList.get(index);
    }

    public int size() {
        return numberList.size();
    }

    public LottoMatchingResult match(Lotto referenceLotto, LottoNumber bonusNumber) {
        int countOfMatch = 0;

        for (int index = 0; index < referenceLotto.size(); index++) {
            countOfMatch += countOneHasNumber(referenceLotto.get(index));
        }

        return new LottoMatchingResult(countOfMatch, hasNumber(bonusNumber));
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return numberList.contains(lottoNumber);
    }

    private int countOneHasNumber(LottoNumber lottoNumber) {
        if(numberList.contains(lottoNumber)) {
            return 1;
        }

        return 0;
    }

    private void validate(List<LottoNumber> list) {
        validateNullOrEmpty(list);
        validateSize(list);
        validateDuplication(list);
    }

    private void validateNullOrEmpty(List<LottoNumber> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_LIST_NULL_OR_EMPTY);
        }
    }

    private void validateSize(List<LottoNumber> list) {
        if (list.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_LIST_SIZE_WRONG);
        }
    }

    private void validateDuplication(List<LottoNumber> list) {
        if(new HashSet<>(list).size() < list.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_LIST_DUPLICATION);
        }
    }
}
