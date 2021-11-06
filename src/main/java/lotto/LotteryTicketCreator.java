package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryTicketCreator {

    public static LotteryTicket createLotteryTicket() {
        List<Integer> card = lotteryCardNumber();
        Collections.shuffle(card);
        List<Integer> pickedSixLotteryNo = new ArrayList<>();
        for (int i = 0 ; i < 6 ; i++) {
            pickedSixLotteryNo.add(card.get(i));
        }
        return new LotteryTicket(pickedSixLotteryNo);
    }

    private static List<Integer> lotteryCardNumber() {
        List<Integer> lottoCard = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoCard.add(i);
        }
        return lottoCard;
    }
}
