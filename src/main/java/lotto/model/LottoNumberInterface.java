package lotto.model;

import java.util.List;

interface LottoNumberInterface {
    int MIN_NUMBER = 1;
    int MAX_NUMBER = 45;
    int NUMBER_SIZE = 6;

    List<Integer> getLottoNumber();
    void sortLottoNumber(List<Integer> lottoNumber);
}
