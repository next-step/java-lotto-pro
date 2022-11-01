package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        // TODO: 예외 처리 로직 분
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자만 설정 가능합니다.");
        }
        if(new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호가 중복됩니다.");
        }
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    public boolean hasBonusBall(LottoNumber bonusBall) {
        return numbers.contains(bonusBall);
    }

    public int getCorrectCount(Lotto lotto) {
        return (int) this.numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
