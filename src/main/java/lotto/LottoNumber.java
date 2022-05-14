package lotto;

public class LottoNumber {

    private final int number;

    public LottoNumber(String number) {
        try {
            number = number.trim();
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
        }
    }

    public LottoNumber(Integer number) {
        this.number = number;
    }
}
