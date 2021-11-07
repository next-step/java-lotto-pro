package lotto.domain;

import lotto.exception.LottoPurchaseAmountException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.GAME_PRICE;

public class LottoMachine {

    private final Money money;
    private final List<List<Number>> activeNumberList;

    public LottoMachine(Money money) {
        validation(money);
        this.money = money;
        this.activeNumberList = new ArrayList<>();
    }

    public LottoMachine(Money money, List<List<Number>> activeNumberList) {
        this.money = money;
        this.activeNumberList = activeNumberList;
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
                .forEach(f -> lottoNumbers.add(new LottoNumber()));
        return lottoNumbers;
    }

    private List<LottoNumber> generateActiveLotto() {
        return activeNumberList.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validation(Money money) {
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
