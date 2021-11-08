package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateSorted(numbers);
        this.lottoNumbers = Collections.unmodifiableList(createLottoNumbers(numbers));
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(LottoNumber.valueOf(number));
        }
        return lottoNumbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoNumbersSize.LOTTO_NUMBERS_SIZE.getSize()) {
            throw new IllegalArgumentException(Message.WRONG_NUMBERS_SIZE_MESSAGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
        if (nonDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }

    private void validateSorted(List<Integer> numbers) {
        boolean isSorted = numbers.stream()
            .sorted()
            .collect(Collectors.toList())
            .equals(numbers);

        if (!isSorted) {
            throw new IllegalArgumentException(Message.NON_SORTED_NUMBERS_MESSAGE.getMessage());
        }
    }

    public Rank createWinningRank(LottoTicket winningTicket, LottoNumber bonusNumber) {
        Set<LottoNumber> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        List<LottoNumber> winningNumbers = winningTicket.lottoNumbers;
        nonDuplicateNumbers.addAll(winningNumbers);
        int countOfMatch = this.lottoNumbers.size() + winningNumbers.size() - nonDuplicateNumbers.size();
        return Rank.valueOf(countOfMatch, lottoNumbers.contains(bonusNumber));
    }

    public boolean existLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
