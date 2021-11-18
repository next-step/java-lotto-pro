package lotto.view;

import lotto.domain.GameResult;
import lotto.domain.Prize;
import lotto.domain.TicketAmount;
import lotto.dto.LottoTicketDTO;
import lotto.dto.LottoTicketsDTO;
import lotto.dto.MoneyDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final int BEP = 1;
    public static final String JOIN_DELIMITER = "\n";
    public static final String GAME_RESULT_MESSAGE = "%s (%d원)- %d개\n";
    public static final String EARNING_RATIO_MESSAGE = "총 수익률은 %f입니다. ";
    public static final String EARNING_RATIO_LOSS_MESSAGE = "기준이 1이기 때문에 결과적으로 손해라는 의미임";
    public static final String COUNT_OF_MATCH_MESSAGE = "%d개 일치";
    public static final String COUNT_OF_MATCH_SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치";
    public static final String TICKET_AMOUNT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";

    public ResultView() {
    }

    public void printBuyResult(LottoTicketsDTO lottoTicketsDTO) {
        String lottoResultStrings = getLottoResultString(lottoTicketsDTO);
        System.out.println(lottoResultStrings);
    }

    public String getLottoResultString(LottoTicketsDTO lottoTicketsDTO) {
        List<String> resultStrings = lottoTicketsDTO.getLottoTickets()
                .stream()
                .map(LottoTicketDTO::toString)
                .collect(Collectors.toList());
        return String.join(JOIN_DELIMITER, resultStrings);
    }

    public void printGameResult(GameResult gameResult) {
        for (Prize prize : Prize.values()) {
            if (prize == Prize.MISS) {
                continue;
            }
            String countOfMatchMessage = getCountOfMatchMessage(prize);
            System.out.printf(GAME_RESULT_MESSAGE, countOfMatchMessage, prize.getPrizeMoney(), gameResult.getMatchCount(prize));
        }
    }

    private String getCountOfMatchMessage(Prize prize) {
        String countOfMatchMessage = String.format(COUNT_OF_MATCH_MESSAGE, prize.getCountOfMatch());
        if (prize == Prize.SECOND) {
            countOfMatchMessage = COUNT_OF_MATCH_SECOND_PRIZE_MESSAGE;
        }
        return countOfMatchMessage;
    }

    public void printEarningRatio(MoneyDTO inputMoney, MoneyDTO prize) {
        double earningRatio = (double) prize.get() / inputMoney.get();
        String result = String.format(EARNING_RATIO_MESSAGE, earningRatio);
        if (earningRatio < BEP) {
            result += EARNING_RATIO_LOSS_MESSAGE;
        }
        System.out.print(result);
    }

    public void printCountOfLottoTickets(int countsOfManualTickets, TicketAmount countsOfAutoTickets) {
        System.out.printf(TICKET_AMOUNT_MESSAGE, countsOfManualTickets, countsOfAutoTickets.getTicketAmount());
    }
}
