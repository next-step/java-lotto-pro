package lotto.domain;

import lotto.utils.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.common.ConstValue.LOTTO_PRICE;

public class LottoMoney {

    private final int money;
    private static final Pattern NUMBER_POSITIVE = Pattern.compile("^[0-9]+$");

    public LottoMoney(String money) {
        validEmpty(money);
        validPositiveNumber(money);
        validLottoPrice(Integer.parseInt(money));
        this.money = Integer.parseInt(money);
    }

    private void validPositiveNumber(String money) {
        Matcher matcher = NUMBER_POSITIVE.matcher(money);
        if (!matcher.find()) {
            throw new IllegalArgumentException("금액은 숫자만 입력가능합니다.");
        }
    }

    private void validEmpty(String money) {
        if (StringUtils.isNullOrEmpty(money)) {
            throw new IllegalArgumentException("금액을 입력해주세요.");
        }
    }

    private void validLottoPrice(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE || (purchasePrice % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException("로또 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

}
