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
}
