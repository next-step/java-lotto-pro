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

    private List<LottoNumber> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers.stream()
            .map(LottoNumber::new)
            .sorted()
            .collect(Collectors.toList());
    }

    public LottoTicket(String text) {
        String[] split = removeAllSpaces(text).split(COMMA);

        Set<LottoNumber> lottoSet = makeNoDuplicateNumbers(split);
        checkValidSize(lottoSet);

        numbers = new ArrayList<>(lottoSet);
    }

    private String removeAllSpaces(String text) {
        return text.replaceAll(ALL_SPACES_PATTERN, EMPTY);
    }

    private Set<LottoNumber> makeNoDuplicateNumbers(String[] split) {
        Set<LottoNumber> lottoSet = new HashSet<>();

        for (String numberText : split) {
            int number = parseToValidNumber(numberText);
            LottoNumber lottoNumber = new LottoNumber(number);
            lottoSet.add(lottoNumber);
        }

        return lottoSet;
    }

    private int parseToValidNumber(String numberText) {
        try {
            return Integer.parseInt(numberText);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorCode.INVALID_LOTTO_TICKET);
        }
    }

    private void checkValidSize(Set<LottoNumber> lottoSet) {
        if (lottoSet.size() != LOTTO_SIZE) {
            throw new LottoException(LottoErrorCode.INVALID_LOTTO_TICKET);
        }
    }

    public LottoResult calculateResult(LottoTicket winnerTicket) {
        int correctCount = (int)this.numbers.stream()
            .filter(number -> winnerTicket.numbers.contains(number))
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
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String makePrintableMessage() {
        return String.format(LOTTO_TICKET_MESSAGE_FORMAT,
            numbers.stream().map(LottoNumber::makePrintableMessage).collect(Collectors.joining(COMMA_SPACE)));
    }
}
