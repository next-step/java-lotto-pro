package lotto;

import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static lotto.common.Constants.GET_NUMBER_COUNT;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("결과확인 기능 테스트")
public class CheckerTests {

    @DisplayName("결과확인을 테스트합니다.")
    @Test
    public void 결과확인() {
        int purchaseAmount = 3000;
        GameCount gameCount = new GameCount(purchaseAmount);
        Games games = new Games(gameCount.getValue());
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("10", winningNumbers);
        Checker checker = new Checker(games, winningNumbers, bonusNumber);

        assertAll(
                () -> assertThat(checker.getResults())
                        .isInstanceOf(LinkedHashMap.class)
                        .isNotEmpty(),
                () -> assertThat(checker.getResults().size()).isEqualTo(GET_NUMBER_COUNT)
        );
    }

}
