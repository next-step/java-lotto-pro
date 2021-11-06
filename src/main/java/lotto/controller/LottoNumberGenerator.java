package lotto.controller;

import lotto.model.LottoNumber;
import lotto.model.LottoPaper;
import lotto.util.GameRule;
import lotto.view.GameMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(GameRule.LOTTO_START_NUMBER, GameRule.LOTTO_END_NUMBER)
                .boxed()
                .distinct()
                .forEach(lottoNumber -> lottoNumbers.add(new LottoNumber(lottoNumber)));
    }

    public static LottoPaper getLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> randomLottoNumbers = lottoNumbers.subList(GameRule.LOTTO_START_INDEX, GameRule.LOTTO_END_INDEX);
        Collections.sort(randomLottoNumbers);
        return new LottoPaper(randomLottoNumbers);
    }

    public LottoPaper createWinningNumber(String input) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        Arrays.asList(input.split(GameRule.LOTTO_NUMBER_DELIMITER))
                .forEach(number -> lottoNumbers.add(new LottoNumber(parseLottoNumber(number))) );

        return new LottoPaper(lottoNumbers);
    }

    private int parseLottoNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GameMessage.invalidInputMsg(GameMessage.ERROR_WINNING_NUMBER_INPUT));
        }
    }


}
