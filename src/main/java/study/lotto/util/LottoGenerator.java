package study.lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import study.lotto.Lotto;
import study.lotto.LottoNumber;
import study.lotto.io.ConsoleInput;

public class LottoGenerator {
    private static final String NUMBER_DELIMITER = ",";
    private static final int LOTTO_NUMBER_SIZE = 6;

    private LottoGenerator() {
    }

    public static List<Lotto> generate(int gentAutoSize) {
        validate(gentAutoSize);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < gentAutoSize; i++) {
            lottos.add(new Lotto(getRandomLottoNumbers(), true));
        }
        return lottos;
    }

    public static List<Lotto> generateManual(int genManualSize) {
        validate(genManualSize);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < genManualSize; i++) {
            lottos.add(newManualLotto());
        }
        return lottos;
    }

    public static Lotto newManualLotto() {
        String inputString = ConsoleInput.read();
        return new Lotto(LottoGenerator.splitAndParseLottoNumber(
                inputString,
                NUMBER_DELIMITER
        ));
    }

    public static List<LottoNumber> splitAndParseLottoNumber(String text, String delimiter) {
        return Arrays.stream(text.split(delimiter))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static void validate(int genSize) {
        if (genSize < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private static List<LottoNumber> getRandomLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        do {
            addNotExists(lottoNumbers, new LottoNumber());
        } while (lottoNumbers.size() < LottoGenerator.LOTTO_NUMBER_SIZE);
        return lottoNumbers;
    }

    private static void addNotExists(List<LottoNumber> lottoNumbers, LottoNumber lottoNumber) {
        if (!lottoNumbers.contains(lottoNumber)) {
            lottoNumbers.add(lottoNumber);
        }
    }
}
