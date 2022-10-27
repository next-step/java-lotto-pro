package step3.domain;

public class Lotto {

    private final Numbers numbers;

    private Lotto() {
        throw new RuntimeException("Cannot use default constructor.");
    }

    private Lotto(Numbers numbers) {
        this.numbers = numbers;
    }

    public static Lotto generate(Numbers numbers) {
        return new Lotto(numbers);
    }

    public int getMatchCount(Numbers numbers) {
        return this.numbers.match(numbers);
    }
}