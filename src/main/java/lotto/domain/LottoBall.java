package lotto.domain;

public class LottoBall implements Comparable<LottoBall> {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final int number;

    public LottoBall(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("1~45 숫자를 입력해야 합니다.");
        }
        this.number = number;
    }

    @Override
    public int compareTo(LottoBall other) {
        return Integer.compare(this.number, other.number);
    }
}
