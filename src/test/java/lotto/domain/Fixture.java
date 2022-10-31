package lotto.domain;

public class Fixture {
    public static NumberPickStrategy pick123456() {
        return new Pick123456Strategy();
    }
}
