package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private final List<LottoNumber> numberList;

    public LottoGenerator() {
        numberList = new ArrayList<>();

        for (int number = LottoNumber.MIN_LOTTO_NUMBER; number <= LottoNumber.MAX_LOTTO_NUMBER; number++) {
            numberList.add(new LottoNumber(number));
        }
    }

    public Lotto generateLotto() {
        shuffleLottoNumberList();
        return new Lotto(drawLottoNumbers());
    }

    public Lottos generateLottos(int size) {
        List<Lotto> lottoList = new ArrayList<>();
        return generateLottosWithList(lottoList, size);
    }

    public Lottos generateLottos(List<Lotto> manualLottoList, int autoSize) {
        List<Lotto> lottoList = new ArrayList<>();
        if (manualLottoList != null) {
            lottoList.addAll(manualLottoList);
        }
        return generateLottosWithList(lottoList, autoSize);
    }

    private Lottos generateLottosWithList(List<Lotto> lottoList, int size) {
        for (int i = 0; i < size; i++) {
            lottoList.add(generateLotto());
        }

        return new Lottos(lottoList);
    }

    private void shuffleLottoNumberList() {
        Collections.shuffle(numberList);
    }

    private List<LottoNumber> drawLottoNumbers() {
        return new ArrayList<>(numberList.subList(0, Lotto.LOTTO_SIZE));
    }
}
