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

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public void checkContainsNumber(Number number, Map<LottoTicket, Integer> winningCountCache) {
        for (LottoTicket lottoTicket : lottoTickets) {
            isContainsNumberAndCaching(number, winningCountCache, lottoTicket);
        }
    }

    public int getPurchaseMoney() {
        return this.lottoTickets.size() * LottoShop.LOTTO_TICKET_PER_PRICE;
    }

    public String getLottoTicketsString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoTicket lottoTicket : lottoTickets) {
            stringBuilder.append(lottoTicket.getLottoTicketString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Map<LottoTicket, Boolean> getContainsBonusNumberMap(Number bonusNumber) {
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
            numberList.add(new Number(number));
        }
        return new LottoTicket(numberList);
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "lottoTickets=" + lottoTickets +
                '}';
    }
}
