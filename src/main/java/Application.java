import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final ConsoleInputView consoleInputView = new ConsoleInputView();
    private static final ConsoleOutputView consoleOutputView = new ConsoleOutputView();
    private static final Vendor vendor = new Vendor();

    public static void main(String[] args) {
        Lotto lotto = getLotto();
        Lottery lottery = getLottery();
        Ranks ranks = lottery.aggregate(lotto);
        consoleOutputView.view(ranks, vendor.yield(ranks));
    }

    private static Lotto getLotto() {
        long inputLong = consoleInputView.inputLong(() -> "구입금액을 입력해 주세요.");
        Lotto lotto = vendor.buy(inputLong);
        consoleOutputView.view(lotto);
        return lotto;
    }

    private static Lottery getLottery() {
        return new Lottery(getTopRankLottoNumbers(), getBonusLottoNumber());
    }

    private static LottoNumbers getTopRankLottoNumbers() {
        String inputString = consoleInputView.inputString(() -> "지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> input = Arrays.stream(inputString.split(", ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        return new LottoNumbers(input.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    private static LottoNumber getBonusLottoNumber() {
        int input = consoleInputView.inputInt(() -> "보너스 볼을 입력해 주세요.");
        return new LottoNumber(input);
    }
}
