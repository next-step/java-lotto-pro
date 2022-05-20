package step3.lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author : choi-ys
 * @date : 2022/05/15 5:24 오후
 */
public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final String INVALID_LOTTO_NUMBER_ERROR = "중복 없는 6개의 로또 번호를 입력하세요.";

    private Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<Integer> numbers) {
        HashSet<Integer> integers = new HashSet<>(numbers);
        validateLottoNumber(integers.size());

        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }
        return new Lotto(lottoNumbers);
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

    public boolean contains(LottoNumber winningsLottoNumber) {
        return lottoNumbers.contains(winningsLottoNumber);
    }

    private static void validateLottoNumber(int size) {
        if (isInValidLottoCount(size)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_ERROR);
        }
    }

    private static boolean isInValidLottoCount(int size) {
        return size != LOTTO_NUMBER_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "" + lottoNumbers;
    }
}
