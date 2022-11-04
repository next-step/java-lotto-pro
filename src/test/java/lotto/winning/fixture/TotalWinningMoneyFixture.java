package lotto.winning.fixture;

import lotto.winning.domain.MatchingCount;
import lotto.winning.domain.TotalWinningMoney;

import static lotto.lotto.domain.fixture.LottoFixture.로또123456;
import static lotto.winning.fixture.WinningNumberFixture.당첨번호45691011;

public class TotalWinningMoneyFixture {
    public static TotalWinningMoney 당첨금액_5000() {
        return new TotalWinningMoney(new MatchingCount(로또123456(), 당첨번호45691011()));
    }
}
