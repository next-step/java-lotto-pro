package lottoauto.service;

import lottoauto.util.Rank;
import lottoauto.wrapper.Lotto;
import lottoauto.wrapper.LottoNo;
import lottoauto.wrapper.Price;
import lottoauto.wrapper.TryTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LottoTicket {


    List<Lotto> listLotto;
    Lotto winnerLotto;
    LottoNo bonusLotto;

    public LottoTicket() {
        this.listLotto = new ArrayList<>();
    }

    public LottoTicket(List<Lotto> listLotto, Lotto winnerLotto, LottoNo bonusLotto) {
        this.listLotto = listLotto;
        this.winnerLotto = winnerLotto;
        this.bonusLotto = bonusLotto;
    }

    public List<Lotto> getListLotto() {
        return listLotto;
    }

    public void add(Lotto lotto) {
        listLotto.add(lotto);
    }

    public void addAll(TryTime tryTime) {
        for (int i = 0; i < tryTime.getTryTimes(); i++) {
            listLotto.add(new Lotto());
        }
    }



    public void printAll() {
        for (Lotto lotto : listLotto) {
            System.out.println(lotto.toString());
        }
    }

    public int size() {
        return listLotto.size();
    }

    public int compareTickets(Lotto compareLotto) {
        return winnerLotto.compare(compareLotto.toList());
    }

    public boolean compareBonusTickets(Lotto compareLotto) {
        return bonusLotto.compareBonus(compareLotto.toList());
    }

    public void makeWinnerMap(Map<Integer, Integer> winnerMap) {
        for (int indexKey = 0; indexKey < listLotto.size(); indexKey++) {
            addWinnerMapValueByKey(winnerMap, indexKey);
        }
    }


    private void addWinnerMapValueByKey(Map<Integer, Integer> winnerMap, int indexKey) {
        Lotto compareLotto = listLotto.get(indexKey);

        matchedCountCheck(matchedCount(compareLotto, Rank.FIRST), winnerMap, Rank.FIRST);
        matchedCountCheck(matchedCount(compareLotto, Rank.SECOND) && compareBonusTickets(compareLotto), winnerMap, Rank.SECOND);
        matchedCountCheck(matchedCount(compareLotto, Rank.THIRD) && !compareBonusTickets(compareLotto), winnerMap, Rank.THIRD);
        matchedCountCheck(matchedCount(compareLotto, Rank.FOURTH), winnerMap, Rank.FOURTH);
        matchedCountCheck(matchedCount(compareLotto, Rank.FIFTH), winnerMap, Rank.FIFTH);
    }


    private void matchedCountCheck(boolean compareLotto, Map<Integer, Integer> winnerMap, Rank rank) {
        if (compareLotto) {
            winnerMap.put(rank.getLottoRank(), winnerMap.get(rank.getLottoRank()) + 1);
        }
    }

    private boolean matchedCount(Lotto compareLotto, Rank rank) {
        return compareTickets(compareLotto) == rank.getCountOfMatch();
    }


}
