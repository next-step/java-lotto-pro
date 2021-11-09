import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static List<Integer> numbers = new ArrayList<>();

    static {
        for (int i = 1; i < 45; i++) {
            numbers.add(i);
        }
    }

    public void start() {
        String money = InputView.inputMoney();
        User user = new User(new BigInteger(money));
        user.buyLottos();

        ResultView.printBuyResult(user.howManyLotto());
        ResultView.printLottoList(user.getLottoList());

        Lotto lotto = inputWinLotto();

        LottoNumber bonusNumber = null;
        do {
            bonusNumber = inputBonusNumber();
        } while (lotto.isContainsNumber(bonusNumber));
        lotto.setBonusNumber(bonusNumber);

        user.checkMatch(lotto);
        ResultView.printResult(user);
    }

    public Lotto inputWinLotto() {
        return new Lotto(InputView.inputWinLotto());
    }

    public LottoNumber inputBonusNumber() {
        LottoNumber number = null;
        try {
            number = new LottoNumber(InputView.inputBonusNumber());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputBonusNumber();
        }
        return number;
    }
}
