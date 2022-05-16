package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static domain.LottoNumber.of;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private static Stream<Set<LottoNumber>> provideInvalidLottoNumbers() {
        return Stream.of(
                Set.of(of(1),of(2),of(3),of(4),of(5)),
                Set.of(of(1),of(2),of(3),of(4),of(5),of(6),of(7))
        );
    }

    @DisplayName("로또 번호는 6개보다 작거나 클수 없다.")
    @MethodSource(value = "provideInvalidLottoNumbers")
    @ParameterizedTest
    void create(Set<LottoNumber> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("두개의 로또를 비교하여 일치하는 개수를 응답한다.")
    @Test
    void compareTo() {
        Lotto lotto = new Lotto(Set.of(of(1),of(2),of(3),of(4),of(5),of(6)));
        Lotto other = new Lotto(Set.of(of(1),of(2),of(3),of(7),of(8),of(9)));
        assertThat(lotto.compareTo(other)).isEqualTo(Reward.FOURTH);
    }

}
