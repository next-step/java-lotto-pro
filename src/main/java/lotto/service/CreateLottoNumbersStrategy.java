package lotto.service;

import java.util.List;

@FunctionalInterface
public interface CreateLottoNumbersStrategy {
    List<String> createLottoNumberStrings();
}
