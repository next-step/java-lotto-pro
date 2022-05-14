package step3.model;

import static java.util.Collections.shuffle;
import static step3.LottoConstant.LOTTO_DELIMITER;
import static step3.LottoConstant.LOTTO_ELEMENTS_SIZE;
import static step3.LottoConstant.LOTTO_PRICE;
import static step3.LottoConstant.LOTTO_VALID_ELEMENTS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import step3.InputStatus;
import step3.domain.LottoTicket;

public class GameModel {

    private List<LottoTicket> tickets = new ArrayList<>();
    private HashMap<Integer, Integer> statistics;

    public GameModel(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public GameModel() {
    }

    private LottoTicket makeLottoTicket() {
        List<Integer> lottoElements = new ArrayList<>();
        shuffle(LOTTO_VALID_ELEMENTS);
        for (int i = 0; i < LOTTO_ELEMENTS_SIZE; i++) {
            lottoElements.add(LOTTO_VALID_ELEMENTS.get(i));
        }
        return LottoTicket.create(lottoElements.stream().map(String::valueOf).collect(Collectors.toList()));
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

    public HashMap<Integer, Integer> checkWin(String winLottoSource) {
        initStatistics();
        LottoTicket winLotto = LottoTicket.create(Arrays.asList(winLottoSource.split(LOTTO_DELIMITER)));
        for (int i = 0; i < tickets.size(); i++) {
            int matchCount = winLotto.getMatchCountWith(tickets.get(i));
            statistics.replace(matchCount, statistics.get(matchCount) + 1);
        }
        return statistics;
    }

    private void initStatistics() {
        statistics = new HashMap<>();
        for (int i = 0; i <= LOTTO_ELEMENTS_SIZE; i++) {
            statistics.put(i, 0);
        }
    }

    public List<List<String>> getLottoNumbers() {
        return tickets.stream().map(LottoTicket::getLottoNumbers)
            .collect(Collectors.toList());
    }
}
