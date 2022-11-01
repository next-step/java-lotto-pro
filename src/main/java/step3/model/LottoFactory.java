package step3.model;

import step2.StringParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {

    public static List<Lotto> createLottosByAuto(LottoMoney lottoMoney) {
        List<Lotto> lottos = new ArrayList();
        for (int i = 0; i < lottoMoney.getCountOfPurchasePrice(); i++) {
            lottos.add(createLottoByAuto());
        }
        return lottos;
    }

    private static Lotto createLottoByAuto() {
        List<LottoNumber> lottoNumbers = LottoNumber.getLottoNumbers();
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> randomLottoNumbers = lottoNumbers
                .stream()
                .limit(Lotto.getNumberSize())
                .collect(Collectors.toList());
        return new Lotto(randomLottoNumbers);
    }

    public static List<Lotto> createLottosByManual(List<String> lottoNumbers) {
        List<Lotto> lottos = new ArrayList();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            lottos.add(createLottoByManual(StringParser.parseToIntegerArray(lottoNumbers.get(i))));
        }
        return lottos;
    }

    private static Lotto createLottoByManual(List<Integer> lottNumber) {
        return new Lotto(lottNumber.stream().map(LottoNumber::valueOf).collect(Collectors.toList()));
    }

}
