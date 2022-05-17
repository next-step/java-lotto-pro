package lotto.domain;

import lotto.infrastructure.error.LottoTicketErrorCode;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLottoTicket {

    private final List<Integer> winningLottoNumbers;

    public WinningLottoTicket(final List<String> inputWinningLottoNumbers) {
        validateNullOrEmpty(inputWinningLottoNumbers);

        List<Integer> winningLottoNumbers = convertIntegers(inputWinningLottoNumbers);

        validateSize(winningLottoNumbers);
        validateDuplicate(winningLottoNumbers);
        validateLottoNumber(winningLottoNumbers);

        this.winningLottoNumbers = winningLottoNumbers;
    }

    public int countMatchNumber(LottoTicket lottoTicket) {
        return (int) winningLottoNumbers.stream()
                .filter(lottoTicket::contains)
                .count();
    }

    private void validateNullOrEmpty(final List<String> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(LottoTicketErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
        }
    }

    private void validateSize(final List<Integer> lottoNumbers) {
        if (!Objects.equals(lottoNumbers.size(), LottoTicket.LOTTO_SIZE)) {
            throw new IllegalArgumentException(
                    String.format(
                            LottoTicketErrorCode.INVALID_LOTTO_NUMBER_SIZE.getMessage(),
                            LottoTicket.LOTTO_SIZE)
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
                            LottoTicket.LOTTO_MIN_NUMBER,
                            LottoTicket.LOTTO_MAX_NUMBER));
        }
    }

    private boolean isLottoNumberInRange(final Integer lottoNumber) {
        return lottoNumber >= LottoTicket.LOTTO_MIN_NUMBER && lottoNumber <= LottoTicket.LOTTO_MAX_NUMBER;
    }

    private List<Integer> convertIntegers(List<String> strings) {
        return strings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
