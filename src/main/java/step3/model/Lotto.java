package step3.model;

import java.util.*;

import static step3.constant.ErrorMessage.TOTAL_6_COUNT_LOTTO_INPUT;

public class Lotto {

    private List<LottoNumber> numbers;

    public Lotto() {
        List<LottoNumber> allNumbers = settingLottoRangeNumber();
        Collections.shuffle(allNumbers);

        this.numbers = allNumbers.subList(0, 6);
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
        if (result.size() != 6) {
            throw new IllegalArgumentException(TOTAL_6_COUNT_LOTTO_INPUT);
        }
        return result;
    }

    private List<LottoNumber> settingLottoRangeNumber() {
        List<LottoNumber> allNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            allNumbers.add(new LottoNumber(i));
        }
        return allNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return numbers;
    }

    public int sameNumberCount(Lotto lotto) {
        int sameCount = 0;
        for (int i = 0; i < lotto.numbers.size(); i++) {
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
