package step3.model;

import static java.util.Collections.shuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import step3.domain.LottoElement;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.enums.LottoReward;

public class LottoMachine {

    private final int LOTTO_MIN = 1;
    private final int LOTTO_MAX = 46;
    private final int LOTTO_ELEMENTS_SIZE = 6;
    private List<Integer> LOTTO_VALID_ELEMENTS = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX).boxed().collect(Collectors.toList());
    private final int MATCH_COUNT_BASE = 0;
    private final int LOTTO_PRICE = 1_000;
    private LottoElement bonusNumber;
    private LottoTicket winnerLotto;
    private final String SET_BONUS_NUMBER_EXCEPTION_MSG = "정답티켓과 다른 번호를 설정해야합니다";
    private final String CANT_BUY_LOTTO_EXCEPTION = "돈은 최소 " + LOTTO_PRICE + "이상 입력해야합니다";

    public LottoMachine() {

    }


    public List<LottoTicket> makeRandomLottoTickets(int ticket) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            lottoTickets.add(makeRandomLottoTicket());
        }
        return lottoTickets;
    }

    private LottoTicket makeRandomLottoTicket() {
        List<Integer> lottoElements = new ArrayList<>();
        shuffle(LOTTO_VALID_ELEMENTS);
        for (int i = 0; i < LOTTO_ELEMENTS_SIZE; i++) {
            lottoElements.add(LOTTO_VALID_ELEMENTS.get(i));
        }
        return new LottoTicket(lottoElements.stream().map(String::valueOf).collect(Collectors.toList()));
    }

    public boolean setBonusNumber(String lottoElementSource) {
        if (!validBonusNumber(lottoElementSource)) {
            System.out.println(SET_BONUS_NUMBER_EXCEPTION_MSG);
            return false;
        }
        bonusNumber = new LottoElement(Integer.parseInt(lottoElementSource));
        return true;
    }

    private boolean validBonusNumber(String lottoElementSource) {
        int isExist = 1;
        try {
            int bonusExistInWinnerTicket = winnerLotto.getMatchCountWith(Arrays.asList(new LottoElement(Integer.parseInt(lottoElementSource))));
            return bonusExistInWinnerTicket != isExist;
        } catch (NumberFormatException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public boolean setWinnerLotto(String winnerSource) {
        winnerLotto = makeManualLottoTicket(winnerSource);
        return winnerLotto != null;
    }

    private LottoTicket makeManualLottoTicket(String manualLottoSource) {
        try {
            return new LottoTicket(manualLottoSource);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public HashMap<LottoReward, Integer> checkWin(List<LottoTicket> lottoTickets) {
        LinkedHashMap<LottoReward, Integer> statistics = new LinkedHashMap<>();
        initStatistics(statistics);
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchNumber = lottoTicket.getMatchCountWith(winnerLotto.getLottoNumbers());
            int matchBonus = lottoTicket.getMatchCountWith(Arrays.asList(bonusNumber));
            LottoReward lottoReward = LottoReward.valueOf(matchNumber, matchBonus == 1);
            statistics.replace(lottoReward, statistics.get(lottoReward) + 1);
        }
        return statistics;
    }

    private void initStatistics(LinkedHashMap<LottoReward, Integer> statistics) {
        for (LottoReward lottoReward : LottoReward.values()) {
            statistics.put(lottoReward, MATCH_COUNT_BASE);
        }
    }

    public int getLottoTicketCount(Money money){
        int ticket = money.getMoney() / LOTTO_PRICE;
        if(ticket == 0){
            System.out.println(CANT_BUY_LOTTO_EXCEPTION);
        }
        return ticket;
    }

    public int getUsingMoneyByTicket(int ticket){
        return ticket * LOTTO_PRICE;
    }
}
