package lotto.model;

public class LottoCount {
    public static final String POSITIVE_NUMBER_MESSAGE = "0 이상의 숫자를 입력하세요.";
    public static final String LOTTO_COUNT_EXCEED_MESSAGE = "로또의 갯수는 구입 금액을 초과할 수 없습니다.";
    int autoCount;
    int manualCount;

    public LottoCount(String manualCount, Money money) {
        int count = Integer.parseInt(manualCount);
        if (validateNegativeNumber(count)) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_MESSAGE);
        }
        if (money.isExceed(count)) {
            throw new IllegalArgumentException(LOTTO_COUNT_EXCEED_MESSAGE);
        }
        this.autoCount = money.getLottoCount() - count;
        this.manualCount = count;
    }

    private boolean validateNegativeNumber(int lottoCount) {
        return lottoCount < 0;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }
}
