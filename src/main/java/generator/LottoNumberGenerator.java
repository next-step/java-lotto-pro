package generator;

import static lotto.constants.LottoNumberConstants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator implements NumberGenerator{

    private final List<Integer> lottoBaseNumbers;

    public LottoNumberGenerator() {
        this.lottoBaseNumbers = initializeLottoBaseNumbers();
    }

    private List<Integer> initializeLottoBaseNumbers() {
        List<Integer> initializeLottoNumbers = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            initializeLottoNumbers.add(i);
        }
        return initializeLottoNumbers;
    }

    @Override
    public List<Integer> generate() {
        Collections.shuffle(this.lottoBaseNumbers);
        List<Integer> generateLottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            generateLottoNumbers.add(this.lottoBaseNumbers.get(i));
        }
        Collections.sort(generateLottoNumbers);
        return generateLottoNumbers;
    }
}
