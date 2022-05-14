package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListUtilsTest {

    @Test
    @DisplayName("리스트를 복사하여 섞기")
    void shuffle() {
        // given
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");

        // when
        final List<String> shuffleList = ListUtils.shuffle(strings);

        // then
        assertThat(shuffleList).contains("1", "2");
    }

    @Test
    @DisplayName("리스트를 복사하여 갯수 만큼 뽑기")
    void pickCount() {
        // given
        final List<Integer> integerList = IntStream.range(1, 10)
                .boxed()
                .collect(Collectors.toList());

        // when
        final List<Integer> pickList = ListUtils.pickCount(integerList, 3);

        // then
        assertThat(pickList).hasSize(3);
        assertThat(pickList).contains(1, 2, 3);
    }

    @Test
    @DisplayName("리스트를 복사하여 갯수 만큼 랜덤으로 뽑기")
    void pickRandomCount() {
        // given
        final List<Integer> integerList = IntStream.range(1, 10)
                .boxed()
                .collect(Collectors.toList());

        // when
        final List<Integer> randomPickList = ListUtils.randomPickCount(integerList, 3);

        // then
        assertThat(randomPickList).hasSize(3);
    }

    @Test
    @DisplayName("리스트를 복사하여 역정렬하기")
    void sort() {
        // given
        final List<Integer> integerList = IntStream.range(1, 4)
                .boxed()
                .collect(Collectors.toList());

        // when
        final List<Integer> randomPickList = ListUtils.sort(integerList, (o1, o2) -> o2 - o1);

        // then
        assertThat(randomPickList).containsExactly(3, 2, 1);
    }

    @Test
    @DisplayName("리스트를 복사하여 중복제거 하기")
    void distinct() {
        // given
        final List<Integer> integerList = IntStream.of(1, 1, 1, 2, 2, 3)
                .boxed()
                .collect(Collectors.toList());

        // when
        final List<Integer> distinctList = ListUtils.distinct(integerList);

        // then
        assertThat(distinctList).hasSize(3);
        assertThat(distinctList).contains(1, 2, 3);
    }
}