package lotto.fixture;

import lotto.domain.WinningNumber;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class WinningNumberFixture {
    public static WinningNumber 당첨번호123456() {
        return new WinningNumber(new String[]{"1", "2", "3", "4", "5", "6"});
    }

    public static WinningNumber 당첨번호45691011() {
        return new WinningNumber(new String[]{"4", "5", "6", "9", "10", "11"});
    }

    static Stream<Arguments> size() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4"}),
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5"}),
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6", "7"})
        );
    }

    static Stream<Arguments> duplicate() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "5"})
        );
    }

    static Stream<Arguments> type() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "x"})
        );
    }

    static Stream<Arguments> constructor() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1", "2", "3", "4", "5", "6"})
        );
    }
}
