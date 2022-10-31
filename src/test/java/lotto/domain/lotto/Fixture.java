package lotto.domain.lotto;

public class Fixture {
    public static NumberPickStrategy pick123456() {
        return new Pick123456Strategy();
    }
}
