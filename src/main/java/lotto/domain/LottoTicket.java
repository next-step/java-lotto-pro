package lotto.domain;

import lotto.exception.IllegalLottoNumberSizeException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    public static final int LOTTO_NUMBER_SIZE = 6;
    List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        checkLottoNumberSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket generateRandomLottoTicket() {
        List<Integer> lottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.subList(0, 6));
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
