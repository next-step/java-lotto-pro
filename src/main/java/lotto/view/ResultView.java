package lotto.view;

import lotto.domain.LottoGame;

public class ResultView {
    private static final String TRY_COUNT_MESSAGE = "개를 구매했습니다.";

    public void printLottoTryCount(LottoGame lottoGame) {
        StringBuilder builder = new StringBuilder();
        builder.append(lottoGame.getTryCount()).append(TRY_COUNT_MESSAGE);
        System.out.println(builder.toString());
    }

}
