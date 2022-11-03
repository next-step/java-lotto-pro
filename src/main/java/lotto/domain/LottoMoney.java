package lotto.domain;

import lotto.utils.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.common.ConstValue.LOTTO_PRICE;

public class LottoMoney {

    private final int money;
    private final int ticketCount;
    private static final Pattern NUMBER_POSITIVE = Pattern.compile("^[0-9]+$");
    private static final int ZERO = 0;

    public LottoMoney(String money) {
        validEmpty(money);
        validPositiveNumber(money);
        validLottoPrice(Integer.parseInt(money));
        this.money = Integer.parseInt(money);
        this.ticketCount = this.money / LOTTO_PRICE;
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

    public void getValidLottoPurchaseCount(int lottoPurchaseCount) {
        validPositiveLottoTicketCount(lottoPurchaseCount);
        compareLottoTicketCountToMoney(lottoPurchaseCount);
    }

    private int convertToInt(String lottoTicketCount) {
        try {
            return Integer.parseInt(lottoTicketCount);
        } catch (Exception e) {
            throw new IllegalArgumentException("구매할 로또 수는 숫자만 입력 가능합니다.");
        }
    }

    private void validPositiveLottoTicketCount(int lottoTicketCount) {
        if (lottoTicketCount < ZERO) {
            throw new IllegalArgumentException("구입하려는 로또 개수는 0또는 양수만 가능합니다.");
        }
    }

    private void compareLottoTicketCountToMoney(int lottoTicketCount) {
        int ticketPrice = lottoTicketCount * LOTTO_PRICE;
        if (money < ticketPrice) {
            throw new IllegalArgumentException("구입하려는 로또 개수가 현재 가진 금액보다 많습니다.");
        }
    }

    public int getMoney() {
        return money;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public int autoLottoCount(int count) {
        return ticketCount - count;
    }

}
