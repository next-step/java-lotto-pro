package lottoauto.domain;

import java.util.regex.Pattern;

public class LottoPayment {
    public static final String ONLY_NUMBER_REGEX = "^\\d*$";
    public static final int PRICE = 1000; // 로또 개당 가격
    private int payment;

    public LottoPayment(String payment) {
        validateOnlyNumber(payment);
        this.payment = Integer.parseInt(payment);
    }

    public void validateOnlyNumber(String payment) {
        if(!Pattern.matches(ONLY_NUMBER_REGEX, payment)){
            throw new IllegalArgumentException("문자는 올 수 없습니다.");
        }
    }

    public int buyLotto() {
        return this.payment / PRICE;
    }
}
