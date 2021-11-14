package lotto.domain;

import java.util.*;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets(int[][] numberArray) {
        this.lottoTickets = convertArrayToLottoTickets(numberArray);
    }

    public void checkContainsNumber(Number number, Map<LottoTicket, Integer> winningCountCache) {
        for (LottoTicket lottoTicket : lottoTickets) {
            isContainsNumberAndCaching(number, winningCountCache, lottoTicket);
        }
    }

    public int calculatePurchaseMoney() {
        return this.lottoTickets.size() * LottoShop.LOTTO_TICKET_PER_PRICE;
    }

    public Map<LottoTicket, Boolean> checkContainsBonusNumber(Number bonusNumber) {
        Map<LottoTicket, Boolean> containsBonusNumbers = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            containsBonusNumbers.put(lottoTicket, lottoTicket.isContainNumber(bonusNumber));
        }
        return containsBonusNumbers;
    }

    private void isContainsNumberAndCaching(Number number, Map<LottoTicket, Integer> winningCountCache, LottoTicket lottoTicket) {
        if (lottoTicket.isContainNumber(number)) {
            winningCountCache.put(lottoTicket, winningCountCache.getOrDefault(lottoTicket, 0) + 1);
        }
    }

    private List<LottoTicket> convertArrayToLottoTickets(int[][] numberArray) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int[] numbers : numberArray) {
            lottoTickets.add(convertArrayToLottoTicket(numbers));
        }
        return lottoTickets;
    }

    private LottoTicket convertArrayToLottoTicket(int[] numbers) {
        List<Number> numberList = new ArrayList<>();
        for (int number : numbers) {
            numberList.add(Number.of(number));
        }
        return new LottoTicket(numberList);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "lottoTickets=" + lottoTickets +
                '}';
    }
}
