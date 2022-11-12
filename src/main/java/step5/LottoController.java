package step5;

import step5.model.Lotto;
import step5.model.LottoResult;
import step5.model.Lottos;
import step5.service.LottoService;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    /**
     * 1. 구입 금액 입력
     * 2. 수동 구매 로또 수 입력
     * 3. 수동 구매할 번호 입력
     * 4. 수동, 자동 구매 개수 확인
     * 5. 당첨 번호 입력
     * 6. 보너스 번호 입력
     * 7. 당첨 통계 출력
     */
    public void gameStart() {
        try {

            InputView inputView = new InputView();
            LottoService lottoService = new LottoService();

            //구입 금액 입력
            int money = inputView.readyBuyingLotto();
            lottoService.validBuyLottosByMoney(money);

            //수동 구매 로또 수 입력
            int countManualLottos = inputView.readyBuyingManualLotto();
            lottoService.validManualLottosCount(money, countManualLottos);

            //수동 구매 로또 번호 입력
            List<Lotto> manualLottos = inputView.readyManualLottos(countManualLottos)
                    .stream()
                    .map(lottoService::getLottoByLottoNumbers)
                    .collect(Collectors.toList());

            //수동, 자동 구매 개수 확인 출력
            Lottos lottos = lottoService.buyLottosByMoney(money, manualLottos);
            inputView.printBoughtLottoCountAndManualLottoCount(lottos.count(), countManualLottos);
            inputView.printLottos(lottos);

            //당첨 번호 입력
            Lotto winningLotto = lottoService.getLottoByLottoNumbers(inputView.readyWinningLotto());

            //보너스 번호 입력
            int bonus = inputView.readyBonus();
            LottoResult lottoResults = lottoService.getResultComparedToWinningNumbers(winningLotto, bonus, lottos);

            printResult(money, lottoResults);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void printResult(int money, LottoResult lottoResult) {
        ResultView resultView = new ResultView();
        resultView.printLottoResult(lottoResult);

        resultView.printRate(lottoResult.getProfitRate(money));
    }
}
