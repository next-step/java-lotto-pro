package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.util.RandomUtils;

public class LottoGroups {
    private final List<Lotto> lottoGroups;

    public LottoGroups(int count) {
        this.lottoGroups = generateLottoGroups(count);
    }

    private List<Lotto> generateLottoGroups(int count) {
        List<Lotto> lottoGroups = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(RandomUtils.generateNonDuplicateNumbers());
            lottoGroups.add(lotto);
        }
        return lottoGroups;
    }

    public int size() {
        return lottoGroups.size();
    }
}
