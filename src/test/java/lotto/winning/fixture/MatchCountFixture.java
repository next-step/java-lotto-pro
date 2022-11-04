package lotto.winning.fixture;

import lotto.winning.domain.MatchCount;

import static lotto.lotto.domain.fixture.LottoFixture.lottos;
import static lotto.winning.fixture.WinningNumberFixture.당첨번호45691011;

public class MatchCountFixture {

    public static MatchCount matchCount() {
        return new MatchCount(lottos(), 당첨번호45691011());
    }
}
