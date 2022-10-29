package model;

import exception.LottoNumbersSizeException;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final int LOTTO_LOTTERY_TICKET_NUMBER_SIZE = 6;
    private final String TO_STRING_JOIN_DELIMETER = ", ";

    private final String LOTTO_NUMBERS_SIZE_ERROR_MESSSAGE = "로또 티켓은 " + LOTTO_LOTTERY_TICKET_NUMBER_SIZE + "자리 숫자로 이루어져야 합니다.";

    private Set<LottoNumber> lottoNumbers;

    public LottoNumbers(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumbers = lottoNumberGenerator.generate(new LottoNumber());

        validCheck();
    }

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;

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

    public int getLottoLotteryTicketNumberSize() {
        return LOTTO_LOTTERY_TICKET_NUMBER_SIZE;
    }

    public int match(LottoNumbers compareLottoNumbers) {
        int count = 0;
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            if (compareLottoNumbers.contain(lottoNumber)) {
                count++;
            }
        }

        return count;
    }

    public boolean contain(LottoNumber targetlottoNumber) {
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            if (lottoNumber.equals(targetlottoNumber)) return true;
        }

        return false;
    }

    @Override
    public String toString() {
        String lottonumbersToString = lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(TO_STRING_JOIN_DELIMETER));
        return "[" + lottonumbersToString + "]";
    }
}
