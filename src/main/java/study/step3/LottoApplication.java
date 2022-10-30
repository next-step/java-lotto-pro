package study.step3;

public class LottoApplication {
    public static void main(String[] args) {
        Money money = new Money(InputView.inputMoney());

        Lottos lottos = LottoMaker.makeLottos(money);
        ResultView.printLottos(lottos);

        String winLottoNumbers = InputView.inputWinningNumbers();

        Winners winners = lottos.findWinners(winLottoNumbers);
        ResultView.printLottoWinners(winners);
        ResultView.printEarningRate(winners, money);
    }
}
