import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static List<Integer> numbers = new ArrayList<>();

    static {
        for (int i = 1; i < 45; i++) {
            numbers.add(i);
        }
    }

    private User user;

    public LottoGame() {
        user = new User(new BigInteger(InputView.inputMoney()));
    }

    public void start() {
        while (user.hasMoney()) {
            user.buyLotto();
        }

        ResultView.printBuyResult(user.howManyLotto());
        ResultView.printLottoList(user.getLottoList());

        user.checkMatch(inputWinLotto());

        ResultView.printResult(user);

    }

    public Lotto inputWinLotto() {
        return new Lotto(InputView.inputWinLotto());
    }

    public static int getLottoNumber() {
        Collections.shuffle(numbers);
        return numbers.get(0);
    }
}
