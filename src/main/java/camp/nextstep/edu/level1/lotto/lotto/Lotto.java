package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.until.CollectionHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final static long LOTTO_PRICE = 1000;
    private final static int WINNING_NUMBER_COUNT = 6;
    private final static String WINNING_NUMBER_DELIMITER = ",";

    private Money money;
    private List<LottoNumbers> items = new ArrayList<>();

    public Lotto(int value) {
        checkValidLottoPurchaseMoney(value);

        this.money = new Money(value);
        long availablePurchaseCount = money.getAvailablePurchaseCount(LOTTO_PRICE);

        this.purchaseLotto(availablePurchaseCount);
    }

    public LottoResult compareWinningNumber(String winningNumbers) {
        String[] splitResult = Arrays.stream(winningNumbers.split(WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
        checkValidWinningNumber(splitResult);

        LottoNumbers winnerLottoNumbers = new LottoNumbers(
                CollectionHelper.arrayStringToIntegerList(splitResult)
        );

        return new LottoResult(this.items, winnerLottoNumbers);
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
    }

    private void purchaseLotto(long count) {
        for (int i = 0; i < count; i++) {
            this.items.add(new LottoNumbers());
        }

        this.money.sub(count * LOTTO_PRICE);

        System.out.printf("%d개를 구입했습니다.%n", count);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.items.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.joining("\n"));
    }
}
