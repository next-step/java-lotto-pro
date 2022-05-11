package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers(createLottoNumbers());
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> shuffleLottoNumbers = getShuffleLottoNumbers();

        List<Integer> resultLottoNumbers = new ArrayList<>();
        for (int i = 0; i < LottoNumbers.LOTTO_NUMBERS_SIZE; i++) {
            resultLottoNumbers.add(shuffleLottoNumbers.get(i));
        }

        return resultLottoNumbers;
    }

    private List<Integer> getShuffleLottoNumbers() {
        List<Integer> shuffleLottoNumbers = new ArrayList<>();

        for (int i = LottoNumber.MIN_LOTTO_NUMBER; i < LottoNumber.MAX_LOTTO_NUMBER; i++) {
            shuffleLottoNumbers.add(i);
        }

        Collections.shuffle(shuffleLottoNumbers);

        return shuffleLottoNumbers;
    }
}
