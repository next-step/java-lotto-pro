import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> numbers;
    private int matchCount = 0;
    private LottoNumber bonusNumber;
    private LottoReward reward;
    private boolean buyManual = false;


    public Lotto() {
        numbers = new ArrayList<LottoNumber>();
        while (numbers.size() < LOTTO_NUMBER_COUNT) {
            getLottoNumber();
        }
        this.buyManual = false;
    }

    public Lotto(String numbers) throws IllegalArgumentException {
        this(numbers, 0);
    }

    public Lotto(String numbers, int matchCount) throws IllegalArgumentException {
        List<LottoNumber> lotto = StringUtil.mapToLotto(numbers);
        if (lotto.size() < LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 숫자 " + LOTTO_NUMBER_COUNT + "개를 입력해야 합니다.");
        }
        this.numbers = lotto;
        this.matchCount = matchCount;
        this.buyManual = true;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean isBuyManual() {
        return buyManual;
    }

    public void getLottoNumber() {
        LottoNumber number = new LottoNumber();

        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    public void match(Lotto winLotto) {
        List<LottoNumber> winNumber = winLotto.getNumbers();
        for (LottoNumber number : winNumber) {
            isContainNumber(number);
        }
        boolean isContainsBonusNumber = isContainsNumber(winLotto.getBonusNumber());
        reward = LottoReward.valueOf(matchCount, isContainsBonusNumber);
    }

    public void isContainNumber(LottoNumber number) {
        if (numbers.contains(number)) {
            matchCount++;
        }
    }

    public boolean isContainsNumber(LottoNumber number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    public boolean isMatch(LottoReward reward) {
        if (this.reward.equals(reward)) {
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
