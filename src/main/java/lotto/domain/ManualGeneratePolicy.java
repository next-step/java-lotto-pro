package lotto.domain;

import java.util.List;
import lotto.view.InputView;

public class ManualGeneratePolicy implements GeneratePolicy {
    @Override
    public void generate(List<Lotto> lottoGroups, LottoCount lottoCount) {
        InputView.printInputManualLottoNumberHeader();
        for (int i = 0; i < lottoCount.getCount(); i++) {
            String numbers = InputView.inputManualLottoNumber();
            lottoGroups.add(new Lotto(LottoNumberGenerator.from(numbers)));
        }
    }
}
