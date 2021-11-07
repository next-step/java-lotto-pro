import java.math.BigInteger;

public class LottoGame {
    public static final BigInteger lottoPrice = new BigInteger("1000");
    private User user;
    public Lotto winLotto;

    public LottoGame() {
        user = new User(new BigInteger(InputView.inputMoney()));
    }

    public void start(){
        while (user.hasMoney()){
            user.buyLotto();
        }

        ResultView.printBuyResult(user.howManyLotto());
        ResultView.printLottoList(user.getLottoList());

    }

}
