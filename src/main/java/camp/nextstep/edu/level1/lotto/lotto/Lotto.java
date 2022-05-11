package camp.nextstep.edu.level1.lotto.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final static int LOTTO_PRICE = 1000;
    private final static int WINNING_NUMBER_COUNT = 6;
    private final static String WINNING_NUMBER_DELIMITER = ",";
    private final static Pattern POSITIVE_NUMBER_REGEX = Pattern.compile("^[1-9]\\d*$");

    private Money money;
    private List<LottoNumbers> items = new ArrayList<>();

    public Lotto(int value) {
        checkValidLottoPurchaseMoney(value);

        this.money = new Money(value);
        int availablePurchaseCount = money.getAvailablePurchaseCount(LOTTO_PRICE);

        this.purchaseLotto(availablePurchaseCount);
    }

    public void compareWinningNumber(String winningNumbers) {
        String[] splitResult = Arrays.stream(winningNumbers.split(WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
        checkValidWinningNumber(splitResult);

        Stream<LottoNumber> convertedWinningNumbers = Arrays.stream(splitResult)
                .map(number -> new LottoNumber(Integer.parseInt(number)));
    }

    private void checkValidLottoPurchaseMoney(int value) {
        if (value < LOTTO_PRICE) {
            String message = String.format("로또 구입시 최소 %d 원 이상이 있어야 합니다.", LOTTO_PRICE);
            throw new IllegalArgumentException(message);
        }
    }

    private void checkValidWinningNumber(String[] winningNumbers) {
        if (winningNumbers.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 이어야 합니다.");
        }
        if (Arrays.stream(winningNumbers).anyMatch(value -> !POSITIVE_NUMBER_REGEX.matcher(value).find())) {
            throw new IllegalArgumentException("당첨 번호는 숫자만 입력이 가능합니다.");
        }
    }

    private void purchaseLotto(int count) {
        for (int i = 0; i < count; i++) {
            this.items.add(new LottoNumbers());
        }

        this.money.sub(count * LOTTO_PRICE);

        System.out.printf("%d개를 구입했습니다.%n", count);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.items.stream().map(LottoNumbers::toString).collect(Collectors.joining("\n"));
    }
}
