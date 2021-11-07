import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Price;
import lotto.model.Result;
import lotto.service.LottoCreateFactory;
import lotto.util.Console;
import lotto.view.InputHandler;
import lotto.view.Message;
import lotto.view.ResultView;
import lotto.view.View;


public class Application {
    private static Lottos lottos;
    private static Lotto winLotto;

    public static void main(String[] args) {
        try {
            buyLotto();

            setWinningLotto();

            statistics();
        } catch (Exception e) {
            View.print(e.getMessage());
        }
    }

    private static void buyLotto() {
        View.print(Message.PURCHASE_AMOUNT);
        int lottoCount = InputHandler.price(Console.readLine());
        ResultView.printBought(lottoCount);
        lottos = LottoCreateFactory.createLottos(lottoCount);
        View.print(lottos.toString());
    }

    private static void setWinningLotto() {
        View.print(Message.WINNING_NUMBER);
        int[] winLottoNumbers = InputHandler.splitTextToInts(Console.readLine());
        winLotto = LottoCreateFactory.createLotto(winLottoNumbers);
    }

    private static void statistics() {
        View.print(Message.WINNING_STATS);
        View.print(Message.WINNING_LINE);
        Result result = new Result(lottos,winLotto);
        View.print(result.toString());
        ResultView.printYield(result.yield(Price.getPurchase(lottos.size())));
    }
}
