package lotto.domain;

import lotto.ui.InputView;

import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {

    @Override
    public List<Integer> create() {
        return InputView.inputManualLottoNumber();
    }
}
