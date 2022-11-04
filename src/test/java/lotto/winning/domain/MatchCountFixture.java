package lotto.winning.domain;

import static lotto.lotto.domain.LottoFixture.lottos;
import static lotto.winning.domain.WinningNumberFixture.당첨번호45691011;

public class MatchCountFixture {

    public static MatchCount matchCount() {
        return new MatchCount(lottos(), 당첨번호45691011());
    }
}
