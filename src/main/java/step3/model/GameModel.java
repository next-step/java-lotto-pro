package step3.model;

import static step3.LottoConstant.INPUT_IS_NOT_VALID;
import static step3.LottoConstant.INPUT_IS_VALID;

import java.util.HashMap;
import java.util.List;
import step3.domain.LottoManager;
import step3.domain.LottoTicket;

public class GameModel {

    private final LottoManager lottoManager;

    public GameModel(LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    public boolean validInput(String input, InputStatus inputStatus) {
        boolean validResult = true;

        if (inputStatus == InputStatus.LOTTO) {
            validResult = validLottoSource(input);
        }
        if (!validResult) {
            throw new IllegalArgumentException();
        }
        return validResult;
    }

    private boolean validLottoSource(String input) {
        return input.split(LOTTO_DELIMITER).length == LOTTO_ELEMENTS_SIZE;
    }


    public HashMap<Integer, Integer> checkWin(String winnerLottoSource) {
        return lottoManager.checkWin(winnerLottoSource);
    }

    public String buyTicket(String money) {
        try {
            lottoManager.buyRandomTicket(money);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return money;
    }

    public List<List<String>> getLottoNumbers() {
        return lottoManager.getLottoNumbers();
    }
}
