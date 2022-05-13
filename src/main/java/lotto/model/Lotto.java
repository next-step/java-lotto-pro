package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = createLottoNumbers();
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private LottoNumbers createLottoNumbers() {
        List<Integer> shuffleLottoNumbers = shuffleNumbers();

        List<Integer> resultLottoNumbers = new ArrayList<>();
        for (int i = 0; i < LottoNumbers.LOTTO_NUMBERS_SIZE; i++) {
            resultLottoNumbers.add(shuffleLottoNumbers.get(i));
        }

        return new LottoNumbers(resultLottoNumbers);
    }

    private List<Integer> shuffleNumbers() {
        List<Integer> shuffleLottoNumbers = new ArrayList<>();

        for (int i = LottoNumber.MIN_LOTTO_NUMBER; i < LottoNumber.MAX_LOTTO_NUMBER; i++) {
            shuffleLottoNumbers.add(i);
        }

        Collections.shuffle(shuffleLottoNumbers);

        return shuffleLottoNumbers;
    }

    public int compareLottoAndReturnMatchCount(Lotto winningLotto) {
        return this.lottoNumbers.compareLottoNumbersAndReturnMatchCount(winningLotto.lottoNumbers);
    }

    public String numbersToString() {
        return this.lottoNumbers.numbersToString();
    }
}
