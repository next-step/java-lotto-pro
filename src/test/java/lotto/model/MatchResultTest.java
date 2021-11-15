package lotto.model;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.enums.Rank;

public class MatchResultTest {
    @Test
    @DisplayName("생성자의 매개변수로 null이 전달될 때 예외를 발생시킨다")
    void createByNull() {
        assertThatNullPointerException().isThrownBy(() ->
            new MatchResult(null, singletonList(Rank.FIRST))
        );
        assertThatNullPointerException().isThrownBy(() ->
            new MatchResult(new Payment(14000), (List<Rank>)null)
        );
    }

    @Test
    @DisplayName("countRank가 적절한 값을 반환하는지 테스트")
    void countRank() {
        MatchResult matchResult = new MatchResult(new Payment(10000), Rank.FIFTH, Rank.FIFTH, Rank.SECOND);
        int actual = matchResult.countRank(Rank.FIFTH);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("countRank 함수에 매개변수로 null이 전달될 때 예외 발생")
    void countRankByNull() {
        MatchResult matchResult = new MatchResult(new Payment(10000), Rank.FIFTH);
        assertThatNullPointerException().isThrownBy(() -> matchResult.countRank(null));
    }

    @Test
    @DisplayName("동등성 검사. 이 때 등수의 순서는 상관이 없고 각 등수의 갯수가 중요하다.")
    void equals() {
        MatchResult expected = new MatchResult(new Payment(10000), Rank.FIFTH, Rank.SECOND);
        MatchResult actual = new MatchResult(new Payment(10000), Rank.SECOND, Rank.FIFTH);
        assertThat(actual).isEqualTo(expected);
    }
}
