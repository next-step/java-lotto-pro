package lotto_auto.model;

public class LottoCount {
    int count;
    public static final String NOT_NUMBER = "[ERROR] 로또 수는 숫자만 입력할 수 있습니다.";

    public LottoCount(String count) {
        try {
            this.count = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }

    }

    public int getCount() {
        return count;
    }
}
