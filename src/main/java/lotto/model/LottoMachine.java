package lotto.model;

import static java.util.stream.Collectors.toList;
import static lotto.constants.LottoConstant.LOTTO_PRICE;
import static lotto.utils.StringUtil.isInvalidFormat;
import static lotto.utils.StringUtil.isNullOrEmpty;

import java.util.List;
import java.util.stream.Stream;

public class LottoMachine {
    private static final String MONEY_FORMAT_REGEX = "^[1-9]+[0-9]*$";
    private final LottoNumbers lottoNumbers;

    public LottoMachine(String stringMoney) {
        validateFormat(stringMoney);
        int money = Integer.parseInt(stringMoney);
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

    private void validateFormat(String money) {
        if (isNotValid(money)) {
            throw new IllegalArgumentException("올바른 금액 양식이 아닙니다.");
        }
    }

    private boolean isNotValid(String money) {
        return isNullOrEmpty(money) || isInvalidFormat(money, MONEY_FORMAT_REGEX);
    }

    private void validateAmount(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 한 장의 금액보다 입력한 금액이 적습니다.");
        }
    }

    private int calculateCount(int money) {
        return money / LOTTO_PRICE;
    }
}
