package model;

import exception.LottoNumbersSizeException;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int LOTTO_LOTTERY_TICKET_NUMBER_SIZE = 6;
    public static final String TO_STRING_JOIN_DELIMETER = ", ";

    private static final String LOTTO_NUMBERS_SIZE_ERROR_MESSSAGE = "로또 티켓은 " + LOTTO_LOTTERY_TICKET_NUMBER_SIZE + "자리 숫자로 이루어져야 합니다.";

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumbers = lottoNumberGenerator.generate(new LottoNumber());

        validCheck();
    }

    private void validCheck() {
        if (!isRightSize()) {
            throw new LottoNumbersSizeException(LOTTO_NUMBERS_SIZE_ERROR_MESSSAGE);
        }
    }

    private boolean isRightSize() {
        return lottoNumbers.size() == LOTTO_LOTTERY_TICKET_NUMBER_SIZE;
    }

    @Override
    public String toString() {
        String lottonumbersToString = lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(TO_STRING_JOIN_DELIMETER));
        return "[" + lottonumbersToString + "]";
    }
}
