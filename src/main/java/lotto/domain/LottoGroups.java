package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroups {
    private final List<Lotto> lottoGroups;

    public LottoGroups() {
        this.lottoGroups = new ArrayList<>();
    }

    public void generateLottoGroupsByPolicy(GeneratePolicy generatePolicy, LottoCount lottoCount) {
        generatePolicy.generate(this.lottoGroups, lottoCount);
    }

    public int size() {
        return lottoGroups.size();
    }

    public List<Rank> matchResults(WinningLotto winLotto) {
        List<Rank> matchResult = new ArrayList<>();
        for (Lotto lotto : lottoGroups) {
            matchResult.add(winLotto.match(lotto));
        }
        return matchResult;
    }

    public void printLottoGroups() {
        for (Lotto lotto : lottoGroups) {
            System.out.println(lotto.toString());
        }
    }
}
