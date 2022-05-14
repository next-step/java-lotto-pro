package step3.model;

import static java.util.Collections.shuffle;
import static step3.LottoConstant.LOTTO_ELEMENTS_SIZE;
import static step3.LottoConstant.LOTTO_PRICE;
import static step3.LottoConstant.LOTTO_VALID_ELEMENTS;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import step3.InputStatus;
import step3.domain.LottoTicket;

public class GameModel {

    private final List<LottoTicket> tickets = new ArrayList<>();
    private final String LOTTO_DELIMITER = ",";

    private LottoTicket makeLottoTicket() {
        List<Integer> lottoElements = new ArrayList<>();
        shuffle(LOTTO_VALID_ELEMENTS);
        for (int i = 0; i < LOTTO_ELEMENTS_SIZE; i++) {
            lottoElements.add(LOTTO_VALID_ELEMENTS.get(i));
        }
        return LottoTicket.create(
            lottoElements.stream().map(String::valueOf).collect(Collectors.toList())
        );
    }

    public int buyTicket(int money) {
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            tickets.add(makeLottoTicket());
        }
        return tickets.size();
    }

    public boolean validInput(String input, InputStatus inputStatus) {
        boolean validResult = true;
        if (inputStatus == InputStatus.MONEY) {
            validResult = validMoney(input);
        }
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

    private boolean validMoney(String input) {
        boolean validResult = true;
        try {
            validResult = Integer.parseInt(input) >= LOTTO_PRICE;
        } catch (NumberFormatException e) {
            validResult = false;
        } finally {
            return validResult;
        }
    }
}
