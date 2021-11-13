package lotto.service;

import java.util.List;

@FunctionalInterface
public interface CreateLottoStrategy {
    List<String> createLottoNumberStrings();
}
