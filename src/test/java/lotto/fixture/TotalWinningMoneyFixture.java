package lotto.fixture;

import lotto.domain.MatchingCount;
import lotto.domain.TotalWinningMoney;

import static lotto.fixture.LottoFixture.로또123456;
import static lotto.fixture.WinningNumberFixture.당첨번호45691011;

public class TotalWinningMoneyFixture {
    public static TotalWinningMoney 당첨금액_5000() {
        return new TotalWinningMoney(new MatchingCount(로또123456(), 당첨번호45691011()));
    }
}
