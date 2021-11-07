package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;
import view.Printable;

public class LottoTicket implements Printable {
    private static final String LOTTO_TICKET_MESSAGE_FORMAT = "[%s]";
    private static final String COMMA_SPACE = ", ";

    private static final String COMMA = ",";
    private static final String ALL_SPACES_PATTERN = "\\s";
    private static final String EMPTY = "";

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> numbers) {
        this.lottoNumbers = numbers.stream()
            .map(LottoNumber::new)
            .sorted()
            .collect(Collectors.toList());
    }

    public LottoTicket(String numbers) {
        String[] split = removeAllSpaces(numbers).split(COMMA);

        Set<LottoNumber> lottoNumbers = makeNoDuplicateNumbers(split);
        checkValidSize(lottoNumbers);

        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    private String removeAllSpaces(String numbers) {
        return numbers.replaceAll(ALL_SPACES_PATTERN, EMPTY);
    }

    private Set<LottoNumber> makeNoDuplicateNumbers(String[] split) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        for (String number : split) {
            LottoNumber lottoNumber = new LottoNumber(parseToValidNumber(number));
            lottoNumbers.add(lottoNumber);
        }

        return lottoNumbers;
    }

    private int parseToValidNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorCode.INVALID_LOTTO_TICKET);
        }
    }

    private void checkValidSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new LottoException(LottoErrorCode.INVALID_LOTTO_TICKET);
        }
    }

    public LottoResult calculateResult(LottoTicket winnerTicket) {
        int correctCount = (int)this.lottoNumbers.stream()
            .filter(number -> winnerTicket.lottoNumbers.contains(number))
            .count();

        return LottoResult.findResult(correctCount);
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

    @Override
    public String makePrintableMessage() {
        return String.format(LOTTO_TICKET_MESSAGE_FORMAT,
            lottoNumbers.stream().map(LottoNumber::makePrintableMessage).collect(Collectors.joining(COMMA_SPACE)));
    }
}
