package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class LottoTicket {
    public static final int LOTTO_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> numbers) {
        checkValidSize(numbers);
        checkNoDuplicate(numbers);

        this.lottoNumbers = numbers.stream()
            .map(LottoNumber::new)
            .sorted()
            .collect(Collectors.toList());
    }

    private void checkNoDuplicate(List<Integer> numbers) {
        if (LOTTO_SIZE != numbers.stream().distinct().count()) {
            throw new LottoException(LottoErrorCode.INVALID_LOTTO_TICKET);
        }
    }

    private void checkValidSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new LottoException(LottoErrorCode.INVALID_LOTTO_TICKET);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoResult calculateResult(LottoTicket winnerTicket, boolean containsBonus) {
        int correctCount = (int)this.lottoNumbers.stream()
            .filter(number -> winnerTicket.lottoNumbers.contains(number))
            .count();

        return LottoResult.findResult(correctCount, containsBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoTicket)) {
            return false;
        }
        LottoTicket that = (LottoTicket)o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
