package lotto.model;

import static java.util.stream.Collectors.toList;
import static lotto.constants.LottoConstant.LOTTO_PRICE;

import java.util.List;
import java.util.stream.Stream;

public class LottoMachine {
    private final LottoNumbers lottoNumbers;

    public LottoMachine(String inputMoney) {
        Money money = Money.of(inputMoney);
        validateAmount(money);
        lottoNumbers = new LottoNumbers(generateAutomaticLottoNumber(calculateCount(money)));
    }

    private List<LottoNumber> generateAutomaticLottoNumber(int count) {
        return Stream.generate(LottoNumberGenerator::auto)
                .limit(count)
                .collect(toList());
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    private void validateAmount(Money money) {
        if (money.compareTo(LOTTO_PRICE) < 0) {
            throw new IllegalArgumentException("로또 한 장의 금액보다 입력한 금액이 적습니다.");
        }
    }

    private int calculateCount(Money money) {
        return money.divide(LOTTO_PRICE);
    }
}
