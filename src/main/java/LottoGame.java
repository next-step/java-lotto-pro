import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static List<Integer> numbers = new ArrayList<>();
    public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_WIN_LOTTO = "\n지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "\n보너스 볼을 입력해 주세요.";
    public static final String INPUT_BUY_MANUAL_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_BUY_MANUAL_NUMBER = "\n수동으로 구매할 번호를 입력해 주세요.";

    static {
        for (int i = 1; i < 45; i++) {
            numbers.add(i);
        }
    }

    public void start(User user) {
        user.setMoney(new BigInteger(String.valueOf(InputView.inputInteger(INPUT_MONEY))));
        int manualCount = inputBuyManualCount(user);

        try{
            user.buyLottos(InputView.inputString(INPUT_BUY_MANUAL_NUMBER, manualCount));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            user.buyLottos(InputView.inputString(INPUT_BUY_MANUAL_NUMBER, manualCount));
        }
        ResultView.printLottoList(user.getLottoList());

        Lotto lotto = null;
        try {
             lotto = inputWinLotto();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            lotto = inputWinLotto();
        }

        LottoNumber bonusNumber = null;
        do {
            bonusNumber = inputBonusNumber();
        } while (lotto.isContainsNumber(bonusNumber));
        lotto.setBonusNumber(bonusNumber);

        user.checkMatch(lotto);
        ResultView.printResult(user);
    }

    public Lotto inputWinLotto() throws IllegalArgumentException{
        return new Lotto(InputView.inputString(INPUT_WIN_LOTTO));
    }

    public LottoNumber inputBonusNumber() {
        LottoNumber number = null;
        try {
            number = new LottoNumber(InputView.inputString(INPUT_BONUS_NUMBER));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            number = new LottoNumber(InputView.inputString(INPUT_BONUS_NUMBER));
        }
        return number;
    }

    public int inputBuyManualCount(User user){
        int manualCount = 0;
        do{
            manualCount = InputView.inputInteger(INPUT_BUY_MANUAL_COUNT);
        }while(! user.hasMoney(manualCount));
        return manualCount;
    }
}
