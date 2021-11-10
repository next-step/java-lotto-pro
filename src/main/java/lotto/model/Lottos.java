package lotto.model;

import lotto.view.ErrorMessage;

import java.util.*;

public class Lottos {

    private final List<Lotto> lottoGroup;

    public Lottos(List<Lotto> lottoGroup) {
        valid(lottoGroup);
        this.lottoGroup = lottoGroup;
    }

    private void valid(List<Lotto> lottoGroup) {
        if(lottoGroup == null || lottoGroup.isEmpty()){
            throw new NullPointerException(ErrorMessage.LOTTO_NULL);
        }
    }

    public int size() {
        return lottoGroup.size();
    }

    public List<Lotto> getLottoGroup() {
        return Collections.unmodifiableList(lottoGroup);
    }

}
