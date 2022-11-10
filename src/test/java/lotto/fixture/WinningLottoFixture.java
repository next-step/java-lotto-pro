package lotto.fixture;

import lotto.domain.Number;
import lotto.domain.WinningLotto;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class WinningLottoFixture {
    public static WinningLotto winningLotto() {
        return new WinningLotto(new String[]{"1", "2", "3", "4", "5", "6"}, new Number(7));
    }

    public static WinningLotto five_match_and_bonus_ball_match() {
        return new WinningLotto(new String[]{"1", "2", "3", "4", "5", "7"}, new Number(6));
    }

    public static WinningLotto five_match() {
        return new WinningLotto(new String[]{"1", "2", "3", "4", "5", "7"}, new Number(8));
    }

    public static WinningLotto threeMatch() {
        return new WinningLotto(new String[]{"1", "2", "3", "10", "11", "12"}, new Number(8));
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
