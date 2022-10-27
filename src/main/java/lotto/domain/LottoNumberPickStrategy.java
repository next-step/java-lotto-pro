package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoNumberPickStrategy {

    List<Integer> pick();
}
