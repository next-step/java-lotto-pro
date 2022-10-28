package lotto.domain;

import lotto.domain.dto.StatisticDto;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticDtoTest {
    @DisplayName("통계 초기값은 0이다")
    @Test
    void default_count_test() {
        assertThat(StatisticDto.create().getCount(3)).isEqualTo(0);
    }

    @DisplayName("당첨번호와 일치하는 개수가 최소 랭크 보다 클 경우 1 증가한다")
    @Test
    void increase_test() {
        int count = Rank.FOURTH.getMatchCount();
        StatisticDto dto = StatisticDto.create();

        dto.add(count);

        assertThat(dto.getCount(count)).isEqualTo(1);
    }
}
