package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroups {
    private final List<Lotto> lottoGroups;

    public LottoGroups(int count) {
        this.lottoGroups = generateLottoGroups(count);
    }

    private List<Lotto> generateLottoGroups(int count) {
        List<Lotto> lottoGroups = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoGroups.add(new Lotto());
        }
        return lottoGroups;
    }

    public int size() {
        return lottoGroups.size();
    }

    public List<Rank> matchResults(Lotto winLotto) {
        List<Rank> matchResult = new ArrayList<>();
        for (Lotto lotto : lottoGroups) {
            matchResult.add(lotto.match(winLotto));
        }
        return matchResult;
    }

    public void printLottoGroups() {
        for (Lotto lotto : lottoGroups) {
            System.out.println(lotto.toString());
        }
    }
}
