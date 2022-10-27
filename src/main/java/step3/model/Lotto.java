package step3.model;

import java.util.*;

import static step3.constant.ErrorMessage.TOTAL_6_COUNT_LOTTO_INPUT;

public class Lotto {

    private final static int ZERO = 0;
    private final static int LOTTO_SIZE = 6;
    private final static int LOTTO_START = 1;
    private final static int LOTTO_END = 45;

    private List<LottoNumber> numbers;

    public Lotto() {
        List<LottoNumber> allNumbers = settingLottoRangeNumber();
        Collections.shuffle(allNumbers);

        this.numbers = allNumbers.subList(ZERO, LOTTO_SIZE);
        Collections.sort(this.numbers);
    }

    public Lotto(String inputNumber) {
        numbers = new ArrayList<>();

        List<String> numberArray = convertNumberArray(inputNumber);
        for (String number : numberArray) {
            numbers.add(new LottoNumber(number));
        }
        Collections.sort(this.numbers);
    }

    private List<String> convertNumberArray(String inputNumber) {
        inputNumber = inputNumber.replace(" ", "");
        List<String> result = Arrays.asList(inputNumber.split(","));
        if (result.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(TOTAL_6_COUNT_LOTTO_INPUT);
        }
        return result;
    }

    private List<LottoNumber> settingLottoRangeNumber() {
        List<LottoNumber> allNumbers = new ArrayList<>();
        for (int i = LOTTO_START; i <= LOTTO_END; i++) {
            allNumbers.add(new LottoNumber(i));
        }
        return allNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return numbers;
    }

    public int sameNumberCount(Lotto lotto) {
        int sameCount = ZERO;
        for (int i = ZERO; i < lotto.numbers.size(); i++) {
            sameCount += containNumber(lotto.numbers.get(i));
        }
        return sameCount;
    }

    private int containNumber(LottoNumber number) {
        if (this.numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "" + numbers;
    }

}
