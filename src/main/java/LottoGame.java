import java.math.BigInteger;

public class LottoGame {
    private User user;

    public LottoGame() {
        user = new User(new BigInteger(InputView.inputMoney()));
    }

    public void start(){
        while (user.hasMoney()){
            user.buyLotto();
        }

        ResultView.printBuyResult(user.howManyLotto());
        ResultView.printLottoList(user.getLottoList());

        user.checkMatch(inputWinLotto());

        ResultView.printResult(user);

    }

    public Lotto inputWinLotto(){
        return new Lotto(InputView.inputWinLotto());
    }
}
