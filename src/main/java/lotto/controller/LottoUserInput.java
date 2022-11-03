package lotto.controller;

import java.util.List;

public interface LottoUserInput {
    String getInput();

    Integer getPositiveInteger();

    List<Integer> getLottoNumbers();
}
