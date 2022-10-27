package step3;

public class Lotto {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int MAX_SELECT_NUMBER = 6;

    private final LottoNumbers numbers;

    private Lotto() {
        numbers = LottoNumbers.generate(START_NUMBER, END_NUMBER, MAX_SELECT_NUMBER);
    }

    public static Lotto generate() {
        return new Lotto();
    }
}
