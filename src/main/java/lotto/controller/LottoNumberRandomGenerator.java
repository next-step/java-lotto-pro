package lotto.controller;

import lotto.model.LottoNumber;
import lotto.util.GameRule;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberRandomGenerator {

    List<LottoNumber> lottoNumberList;

    public List<LottoNumber> getLottoNumberList() {
        lottoNumberList = IntStream.rangeClosed(GameRule.LOTTO_START_NUMBER, GameRule.LOTTO_END_NUMBER).mapToObj(LottoNumber::new).collect(Collectors.toList());
        Collections.shuffle(lottoNumberList);
        List<LottoNumber> randomLottoNumberList = lottoNumberList.subList(GameRule.LOTTO_START_INDEX, GameRule.LOTTO_END_INDEX);
        Collections.sort(randomLottoNumberList);
        return randomLottoNumberList;
    }
}
