package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class IssuedModeTest {

    @DisplayName("수동 모드와 자동모드 정보를 가진다.")
    @Test
    void createTest() {
        assertThat(IssuedMode.values()).contains(IssuedMode.Manual, IssuedMode.Auto);
    }

    @DisplayName("출력 테스트")
    @ParameterizedTest
    @MethodSource("provideIssuedModeAndExpectedMessage")
    void printTest(final IssuedMode mode, final String message) {
        assertThat(mode.toString()).isEqualTo(message);
    }

    private static Stream<Arguments> provideIssuedModeAndExpectedMessage(){
        return Stream.of(
                Arguments.of(IssuedMode.Manual, "수동"),
                Arguments.of(IssuedMode.Auto, "자동")
        );
    }
}
