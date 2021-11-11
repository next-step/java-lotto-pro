package study.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoRandoms {
    private static final List<Integer> lottoNumbers = new ArrayList<>();

    static {
        for (int i = LottoNumber.MIN_NUMBER; i < LottoNumber.MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }

    public static Set<Integer> getLottoRandomNumbers() {
        Collections.shuffle(lottoNumbers);
        final List<Integer> lottoNumbers = LottoRandoms.lottoNumbers.subList(0, Lottery.LOTTO_NUMBER_COUNT);
        return Collections.unmodifiableSet(new HashSet<>(lottoNumbers));
    }
}
