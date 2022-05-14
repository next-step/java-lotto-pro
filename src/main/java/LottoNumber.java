public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        check(number);
        this.number = number;
    }

    private void check(int number) {
        if (number < 1 || number > 45)
            throw new RuntimeException();
    }

}
