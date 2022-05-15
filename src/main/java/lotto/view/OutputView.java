package lotto.view;

import lotto.constant.LottoWinningConstant;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStore;
import lotto.message.OutputMessage;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public static void printLottoResult(LottoStore lottoStore, HashMap<Integer, Integer> lottoResult) {
        System.out.println(OutputMessage.RESULT_TITLE);
        System.out.println(String.format("%d개 일치(%d원)- %d개",
            LottoWinningConstant.MATCH_THREE,
            LottoWinningConstant.MATCH_THREE_CASH_PRIZE,
            lottoResult.get(LottoWinningConstant.MATCH_THREE
            )
        ));
        System.out.println(String.format("%d개 일치(%d원)- %d개",
            LottoWinningConstant.MATCH_FOUR,
            LottoWinningConstant.MATCH_FOUR_CASH_PRIZE,
            lottoResult.get(LottoWinningConstant.MATCH_FOUR
            )
        ));
        System.out.println(String.format("%d개 일치(%d원)- %d개",
            LottoWinningConstant.MATCH_FIVE,
            LottoWinningConstant.MATCH_FIVE_CASH_PRIZE,
            lottoResult.get(LottoWinningConstant.MATCH_FIVE
            )
        ));
        System.out.println(String.format("%d개 일치(%d원)- %d개",
            LottoWinningConstant.MATCH_SIX,
            LottoWinningConstant.MATCH_SIX_CASH_PRIZE,
            lottoResult.get(LottoWinningConstant.MATCH_SIX
            )
        ));

        float rateOfReturn = lottoStore.calculateRateOfReturn();
        System.out.print(String.format("총 수익률은 %.2f입니다.", rateOfReturn));

        if (rateOfReturn < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    public static void printLottoCount(int count) {
        System.out.println(String.format("%d개를 구매했습니다.", count));
    }

    public static void printLottoAutoNumbers(List<LottoNumbers> lottoAutoNumbers) {
        for (LottoNumbers lottoAutoNumber : lottoAutoNumbers) {
            System.out.println(lottoAutoNumber.getLottoNumbers());
        }
        System.out.println();
    }
}
