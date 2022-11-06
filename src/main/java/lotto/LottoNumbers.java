package lotto;

import lotto.common.LottoAutoUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.common.Constants.DELIMITER;
import static lotto.common.Constants.LOTTO_LENGTH;
import static lotto.common.Constants.LOTTO_MAX_NUM;
import static lotto.common.Constants.LOTTO_MIN_NUM;

// 일급콜렉션
public class LottoNumbers {
    private List<Integer> numbers;

    public LottoNumbers() {
        setUp();
    }

    public LottoNumbers(String inputStr) {
        setUp();
        stringToNumbersByToken(inputStr);
    }

    public LottoNumbers(List<Integer> inputNumList) {
        this.numbers = new ArrayList<>(inputNumList);
    }

    private void setUp() {
        numbers = new ArrayList<>();
    }

    private void stringToNumbersByToken(String inputStr) {
        if (inputStr == null) {
            throw new IllegalArgumentException("입력하신 내용이 없습니다.");
        }
        String[] str = inputStr.split(DELIMITER);
        if (str.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또의  길이는 " + LOTTO_LENGTH + " 입니다.");
        }
        for (String number : str) {
            this.numbers.add(new LottoAutoUtils().stringToNumber(number));
        }
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void add(int num) {
        if (num < LOTTO_MIN_NUM || num > LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("로또의 숫자 범위는 1~45입니다.");
        }
        numbers.add(num);
    }
}
