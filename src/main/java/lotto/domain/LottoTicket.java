package lotto.domain;

import lotto.common.ErrorMessage;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile(",");
    private static final String EMPTY_STRING = "";
    private static final Pattern SPACE_DELIMITER_PATTERN = Pattern.compile("\\s");
    private final Set<LottoNumber> ticket;

    public LottoTicket(Set<LottoNumber> lottoTicket) {
        this.ticket = lottoTicket;
        this.validateDuplication(ticket);
    }

    public LottoTicket(String strNumber) {
        String trimStrNumber = SPACE_DELIMITER_PATTERN.matcher(strNumber).replaceAll(EMPTY_STRING);
        this.ticket = Arrays.stream(DEFAULT_DELIMITER_PATTERN.split(trimStrNumber))
                .map((number) -> new LottoNumber(Integer.parseInt(number)))
                .collect(Collectors.toSet());
        this.validateDuplication(ticket);
    }

    private void validateDuplication(Set<LottoNumber> lottoTicket) {
        if (lottoTicket.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBER_DUPLICATION);
        }
    }

    public int compareTicket(LottoTicket winningTicket) {
        return (int) this.ticket.stream()
                .filter(winningTicket.ticket::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(ticket, that.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }
}
