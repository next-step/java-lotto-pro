package step3;

public class LottoApplication {
    public static void main(String[] args) {

        View view = new View();
        LottoService lottoService = new LottoService();

        int money = view.purchase();
        int purchasingNumber = lottoService.calculateLottoCount(money);
        lottoService.generateLottos(purchasingNumber);
        lottoService.matchWinningNumbers(view.inputWinnerNumbers());

        view.statistic(lottoService.getStatistics(), lottoService.statisticLottos(money));


    }
}
