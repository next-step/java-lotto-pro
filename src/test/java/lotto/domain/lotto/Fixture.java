package lotto.domain.lotto;

public class Fixture {
    public static NumberPickStrategy pick123456() {
        return new Pick123456Strategy();
    }

    public static Lotto winningNumbers123456() {
        return new Lotto(1, 2, 3, 4, 5, 6);
    }
}
