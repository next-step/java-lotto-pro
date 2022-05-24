package lotto.domain;

import lotto.domain.error.LottoTicketErrorCode;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<Integer> lottoNumbers) {
        validateNullOrEmpty(lottoNumbers);
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);

        this.lottoNumbers = lottoNumbers.stream()
                .map(lottoNumber -> new LottoNumber(lottoNumber))
                .collect(Collectors.toList());
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

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
