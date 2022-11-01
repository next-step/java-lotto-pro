package study.step3.domain.utils;

import study.step3.domain.lotto.Lotto;
import study.step3.domain.lotto.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottosGenerator {

    public static Lottos createLottos(List<int[]> lottoNumbers) {
        List<Lotto> lottos = lottoNumbers.stream()
                .map(LottoNumbersGenerator::createLottoNumbers)
                .map(Lotto::new)
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }
}
