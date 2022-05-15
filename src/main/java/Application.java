import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        ConsoleInputView consoleInputView = new ConsoleInputView();
        ConsoleOutputView consoleOutputView = new ConsoleOutputView();

        long inputLong = consoleInputView.inputLong(() -> "구입금액을 입력해 주세요.");

        Vendor vendor = new Vendor();
        Lottos lottos = vendor.buy(inputLong);

        consoleOutputView.view(lottos);

        String inputString = consoleInputView.inputString(() -> "지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> input = Arrays.stream(inputString.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lottery lottery = new Lottery(
                new LottoNumbers(input.stream()
                                .map(LottoNumber::new)
                                .collect(Collectors.toList())));
        Aggregator aggregator = vendor.aggregate(lottery.get(lottos));

        consoleOutputView.view(aggregator);
    }
}
