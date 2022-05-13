package study.lotto.domain.sorter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntegerAscendingSorterTest {
    @Test
    @DisplayName("정수형 리스트를 정렬한다.")
    void 정수_오름차순_정렬() {
        List<Integer> integerList = Arrays.asList(2, 1, 5, 4, 3, 6);
        new IntegerAscendingSorter().sort(integerList);
        assertThat(integerList).containsExactlyElementsOf(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
