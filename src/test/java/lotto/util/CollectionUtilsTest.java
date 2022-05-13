package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CollectionUtils 클래스 테스트")
class CollectionUtilsTest {

    @DisplayName("isEmpty시 비었는지 여부 반환")
    @ParameterizedTest
    @ArgumentsSource(IsEmptyArgumentsProvider.class)
    void isEmpty(List<Integer> list, boolean expected) {
        assertThat(CollectionUtils.isEmpty(list)).isEqualTo(expected);
    }

    static class IsEmptyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(null, true),
                    Arguments.of(Collections.emptyList(), true),
                    Arguments.of(Collections.singletonList(1), false)
            );
        }
    }
}