package step3.domain;

import java.util.regex.Pattern;

public class LottoPayment {
    public static final String ONLY_NUMBER_REGEX = "^\\d*$";
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
}
