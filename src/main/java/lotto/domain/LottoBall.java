package lotto.domain;

public class LottoBall implements Comparable<LottoBall> {
    private final int number;

    public LottoBall(int number) {
        if (checkNumberRange(number)) {
            throw new IllegalArgumentException("1~45 숫자를 입력해야 합니다.");
        }
        this.number = number;
    }

    private boolean checkNumberRange(int number) {
        return number < LottoBallEnum.MIN_LOTTO_NUMBER.getNumber() || number > LottoBallEnum.MAX_LOTTO_NUMBER.getNumber();
    }

    @Override
    public int compareTo(LottoBall other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
