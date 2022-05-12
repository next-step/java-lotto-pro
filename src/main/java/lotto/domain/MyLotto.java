package lotto.domain;

import java.util.Collections;
import java.util.List;

public class MyLotto {
    private List<Lotto> lottoList;

    public MyLotto(final List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (Lotto lotto : lottoList) {
            sb.append(lotto.toString() + "\r\n");
        }
        return sb.toString();
    }
}
