package lotto.model;

import static lotto.model.LottoMatcher.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.enums.Rank;

public class LottoMatcherTest {
    @Test
    @DisplayName("보너스 번호와 당첨번호가 겹칠 때 예외를 발생시킨다")
    void 객체_생성_시_유효성_검사() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LottoMatcher(6, 1, 2, 3, 4, 5, 6)
        ).withMessageContaining(DUPLICATE_BONUS_NUMBER_ERR_MSG);
    }

    @Test
    @DisplayName("생성자의 매개변수로 null이 전달될 때 예외를 발생시킨다")
    void createByNull() {
        assertThatNullPointerException().isThrownBy(() ->
            new LottoMatcher(null, new LottoNumbers(1, 2, 3, 4, 5, 6))
        );
        assertThatNullPointerException().isThrownBy(() ->
            new LottoMatcher(Number.of(1), null)
        );
    }

    @Test
    @DisplayName("구입한 로또번호들과 보너스번호, 당첨번호가 주어질 때 적절한 결과값이 반환되는지 테스트")
    void match() {
        List<LottoNumbers> lottoNumbers = Arrays.asList(
            new LottoNumbers(1, 2, 3, 7, 8, 9),
            new LottoNumbers(1, 2, 3, 4, 5, 11),
            new LottoNumbers(1, 2, 3, 4, 5, 6),
            new LottoNumbers(1, 2, 3, 4, 5, 7),
            new LottoNumbers(1, 2, 9, 10, 11, 12)
        );
        Number bonusNumber = Number.of(7);
        LottoNumbers winningNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        MatchResult matchResult = new LottoMatcher(bonusNumber, winningNumbers).match(new Payment(14000), lottoNumbers);

        assertThat(matchResult).isEqualTo(
            new MatchResult(new Payment(14000), Rank.FIFTH, Rank.THIRD, Rank.FIRST, Rank.SECOND, Rank.MISS));
    }

    @Test
    @DisplayName("match() 메서드의 매개변수로 null이 전달될 때 예외를 발생시킨다")
    void matchByNull() {
        List<LottoNumbers> lottoNumbers = Arrays.asList(
            new LottoNumbers(1, 2, 3, 7, 8, 9),
            new LottoNumbers(1, 2, 3, 4, 5, 11),
            new LottoNumbers(1, 2, 3, 4, 5, 6),
            new LottoNumbers(1, 2, 3, 4, 5, 7),
            new LottoNumbers(1, 2, 9, 10, 11, 12)
        );
        Number bonusNumber = Number.of(7);
        LottoNumbers winningNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        assertThatNullPointerException().isThrownBy(() ->
            new LottoMatcher(bonusNumber, winningNumbers).match(null, lottoNumbers)
        );
        assertThatNullPointerException().isThrownBy(() ->
            new LottoMatcher(bonusNumber, winningNumbers).match(new Payment(14000), null)
        );
    }
}
