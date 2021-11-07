package lotto.domain;

import lotto.exception.LottoPurchaseAmountException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.domain.Number.MAX_NUMBER;
import static lotto.domain.Number.MIN_NUMBER;
import static lotto.utils.RandomNumberUtils.generateRandomNumbers;

public class LottoMachine {

    public static final int LOTTO_SIZE = 6;
    public static final Money GAME_PRICE = new Money(BigDecimal.valueOf(1000));

    public List<LottoNumber> getLottoList(Money money) {
        validationMoney(money);
        int autoCount = getPurchaseCount(money, GAME_PRICE);
        return generateAutoLotto(autoCount).stream()
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoList(Money money, List<List<Integer>> activeNumberList) {
        int activeCount = activeNumberList.size();
        int autoCount = getPurchaseCount(money, GAME_PRICE) - activeCount;

        return Stream.concat(generateActiveLotto(activeNumberList).stream(), generateAutoLotto(autoCount).stream())
                .collect(Collectors.toList());
    }

    public LottoNumber getLottoNumber(List<Integer> numbers) {
        return new LottoNumber(numbers.stream()
                .map(m -> Number.of(m))
                .collect(Collectors.toList()));
    }

    public Number getBonusNumber(int bonusNumber) {
        return Number.of(bonusNumber);
    }

    private int getPurchaseCount(Money purchaseAmount, Money gamePrice) {
        return purchaseAmount.getMoney().divide(gamePrice.getMoney()).intValue();
    }

    private List<LottoNumber> generateAutoLotto(int count) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        IntStream.range(0, count)
                .forEach(f -> lottoNumbers.add(getAutoLottoNumbers()));
        return lottoNumbers;
    }

    private List<LottoNumber> generateActiveLotto(List<List<Integer>> activeNumbers) {
        return activeNumbers.stream()
                .map(m -> getLottoNumber(m))
                .collect(Collectors.toList());
    }

    private LottoNumber getAutoLottoNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < LOTTO_SIZE) {
            numbers.add(getRandomNumber());
        }
        LottoNumber lottoNumber = getLottoNumber(new ArrayList<>(numbers));
        return lottoNumber;
    }

    private int getRandomNumber() {
        return generateRandomNumbers(MIN_NUMBER, MAX_NUMBER);
    }

    private void validationMoney(Money money) {
        validateZeroAmount(money);
        validateRemainderAmount(money);
    }

    private void validateRemainderAmount(Money money) {
        if (!money.getMoney().remainder(GAME_PRICE.getMoney()).equals(BigDecimal.ZERO)) {
            System.out.println("[ERROR] 구입 시도 금액이 잘못되었습니다.");
            throw new LottoPurchaseAmountException("[ERROR] 구입 시도 금액이 잘못되었습니다.");
        }
    }

    private void validateZeroAmount(Money purchaseAmount) {
        if (purchaseAmount.equals(BigDecimal.ZERO)) {
            System.out.println("[ERROR] 구입 할 금액을 입력해주세요.");
            throw new LottoPurchaseAmountException("[ERROR] 구입 할 금액을 입력해주세요.");
        }
    }

}
