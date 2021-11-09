package lotto.model;

import java.util.*;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final String NUMBER_COUNT_MESSAGE = "숫자의 갯수는 6개입니다.";
    public static final String DUPLICATE_MESSAGE = "중복된 값을 입력하였습니다.";
    private final List<LottoNumber> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        validateSize(lotto);
        validateDuplicate(lotto);
        Collections.sort(lotto);
        for (Integer number : lotto) {
            this.lotto.add(new LottoNumber(number));
        }
    }

    private void validateSize(List<Integer> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NUMBER_COUNT_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> lotto) {
        Set<Integer> lottoSet = new HashSet<>(lotto);
        if (lottoSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    public boolean contains(LottoNumber number) {
        return lotto.contains(number);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    public int winningCount(Lotto winningLotto) {
        return (int) lotto.stream()
                .filter(winningLotto::contains).count();
    }
}
