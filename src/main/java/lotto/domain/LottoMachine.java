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
    public final static Money GAME_PRICE = new Money(BigDecimal.valueOf(1000));

    private final Money money;
    private final List<List<Number>> activeNumberList;

    public LottoMachine(Money money) {
        validationMoney(money);
        this.money = money;
        this.activeNumberList = new ArrayList<>();
    }

    public LottoMachine(Money money, List<List<Integer>> activeNumberList) {
        this.money = money;
        this.activeNumberList = convertNumberList(activeNumberList);
    }

    public List<LottoNumber> getLottoList() {
        int autoCount = getPurchaseCount(GAME_PRICE) - activeNumberList.size();
        return Stream.concat(generateActiveLotto().stream(), generateAutoLotto(autoCount).stream())
                .collect(Collectors.toList());
    }

    private int getPurchaseCount(Money gamePrice) {
        return money.getMoney().divide(gamePrice.getMoney()).intValue();
    }

    private List<LottoNumber> generateAutoLotto(int count) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        IntStream.range(0, count)
                .forEach(f -> lottoNumbers.add(getAutoLottoNumbers()));
        return lottoNumbers;
    }

    private List<LottoNumber> generateActiveLotto() {
        return activeNumberList.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private List<List<Number>> convertNumberList(List<List<Integer>> activeNumbers) {
        return activeNumbers.stream()
                .map(m -> m.stream()
                        .map(s -> Number.of(s))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private LottoNumber getAutoLottoNumbers() {
        Set<Number> numbers = new HashSet<>();
        while (numbers.size() < LOTTO_SIZE) {
            numbers.add(Number.of(getRandomNumber()));
        }
        return new LottoNumber(new ArrayList<>(numbers));
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
