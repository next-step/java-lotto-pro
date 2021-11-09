package step3;

import step3.controller.LottoController;
import step3.service.LottoServiceImpl;

public class LottoApplication {

    public static void main(String[] args) {
        LottoController lottoController2 = new LottoController(new LottoServiceImpl());

        lottoController2.registerUserLottoBuyAmount();

        lottoController2.registerManualLottoNumbers();

        lottoController2.registerAutoLottoNumbers();

        lottoController2.lottoBoughtResult();

        lottoController2.registerLatestLottoNumberAndBonus();

        lottoController2.resultStatistics();
    }
}
