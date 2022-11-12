package step5.service;

import step5.constant.StringConstant;
import step5.model.Lotto;
import step5.model.LottoNo;
import step5.model.LottoWinningNos;
import step5.model.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final int LOTTO_START_INDEX = 0;
    private static final int LOTTO_END_INDEX = 6;
    private static List<Integer> numbers;

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    static {
        numbers = new ArrayList<>();
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            numbers.add(number);
        }
    }

    /**
     * 자동, 수동 구매한 로또 생성
     *
     * @param needLottoCount 자동 로또 구매 수
     * @param manualLottos   수동 로또
     * @return 로또 리스트 출력
     */
    public Lottos generateByTimesAndManualLotto(int needLottoCount, List<Lotto> manualLottos) {
        Lottos lottos = new Lottos(manualLottos);
        for (int index = 0; index < needLottoCount; index++) {
            lottos.add(generate());
        }

        return lottos;
    }

    private Lotto generate() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(LOTTO_START_INDEX, LOTTO_END_INDEX).stream()
                .map(LottoNo::new)
                .collect(Collectors.toList()));
    }

    public List<LottoNo> generateLottoNos(String lottoNumberText) {
        return Stream.of(lottoNumberText.split(StringConstant.COMMA))
                .map(this::convertInteger)
                .map(LottoNo::new)
                .collect(Collectors.toList());
    }

    public LottoWinningNos generateLottoWinningNos(Lotto lotto, int bonus) {
        return new LottoWinningNos(lotto, new LottoNo(bonus));
    }

    private Integer convertInteger(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자를 기입해주세요.");
        }
    }
}
