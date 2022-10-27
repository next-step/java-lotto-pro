package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface NumberPickStrategy {

    List<Integer> pick();
}
