package lotto.view;

import lotto.domain.GameResult;
import lotto.domain.Prize;
import lotto.dto.LottoTicketDTO;
import lotto.dto.LottoTicketsDTO;
import lotto.dto.MoneyDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final int BEP = 1;
    public static final String JOIN_DELIMITER = "\n";
    public static final String BUY_MESSAGE = "%d개를 구매했습니다.";
    public static final String GAME_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    public static final String EARNING_RATIO_MESSAGE = "총 수익률은 %f입니다. ";
    public static final String EARNING_RATIO_LOSS_MESSAGE = "기준이 1이기 때문에 결과적으로 손해라는 의미임";
    private final Prize threeMatchPrize = Prize.THREE_MATCH_PRIZE;
    private final Prize fourMatchPrize = Prize.FOUR_MATCH_PRIZE;
    private final Prize fiveMatchPrize = Prize.FIVE_MATCH_PRIZE;
    private final Prize sixMatchPrize = Prize.SIX_MATCH_PRIZE;

    public ResultView() {
    }

    public void printBuyResult(LottoTicketsDTO lottoTicketsDTO) {
        System.out.printf(BUY_MESSAGE, lottoTicketsDTO.size());
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
        System.out.printf(GAME_RESULT_MESSAGE, threeMatchPrize.getMatchCount(), threeMatchPrize.getPrizeMoney(), gameResult.getMatchCount(threeMatchPrize.getMatchCount()));
        System.out.printf(GAME_RESULT_MESSAGE, fourMatchPrize.getMatchCount(), fourMatchPrize.getPrizeMoney(), gameResult.getMatchCount(fourMatchPrize.getMatchCount()));
        System.out.printf(GAME_RESULT_MESSAGE, fiveMatchPrize.getMatchCount(), fiveMatchPrize.getPrizeMoney(), gameResult.getMatchCount(fiveMatchPrize.getMatchCount()));
        System.out.printf(GAME_RESULT_MESSAGE, sixMatchPrize.getMatchCount(), sixMatchPrize.getPrizeMoney(), gameResult.getMatchCount(sixMatchPrize.getMatchCount()));
    }

    public void printEarningRatio(MoneyDTO inputMoney, MoneyDTO prize) {
        double earningRatio = (double) prize.get() / inputMoney.get();
        String result = String.format(EARNING_RATIO_MESSAGE, earningRatio);
        if (earningRatio < BEP) {
            result += EARNING_RATIO_LOSS_MESSAGE;
        }
        System.out.print(result);
    }
}
