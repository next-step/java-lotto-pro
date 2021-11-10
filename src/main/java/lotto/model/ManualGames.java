package lotto.model;

import lotto.view.strategy.Input;
import lotto.view.strategy.InputManualGameNumbers;

import java.util.ArrayList;
import java.util.List;

public class ManualGames {

    List<LottoNumbers> list;

    public ManualGames(final int manualGameCount) {
        list = new ArrayList<>();

        for (int i = 0; i < manualGameCount; i++) {
            Input input = new InputManualGameNumbers();
            String value = input.getValue();
            list.add(new LottoNumbers(value));
        }
    }

    public List<LottoNumbers> getList() {
        return list;
    }

}
