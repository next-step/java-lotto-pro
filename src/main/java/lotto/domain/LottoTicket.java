package lotto.domain;

import lotto.domain.error.LottoTicketErrorCode;

import java.util.*;

public class LottoTicket {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public LottoTicket(final List<Integer> lottoNumbers) {
        validateNullOrEmpty(lottoNumbers);
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        validateLottoNumber(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getReadOnlyLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean contains(final int number) {
        return lottoNumbers.contains(number);
    }

    private void validateNullOrEmpty(final List<Integer> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(LottoTicketErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
        }
    }

    private void validateSize(final List<Integer> lottoNumbers) {
        if (!Objects.equals(lottoNumbers.size(), LOTTO_SIZE)) {
            throw new IllegalArgumentException(
                    String.format(LottoTicketErrorCode.INVALID_LOTTO_NUMBER_SIZE.getMessage(), LOTTO_SIZE)
            );
        }
    }

    private void validateDuplicate(final List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicatedNumbers = new HashSet<>(lottoNumbers);

        if (lottoNumbers.size() != nonDuplicatedNumbers.size()) {
            throw new IllegalArgumentException(LottoTicketErrorCode.NOT_ALLOW_DUPLICATE.getMessage());
        }
    }

    private void validateLottoNumber(final List<Integer> lottoNumbers) {
        boolean isNotLottoNumber = lottoNumbers.stream()
                .anyMatch(lottoNumber -> !isLottoNumberInRange(lottoNumber));

        if (isNotLottoNumber) {
            throw new IllegalArgumentException(
                    String.format(
                            LottoTicketErrorCode.INVALID_LOTTO_NUMBER.getMessage(),
                            LOTTO_MIN_NUMBER,
                            LOTTO_MAX_NUMBER));
        }
    }

    private boolean isLottoNumberInRange(final Integer lottoNumber) {
        return lottoNumber >= LOTTO_MIN_NUMBER && lottoNumber <= LOTTO_MAX_NUMBER;
    }
}
