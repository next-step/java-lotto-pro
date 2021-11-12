package lotto.model;

import java.util.List;

public class ManualNumbers {

    private List<LottoNumbers> list;

    public ManualNumbers(final List<LottoNumbers> list) {
        this.list = list;
    }

    public List<LottoNumbers> getList() {
        return list;
    }

    public int size() {
        return list.size();
    }

}
