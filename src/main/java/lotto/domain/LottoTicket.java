package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        validateRangeOfNumbers(lottoNumbers);
        validateSorted(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private void validateRangeOfNumbers(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            validateRange(lottoNumber);
        }
    }

    private void validateRange(Integer lottoNumber) {
        if (lottoNumber < LottoNumberRange.LOTTO_NUMBER_MIN_RANGE.getRange()
            || lottoNumber > LottoNumberRange.LOTTO_NUMBER_MAX_RANGE.getRange()) {
            throw new IllegalArgumentException(Message.OUT_OF_RANGE_NUMBER_MESSAGE.getMessage());
        }
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoNumbersSize.LOTTO_NUMBERS_SIZE.getSize()) {
            throw new IllegalArgumentException(Message.WRONG_NUMBERS_SIZE_MESSAGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicatedNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicatedNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }

    private void validateSorted(List<Integer> lottoNumbers) {
        boolean isSorted = lottoNumbers.stream()
            .sorted()
            .collect(Collectors.toList())
            .equals(lottoNumbers);

        if (!isSorted) {
            throw new IllegalArgumentException(Message.NON_SORTED_NUMBERS_MESSAGE.getMessage());
        }
    }

    public Rank winningRank(LottoTicket winningTicket) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        List<Integer> winningNumbers = winningTicket.lottoNumbers;
        nonDuplicateNumbers.addAll(winningNumbers);
        int countOfMatch = this.lottoNumbers.size() + winningNumbers.size() - nonDuplicateNumbers.size();
        return Rank.valueOf(countOfMatch);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
