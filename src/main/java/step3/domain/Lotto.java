package step3.domain;

public class Lotto {

    private final Numbers numbers;

    private Lotto() {
        throw new RuntimeException("Cannot use default constructor.");
    }

    private Lotto(Numbers numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate(Numbers numbers) {
        return new Lotto(numbers);
    }

    public int getMatchCount(Numbers numbers) {
        return this.numbers.match(numbers);
    }

    private void validate(Numbers numbers) {
        if (numbers.isDuplicated()) {
            throw new IllegalArgumentException("Duplicate numbers cannot input.");
        }
    }

    @Override
    public String toString() {
        return "[" + numbers.toString() + "]";
    }
}