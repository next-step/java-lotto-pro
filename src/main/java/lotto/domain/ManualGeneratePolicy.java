package lotto.domain;

import java.util.List;

public class ManualGeneratePolicy implements GeneratePolicy {
    private final List<String> manualLottoGroups;

    public ManualGeneratePolicy(List<String> manualLottoGroups) {
        this.manualLottoGroups = manualLottoGroups;
    }

    @Override
    public void generate(List<Lotto> lottoGroups, LottoCount lottoCount) {
        for (int i = 0; i < lottoCount.getCount(); i++) {
            String numbers = manualLottoGroups.get(i);
            lottoGroups.add(new Lotto(LottoNumberGenerator.from(numbers)));
        }
    }
}
