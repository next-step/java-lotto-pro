import java.util.function.Supplier;

public class Application {
    public static final String NUMBER_DELEMETER = ", ";
    private static final ConsoleInputView consoleInputView = new ConsoleInputView();
    private static final ConsoleOutputView consoleOutputView = new ConsoleOutputView();
    private static final Vendor vendor = new Vendor();

    public static void main(String[] args) {
        Lotto lotto = retryIfThrowException(Application::getLotto);
        Lottery lottery = retryIfThrowException(Application::getLottery);
        Ranks ranks = lottery.aggregate(lotto);
        consoleOutputView.view(ranks, vendor.yield(ranks));
    }

    private static Lotto getLotto() {
        long inputLong = consoleInputView.inputLong(() -> "구입금액을 입력해 주세요.");
        int manualCount = consoleInputView.inputInt(() -> "수동으로 구매할 로또 수를 입력해 주세요.");
        Lotto manual = new Lotto();
        for (String string: consoleInputView.inputStringList(() -> "수동으로 구매할 번호를 입력해 주세요.", manualCount)) {
            manual.add(new LottoNumbers(string, NUMBER_DELEMETER));
        }
        Lotto lotto = vendor.buy(inputLong, manual);
        consoleOutputView.view(
                "수동으로 " + manual.size() + "장, 자동으로 " + (lotto.size() - manual.size()) + "개를 구매했습니다.");
        consoleOutputView.view(lotto);

        return lotto;
    }

    private static Lottery getLottery() {
        return new Lottery(getTopRankLottoNumbers(), getBonusLottoNumber());
    }

    private static LottoNumbers getTopRankLottoNumbers() {
        String inputString = consoleInputView.inputString(() -> "지난 주 당첨 번호를 입력해 주세요.");
        return new LottoNumbers(inputString, NUMBER_DELEMETER);
    }

    private static LottoNumber getBonusLottoNumber() {
        int input = consoleInputView.inputInt(() -> "보너스 볼을 입력해 주세요.");
        return new LottoNumber(input);
    }

    private static <T> T retryIfThrowException(Supplier<T> supplier) {
        T t;
        do {
            t = consoleExceptionHandler(supplier);
        } while (t == null);
        return t;
    }

    private static <T> T consoleExceptionHandler(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return null;
        }
    }
}
