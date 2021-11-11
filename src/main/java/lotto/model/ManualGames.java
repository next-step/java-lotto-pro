package lotto.model;

import java.util.List;

public class ManualGames {

    private List<LottoNumbers> list;

    public ManualGames(final List<LottoNumbers> list) {
        this.list = list;
    }

    public List<LottoNumbers> getList() {
        return list;
    }

}
