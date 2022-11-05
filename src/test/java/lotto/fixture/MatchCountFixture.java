package lotto.fixture;

import lotto.domain.MatchingCount;

import static lotto.fixture.LottoFixture.lottos;
import static lotto.fixture.WinningNumberFixture.당첨번호45691011;

public class MatchCountFixture {

    public static MatchingCount matchCount() {
        return new MatchingCount(lottos(), 당첨번호45691011());
    }
}
