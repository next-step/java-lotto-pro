package step3;

import step3.controller.LottoController2;
import step3.service.LottoServiceImpl;

public class LottoApplication {

    public static void main(String[] args) {
        LottoController2 lottoController2 = new LottoController2(new LottoServiceImpl());
        // 구입금액을 입력해 주세요.
        // 수동으로 구매할 로또 수를 입력해 주세요.
        lottoController2.registerUserLottoBuyAmount();

        // 수동으로 구매할 번호 입력해 주세요.
        lottoController2.registerManualLottoNumbers();

        // 자동 로또 구매
        lottoController2.registerAutoLottoNumbers();

        //수동으로 3장 자동으로 11개를 구매했습니다.
        // 구매된 로또 번호 출력
        lottoController2.lottoBoughtResult();

        // 지난 주 당첨 번호를 입력해 주세요.
        // 보너스 볼을 입력해주세요.
        lottoController2.registerLatestLottoNumberAndBonus();

        // 통계 출력
        lottoController2.resultStatistics();

    }
}
