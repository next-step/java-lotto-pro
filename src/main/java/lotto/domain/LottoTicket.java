package lotto.domain;

import lotto.exception.IllegalLottoNumberSizeException;
import lotto.exception.NumberDuplicationException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int FROM_INDEX = 0;
    public static final int START_INCLUSIVE = 1;
    public static final int END_EXCLUSIVE = 46;
    List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        checkLottoNumberSize(lottoNumbers);
        checkNumberDuplication(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket generateRandomLottoTicket() {
        List<Integer> lottoNumbers = IntStream.range(START_INCLUSIVE, END_EXCLUSIVE).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.subList(FROM_INDEX, LOTTO_NUMBER_SIZE));
    }

    private void checkNumberDuplication(List<Integer> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() < LOTTO_NUMBER_SIZE) {
            throw new NumberDuplicationException();
        }
    }

    private void checkLottoNumberSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalLottoNumberSizeException();
        }
    }

    public String toResultString() {
        return lottoNumbers.toString();
    }
}
