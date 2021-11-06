package lotto;

import java.util.*;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        if (validateSize(lotto)) {
            throw new IllegalArgumentException("숫자의 갯수는 6개입니다.");
        }
        if (validateDuplicate(lotto)) {
            throw new IllegalArgumentException("중복된 값을 입력하였습니다.");
        }
        for (Integer number : lotto) {
            this.lotto.add(new LottoNumber(number));
        }
    }

    private boolean validateSize(List<Integer> lotto) {
        if(lotto.size() != LOTTO_SIZE) {
            return  true;
        }
        return false;
    }

    private boolean validateDuplicate(List<Integer> lotto) {
        Set<Integer> lottoSet = new HashSet<>(lotto);
        if (lottoSet.size() != LOTTO_SIZE) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
