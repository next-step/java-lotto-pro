package model;

import exception.LottoNumbersSizeException;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_LOTTERY_TICKET_NUMBER_SIZE = 6;
    private static final int MATCH_COUNT_NUMBER = 1;
    private static final int NO_MATCH_COUNT_NUMBER = 0;

    private static final String TO_STRING_JOIN_DELIMETER = ", ";
    private static final String LOTTO_NUMBERS_SPLIT_DELIMETER = ",";

    private static final String LOTTO_NUMBERS_SIZE_ERROR_MESSSAGE = "로또 티켓은 중복없는 " + LOTTO_LOTTERY_TICKET_NUMBER_SIZE + "자리 숫자로 이루어져야 합니다.";

    private Set<LottoNumber> lottoNumbers;

    public LottoNumbers(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumbers = lottoNumberGenerator.generate(new LottoNumber());

        validCheck();
    }

    public LottoNumbers(String lottoNumbers) {
        this.lottoNumbers = Arrays.stream(lottoNumbers.split(LOTTO_NUMBERS_SPLIT_DELIMETER))
                .map( (lottoNumber) -> Integer.parseInt( lottoNumber.trim() ) )
                .distinct()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

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

    public int match(LottoNumbers winningLottoNumber) {
        int count = 0;

        for (LottoNumber lottoNumber : lottoNumbers) {
            count += countIfContainLottoNumber(winningLottoNumber, lottoNumber);
        }

        return count;
    }

    private int countIfContainLottoNumber(LottoNumbers winningLottoNumbers, LottoNumber lottoNumber) {
        if (winningLottoNumbers.lottoNumbers.contains(lottoNumber)) {
            return MATCH_COUNT_NUMBER;
        }

        return NO_MATCH_COUNT_NUMBER;
    }

    @Override
    public String toString() {
        String lottonumbersToString = lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(TO_STRING_JOIN_DELIMETER));
        return "[" + lottonumbersToString + "]";
    }
}
