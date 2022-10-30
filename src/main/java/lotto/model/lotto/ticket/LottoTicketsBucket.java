package lotto.model.lotto.ticket;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketsBucket {
    protected final List<LottoTicket> lottoTickets;

    public LottoTicketsBucket(int howManyTickets) {
        if (!isZeroOrPositive(howManyTickets)) {
            throw new IllegalStateException("구매하려는 로또 개수가 올바르지 않습니다.");
        }
        lottoTickets = new ArrayList<>(howManyTickets);
    }

    private boolean isZeroOrPositive(int howManyTickets) {
        return 0 <= howManyTickets;
    }

//    private final int[] lottoSameNumberCount;
//    protected final List<LottoTicket> lottoTickets;
//
//    public LottoTicketsBucket(int howManyTickets) {
//        this(new ArrayList<>(howManyTickets));
//    }
//
//    public LottoTicketsBucket(List<LottoTicket> lottoTickets) {
//        lottoSameNumberCount = new int[]{0, 0, 0, 0, 0, 0, 0};
//        this.lottoTickets = lottoTickets;
//    }
//
//    public LottoTicketsBucket(int[] lottoSameNumberCount) {
//        this.lottoSameNumberCount = lottoSameNumberCount;
//        lottoTickets = new ArrayList<>();
//    }
//
//    public void addLottoTicket(LottoTicket lottoTicket) {
//        lottoTickets.add(lottoTicket);
//    }
//
//    public int[] sameNumberCountOfAllLottoTickets(WinningNumbers winningNumbers) {
//        for (LottoTicket lottoTicket : lottoTickets) {
////            final int count = lottoTicket.sameNumbersCount(winningNumbers);
////            ++lottoSameNumberCount[count];
//        }
//        return lottoSameNumberCount;
//    }
//
//    public int sameThreeNumbersCount() {
//        return lottoSameNumberCount[3];
//    }
//
//    public int sameFourNumbersCount() {
//        return lottoSameNumberCount[4];
//    }
//
//    public int sameFiveNumbersCount() {
//        return lottoSameNumberCount[5];
//    }
//
//    public int sameSixNumbersCount() {
//        return lottoSameNumberCount[6];
//    }
//
//    public int sumProfit() {
//        return lottoSameNumberCount[3] * LottoConstant.PROFIT_THREE_DIGITS_MATCH +
//                lottoSameNumberCount[4] * LottoConstant.PROFIT_FOUR_DIGITS_MATCH +
//                lottoSameNumberCount[5] * LottoConstant.PROFIT_FIVE_DIGITS_MATCH +
//                lottoSameNumberCount[6] * LottoConstant.PROFIT_SIX_DIGITS_MATCH;
//    }
}
