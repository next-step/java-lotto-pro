package step3;

public class Lotto {

    private final int number;

    public Lotto(final int number) {
        this.number = number;
    }

    private void verifyLottoNumber(final int number) {
        if (isAvailableLottoNumber(number)) {
            throw new IllegalArgumentException("잘못 된 로또 번호입니다.");
        }
    }

    private boolean isAvailableLottoNumber(final int number) {
        return number >= 1 && number <= 45;
    }
}
