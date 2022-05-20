import java.util.List;
import java.util.function.Supplier;

public class Application {
    public static final String SEPARATOR = ", ";
    private static final ConsoleInputView consoleInputView = new ConsoleInputView();
    private static final ConsoleOutputView consoleOutputView = new ConsoleOutputView();
    private static final Vendor vendor = new Vendor();

    public static void main(String[] args) {
        LottoMoney lottoMoney = getMoney();
        Lotto manual = getManual();
        Lotto all = buyManualAndAuto(lottoMoney, manual);
        consoleOutputView.view("수동으로 " + manual.size() + "장, 자동으로 " + (all.size() - manual.size()) + "개를 구매했습니다.");
        consoleOutputView.view(all);
        Ranks ranks = getRanks(all);
        consoleOutputView.view(ranks);
    }

    public static LottoMoney getMoney() {
        return retryIfThrowException(() -> LottoMoney.of(consoleInputView.inputLong(() -> "구입금액을 입력해 주세요.")));
    }

    public static Lotto getManual() {
        return retryIfThrowException(() -> {
            int manualCount = consoleInputView.inputInt(() -> "수동으로 구매할 로또 수를 입력해 주세요.");
            return getManual(consoleInputView.inputStringList(() -> "수동으로 구매할 번호를 입력해 주세요.", manualCount));
        });
    }

    private static Lotto getManual(List<String> inputStringList) {
        Lotto manual = Lotto.empty();

        for (String string : inputStringList) {
            manual.add(new LottoNumbers(string, SEPARATOR));
        }

        return manual;
    }

    public static Lotto buyManualAndAuto(LottoMoney lottoMoney, Lotto manual) {
        return retryIfThrowException(() -> vendor.buyAutoContainsManual(lottoMoney, manual));
    }

    public static Ranks getRanks(Lotto all) {
        Lottery lottery = getLottery();
        return retryIfThrowException(() -> lottery.aggregate(all));
    }

    private static Lottery getLottery() {
        return retryIfThrowException(() -> {
            String inputString = consoleInputView.inputString(() -> "지난 주 당첨 번호를 입력해 주세요.");
            LottoNumbers lastWeekWinLottoNumbers = new LottoNumbers(inputString, SEPARATOR);

            int input = consoleInputView.inputInt(() -> "보너스 볼을 입력해 주세요.");
            LottoNumber bonusLottoNumber = new LottoNumber(input);
            return new Lottery(lastWeekWinLottoNumbers, bonusLottoNumber);
        });
    }

    private static <T> T retryIfThrowException(Supplier<T> supplier) {
        T t;
        do {
            t = consoleExceptionHandler(supplier);
        }
        while (t == null);
        return t;
    }

    private static <T> T consoleExceptionHandler(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (RuntimeException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return null;
        }
    }
}
