package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryTicketFactory {

    public static final int LAST_NUMBER_IN_LOTTERY_TICKET = 45;
    public static final int FIRST_NUMBER_IN_LOTTERY_TICKET = 1;
    public static final int NUMBER_OF_CHOICES_IN_LOTTERY_TICKET = 6;

    public static LotteryNumbers createLotteryTicket() {
        List<Integer> ticketAllNumber = createLotteryTicketAllNumber();
        Collections.shuffle(ticketAllNumber);
        List<Integer> pickedSixLotteryNo = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_CHOICES_IN_LOTTERY_TICKET; i++) {
            pickedSixLotteryNo.add(ticketAllNumber.get(i));
        }
        return LotteryNumbers.createAutoLotteryNumber(pickedSixLotteryNo);
    }

    private static List<Integer> createLotteryTicketAllNumber() {
        List<Integer> lottoCard = new ArrayList<>();
        for (int i = FIRST_NUMBER_IN_LOTTERY_TICKET; i <= LAST_NUMBER_IN_LOTTERY_TICKET; i++) {
            lottoCard.add(i);
        }
        return lottoCard;
    }
}
