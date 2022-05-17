package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.LottoGameErrorMessage.INVALID_LOTTO_NUMBERS_SIZE;
import static lotto.constants.LottoGameErrorMessage.INVALID_LOTTO_NUMBER_NOT_UNIQUE;
import static lotto.constants.LottoNumberConstant.LOTTO_NUMBER_SIZE;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket() {
        this(LottoNumbers.generateLottoNumbers(new LottoNumbersGenerator()).getReadOnlyLottoNumbers());
    }

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_SIZE);
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_NOT_UNIQUE);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoPrize match(LottoTicket lottoTicket) {
        int numberOfMatch = (int) lottoNumbers.stream()
                .filter(number -> lottoTicket.getLottoNumbers().contains(number))
                .count();

        return LottoPrize.valueOf(numberOfMatch);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
