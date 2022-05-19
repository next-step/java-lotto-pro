package study.lotto.util;

import java.util.ArrayList;
import java.util.List;
import study.lotto.Lotto;
import study.lotto.LottoNumber;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private LottoGenerator() {
    }

    public static List<Lotto> generate(int genSize) {
        validate(genSize);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < genSize; i++) {
            lottos.add(newAutoLotto());
        }
        return lottos;
    }

    private static void validate(int genSize) {
        if (genSize < 1) {
            throw new IllegalArgumentException("한 개 이상의 숫자를 입력해주세요.");
        }
    }

    private static Lotto newAutoLotto() {
        return new Lotto(getRandomLottoNumbers());
    }

    private static List<LottoNumber> getRandomLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        do {
            addNotExists(lottoNumbers, new LottoNumber());
        } while (lottoNumbers.size() < LottoGenerator.LOTTO_NUMBER_SIZE);
        return lottoNumbers;
    }

    private static void addNotExists(List<LottoNumber> lottoNumbers, LottoNumber lottoNumber) {
        if (!lottoNumbers.contains(lottoNumber)) {
            lottoNumbers.add(lottoNumber);
        }
    }
}
