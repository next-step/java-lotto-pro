package lotto.domain;

import lotto.exception.LottoNumberSizeException;

import java.math.BigDecimal;
import java.util.*;

import static lotto.domain.Number.MAX_NUMBER;
import static lotto.domain.Number.MIN_NUMBER;
import static lotto.utils.RandomNumberUtils.generateRandomNumbers;
import static lotto.utils.ValidationUtils.*;

public class LottoNumber {

    public static final int LOTTO_SIZE = 6;
    public final static BigDecimal GAME_PRICE = BigDecimal.valueOf(1000);

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
            numbers.add(Number.of(getRandomNumber()));
        }
        return new ArrayList<>(numbers);
    }

    private int getRandomNumber() {
        return generateRandomNumbers(MIN_NUMBER, MAX_NUMBER);
    }

    private void validateLottoNumbersSize(List<Number> activeNumbers) {
        if (isArrayEmpty(activeNumbers)) {
            throw new LottoNumberSizeException("[ERROR] 로또의 값이 없습니다.");
        }
        if (isArrayLengthOver(activeNumbers, LOTTO_SIZE)) {
            throw new LottoNumberSizeException("[ERROR] 로또의 사이즈 보다 큽니다.");
        }
        if (isArrayLengthUnder(activeNumbers, LOTTO_SIZE)) {
            throw new LottoNumberSizeException("[ERROR] 로또의 사이즈 보다 작습니다.");
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
