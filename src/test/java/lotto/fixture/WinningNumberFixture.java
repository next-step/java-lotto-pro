package lotto.fixture;

import lotto.domain.BonusBall;
import lotto.domain.WinningLotto;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class WinningNumberFixture {
    public static WinningLotto winningNumber() {
        return new WinningLotto(new String[]{"1", "2", "3", "4", "5", "6"}, new BonusBall("7"));
    }

    public static WinningLotto winningNumber_one() {
        return new WinningLotto(new String[]{"4", "5", "6", "9", "10", "11"}, new BonusBall("7"));
    }

    static Stream<Arguments> size() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4"}, "7"),
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5"}, "7"),
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6", "7"}, "8"
                ));
    }

    static Stream<Arguments> duplicate() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "5"}, "7"));
    }

    static Stream<Arguments> type() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "x"}, "7"));
    }

    static Stream<Arguments> constructor() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6"}, "7")
        );
    }

    static Stream<Arguments> duplicateBonusBall() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6"}, "2")
        );
    }
}
