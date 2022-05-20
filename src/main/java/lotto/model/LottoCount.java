package lotto.model;

public class LottoCount {
    private final int count;

    public LottoCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("로또 수는 음수 일수 없습니다.");
        }
        this.count = count;
    }

    public int of() {
        return count;
    }
}
