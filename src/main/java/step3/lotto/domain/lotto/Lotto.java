package step3.lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : choi-ys
 * @date : 2022/05/15 5:24 오후
 */
public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final String INVALID_LOTTO_NUMBER_COUNT_ERROR = "6개의 로또 번호를 입력하세요.";
    public static final String LOTTO_NUMBER_DUPLICATED_ERROR = "로또 번호는 중복될 수 없습니다.";

    private List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<Integer> numbers) {
        validateLottoNumberCount(numbers.size());
        validateLottoNumberDuplication(new HashSet<>(numbers).size());
        Collections.sort(numbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }
        return new Lotto(lottoNumbers);
    }

    public int size() {
        return lottoNumbers.size();
    }

    public MatchResult match(Winnings winnings) {
        return MatchResult.valueOf(matchCount(winnings.getWinningsLotto()), contains(winnings.getBonusNumber()));
    }

    public int matchCount(Lotto winningsLotto) {
        int matchCount = 0;
        for (LottoNumber answerLottoNumber : winningsLotto.lottoNumbers) {
            matchCount = contains(answerLottoNumber) ? matchCount + 1 : matchCount;
        }
        return matchCount;
    }

    public boolean contains(LottoNumber answerLottoNumber) {
        Set<Boolean> compareEqualsSet = new HashSet();
        for (LottoNumber lottoNumber : lottoNumbers) {
            compareEqualsSet.add(lottoNumber.equals(answerLottoNumber));
        }
        return compareEqualsSet.contains(true);
    }

    private static void validateLottoNumberCount(int size) {
        if (isInValidLottoCount(size)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    private static void validateLottoNumberDuplication(int size) {
        if (isInValidLottoCount(size)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_ERROR);
        }
    }

    private static boolean isInValidLottoCount(int size) {
        return size != LOTTO_NUMBER_COUNT;
    }

    @Override
    public String toString() {
        return "" + lottoNumbers;
    }
}


