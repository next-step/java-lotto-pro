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
            numberList.add(new Number(number));
        }
        return new LottoTicket(numberList);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public void checkContainsNumber(Number number, Map<LottoTicket, Integer> winningCountCache) {
        for (LottoTicket lottoTicket : lottoTickets) {
            if (lottoTicket.isContainNumber(number)) {
                winningCountCache.put(lottoTicket, winningCountCache.getOrDefault(lottoTicket, 0) + 1);
            }
        }
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "lottoTickets=" + lottoTickets +
                '}';
    }

    public int getPurchaseMoney() {
        return this.lottoTickets.size() * LottoShop.LOTTO_TICKET_PER_PRICE;
    }
}
