import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private List<Integer> numbers;
    private int matchCount = 0;

    public Lotto() {
        numbers = new ArrayList<Integer>();
        while (numbers.size() < LOTTO_NUMBER_COUNT) {
            getLottoNumber();
        }
    }

    public Lotto(String numbers) throws IllegalArgumentException{
        this(numbers, 0);
    }

    public Lotto(String numbers, int matchCount) {
        List<Integer> lotto = StringUtil.mapToInteger(numbers);
        if (lotto.size() < LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 숫자 " + LOTTO_NUMBER_COUNT + "개를 입력해야 합니다.");
        }
        this.numbers = lotto;
        this.matchCount = matchCount;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void getLottoNumber() {
        int number = LottoGame.getLottoNumber();

        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    public void match(Lotto winLotto) {
        List<Integer> winNumber = winLotto.getNumbers();
        for (int number : winNumber) {
            isContainNumber(number);
        }
    }

    public void isContainNumber(int number) {
        if (numbers.contains(number)) {
            matchCount++;
        }
    }

    public boolean isMatch(int matchCount) {
        if (this.matchCount == matchCount) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return matchCount == lotto.matchCount && Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, matchCount);
    }
}
