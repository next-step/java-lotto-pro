package lotto.controller;

public class LottoCount {

    private final int count;

    public LottoCount(String count) {
        try {
            this.count = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public LottoCount(int count) {
        this.count = count;
    }

    public int count() {
        return count;
    }
}
