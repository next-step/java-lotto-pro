package lotto.constant;

public class LottoRoleConst {

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_LIST_SIZE = 6;
    public static final int LOTTO_MAX_PURCHASE_PRICE = 10_000_000;
    public static final int LOW_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private LottoRoleConst() {
        throw new IllegalStateException(ErrorMessage.CONSTANT_CLASS);
    }

}
