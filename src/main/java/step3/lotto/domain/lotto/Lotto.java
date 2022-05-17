package step3.lotto.domain.lotto;

import java.util.ArrayList;
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

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<Integer> numbers) {
        validateLottoNumberCount(numbers.size());
        validateLottoNumberDuplication(new HashSet<>(numbers).size());
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }
        return new Lotto(lottoNumbers);
    }

    public int size() {
        return lottoNumbers.size();
    }

    public MatchResult match(Lotto winningLotto) {
        return matchResult(matchCount(winningLotto));
    }

    private MatchResult matchResult(int matchCount) {
        if (matchCount == 3) {
            return MatchResult.FORTH_PLACE;
        }
        if (matchCount == 4) {
            return MatchResult.THIRD_PLACE;
        }
        if (matchCount == 5) {
            return MatchResult.SECOND_PLACE;
        }
        if (matchCount == 6) {
            return MatchResult.FIRST_PLACE;
        }
        return MatchResult.NOTHING;
    }

    public int matchCount(Lotto answer) {
        int matchCount = 0;
        for (LottoNumber answerLottoNumber : answer.lottoNumbers) {
            matchCount = contains(answerLottoNumber) ? matchCount + 1 : matchCount;
        }
        return matchCount;
    }

    private boolean contains(LottoNumber answerLottoNumber) {
        Set<Boolean> compareEqualsSet = new HashSet();
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            compareEqualsSet.add(lottoNumber.equals(answerLottoNumber));
        }
        return compareEqualsSet.contains(true);
    }

    private static void validateLottoNumberCount(int size) {
        if (!isValidLottoCount(size)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    private static void validateLottoNumberDuplication(int size) {
        if (!isValidLottoCount(size)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_ERROR);
        }
    }

    private static boolean isValidLottoCount(int size) {
        return size == LOTTO_NUMBER_COUNT;
    }
}


