package lotto.domain;

import java.util.*;

import static lotto.domain.Number.MAX_NUMBER;
import static lotto.domain.Number.MIN_NUMBER;
import static lotto.utils.RandomNumberUtils.generateRandomNumbers;

public class LottoNumber {

    public static final int LOTTO_SIZE = 6;
    public final static int GAME_PRICE = 1000;

    private final List<Number> lottoNumbers;

    public LottoNumber() {
        List<Number> autoLottoNumbers = getAutoLottoNumbers();
        validateLottoNumbersSize(autoLottoNumbers);
        lottoNumbers = sortAsc(autoLottoNumbers);
    }

    public LottoNumber(List<Number> activeNumbers) {
        validateLottoNumbersSize(activeNumbers);
        lottoNumbers = sortAsc(activeNumbers);
    }

    public Rank getMatchRank(WinningLotto winningLotto) {
        int matchCount = 0;
        boolean matchBonus = winningLotto.isExistBonusNumber(lottoNumbers);
        for (Number number : lottoNumbers) {
            matchCount += winningLotto.isMatchNumber(number) ? 1 : 0;
        }
        return Rank.of(matchCount, matchBonus);
    }

    private List<Number> getAutoLottoNumbers() {
        Set<Number> numbers = new HashSet<>();
        while (numbers.size() < LOTTO_SIZE) {
            numbers.add(new Number(getRandomNumber()));
        }
        return new ArrayList<>(numbers);
    }

    private int getRandomNumber() {
        return generateRandomNumbers(MIN_NUMBER, MAX_NUMBER);
    }

    private void validateLottoNumbersSize(List<Number> activeNumbers) {
        if (activeNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 숫자 입력 필수 자리수 : " + LOTTO_SIZE);
        }
    }

    private List<Number> sortAsc(List<Number> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Number> getLottoNumbers() {
        return lottoNumbers;
    }
}
