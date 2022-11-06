package step3.service;

import step3.constant.StringConstant;
import step3.model.Lotto;
import step3.model.LottoBonus;
import step3.model.Lottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int LOTTO_START_INDEX = 0;
    private static final int LOTTO_END_INDEX = 6;
    private static List<Integer> numbers;

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    static {
        numbers = new ArrayList<>();
        for (int number = LOTTO_START_NUMBER ; number <= LOTTO_END_NUMBER ; number++) {
            numbers.add(number);
        }
    }

    public Lottos generateByTimes(int needLottoCount) {
        Lottos lottos = new Lottos();
        for (int index = 0; index < needLottoCount; index++) {
            lottos.add(generate());
        }

        return lottos;
    }

    private Lotto generate() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(LOTTO_START_INDEX, LOTTO_END_INDEX));
    }

    public Lotto generate(String lottoNumberText) {
        return new Lotto(Arrays.stream(lottoNumberText.split(StringConstant.COMMA))
                .map(this::convertInteger)
                .collect(Collectors.toList()));
    }

    public LottoBonus generate(String lottoNumberText, int bonus) {
        return new LottoBonus(Arrays.stream(lottoNumberText.split(StringConstant.COMMA))
                .map(this::convertInteger)
                .collect(Collectors.toList()), bonus);
    }

    private Integer convertInteger(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자를 기입해주세요.");
        }
    }
}
