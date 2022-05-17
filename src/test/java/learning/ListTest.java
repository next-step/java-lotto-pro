package learning;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ListTest {

    @Test
    void 인자로_SET을_받아서_LIST를_생성한다() {
        // given
        String[] strings = {"아반테", "소나타"};
        Set<String> cars = Stream.of(strings)
                .collect(Collectors.toSet());
        // when
        List<String> result = new ArrayList<>(cars);
        // then
        assertThat(result).containsExactly(strings);
    }
}
