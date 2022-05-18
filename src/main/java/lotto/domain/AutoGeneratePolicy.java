package lotto.domain;

import java.util.List;

public class AutoGeneratePolicy implements GeneratePolicy {
    @Override
    public void generate(List<Lotto> lottoGroups, LottoCount lottoCount) {
        for (int i = 0; i < lottoCount.getCount(); i++) {
            lottoGroups.add(new Lotto());
        }
    }
}
