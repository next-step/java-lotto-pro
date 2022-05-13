package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListUtilsTest {

    @Test
    @DisplayName("리스트를 복사하여 섞기")
    void suffle() {
        // given
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");

        // when
        final List<String> shuffleList = ListUtils.shuffle(strings);

        // then
        assertThat(strings).isNotEqualTo(shuffleList);
    }
}