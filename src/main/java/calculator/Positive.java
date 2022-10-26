package calculator;

import java.util.Objects;

public class Positive {
    private final int positive;

    public Positive() {
        this(0);
    }

    public Positive(String positive) {
        this(Integer.parseInt(positive));
    }

    public Positive(int positive) {
        if(positive < 0){
            throw new RuntimeException("음수는 사용이 불가능");
        }
        this.positive = positive;
    }


    public Positive sum(Positive otherPositive) {
        return new Positive(this.positive + otherPositive.positive);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive positive1 = (Positive) o;
        return positive == positive1.positive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positive);
    }

    public int value() {
        return positive;
    }
}
