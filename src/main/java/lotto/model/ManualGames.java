package lotto.model;

import lotto.exception.InvalidInputException;
import lotto.view.strategy.Input;
import lotto.view.strategy.InputManualGameNumbers;

import java.util.ArrayList;
import java.util.List;

public class ManualGames {

    private static final String INPUT_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";

    List<LottoNumbers> list;

    public ManualGames(final int manualGameCount) {
        list = new ArrayList<>();

        if (manualGameCount <= 0) {
            return;
        }

        System.out.println(INPUT_MESSAGE);

        for (int i = 0; i < manualGameCount; i++) {
            list.add(addManualGame());
        }
    }

    /**
     * 수동게임번호 추가
     *
     * @return
     */
    private LottoNumbers addManualGame() {
        try {
            Input input = new InputManualGameNumbers();
            String value = input.getValue();
            return new LottoNumbers(value);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            return addManualGame();
        }
    }

    public List<LottoNumbers> getList() {
        return list;
    }

}
