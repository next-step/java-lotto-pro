package lotto.domain;

import java.util.*;

import static stringAddCalculator.utils.Parse.INPUT_ERROR;

public class Lotto {
    private final List<Integer> lottoNumber;

    public Lotto(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
        Collections.shuffle(numbers);
        for (int i=0; i<6; i++) {
            list.add(numbers.get(i));
        }
        Collections.sort(list);
        this.lottoNumber = list;
    }

    public Lotto(String input) {
        String[] inputArr = input.replace(" ", "").split(",");
        vaildCount(inputArr);
        List<Integer> list = new ArrayList<>();
        for (String s : inputArr) {
            list.add(validNumber(s));
        }
        Collections.sort(list);
        this.lottoNumber = list;
    }

    public List<Integer> getLottoNumber() {
        return this.lottoNumber;
    }

    public void printLottoNumber() {
        System.out.println(lottoNumber.toString());
    }

    private void vaildCount(String[] input) {
        Set<String> set = new HashSet<>();
        for (String s : input) {
            set.add(s);
        }
        if (set.size() != 6) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
    }

    private int validNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            validRangeLottoNumber(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
    }

    private void validRangeLottoNumber(int num) {
        if (num < 1) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }

        if (num > 45) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
    }
}
