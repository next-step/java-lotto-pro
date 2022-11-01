package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_LENGTH = 6;
    private static final String SPACE = " ";
    private static final String BLANK = "";
    private static final String PATTERN = "^[0-9,]*$";
    private static final String DELIMITER = ",";
    private static final String INVALID_LENGTH_MESSAGE = "로또 당첨 번호는 6자리여야 합니다.";
    private static final String INVALID_NUMBER_MESSAGE = "로또 당첨 번호는 1 이상 45 이하의 숫자여야 합니다.";
    private static final String INVALID_DELIMITER_MESSAGE = "로또 당첨 번호는 ,(콤마)로 구분되어야 합니다.";
    private List<Integer> lotto;

    public Lotto() {
        this.lotto = new AutoLottoGenerator().getShuffledNum();
    }

    public Lotto(String input) {
        String[] nums = validateInput(input);
        setWinLottoNum(nums);
    }

    private String[] validateInput(String input) {
        input = input.replace(SPACE, BLANK);
        if (!input.matches(PATTERN)) {
            throw new IllegalArgumentException(INVALID_DELIMITER_MESSAGE);
        }

        String[] nums = input.split(DELIMITER);
        if (nums.length < LOTTO_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }

        for (String num : nums) {
            validateNumber(num);
        }

        return nums;
    }

    private void validateNumber(String value) {
        int num = Integer.parseInt(value);
        if (num < MIN_LOTTO_NUM || num > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    private void setWinLottoNum(String[] nums) {
        lotto = new ArrayList<>();
        Arrays.stream(nums).forEach(num -> lotto.add(Integer.parseInt(num)));
    }

    public List<Integer> getLotto() {
        return this.lotto;
    }

    public boolean isContained(int number) {
        return lotto.contains(number);
    }

    public int countMatchNum(Lotto winLotto) {
        return (int) lotto.stream().filter(winLotto::isContained).count();
    }

}
