package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ManualLottoNumbers {

    private final String[] lottoNumbers;

    public ManualLottoNumbers(String[] lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lottos convertLottos() {
        return new Lottos(Arrays.stream(lottoNumbers)
                .map(Lotto::createWithNumberLetter)
                .collect(Collectors.toList()));
    }
}
