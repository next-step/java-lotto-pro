package lotto;

import static lotto.Constant.LOTTO_END_NUMBER;
import static lotto.Constant.LOTTO_NUMBER_SIZE;
import static lotto.Constant.LOTTO_START_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    private static final List<Integer> lottoNumberKeys = new ArrayList<>();

    static {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            lottoNumberKeys.add(number);
        }
    }

    InputView inputView = new InputView();

    public LottoNumbers autoGenerateNumbers() {
        Collections.shuffle(lottoNumberKeys);
        return LottoNumbers.from(lottoNumberKeys.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .collect(Collectors.toList()));
    }

    public LottoNumbers manualGenerateNumbers() {
        return inputView.inputManualLottoNumber();
    }
}
