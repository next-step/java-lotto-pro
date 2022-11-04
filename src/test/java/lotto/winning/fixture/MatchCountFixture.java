package lotto.winning.fixture;

import lotto.winning.domain.MatchingCount;

import static lotto.lotto.domain.fixture.LottoFixture.lottos;
import static lotto.winning.fixture.WinningNumberFixture.당첨번호45691011;

public class MatchCountFixture {

    public static MatchingCount matchCount() {
        return new MatchingCount(lottos(), 당첨번호45691011());
    }
}
