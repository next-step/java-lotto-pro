package lottoauto.wrapper;

import lottoauto.util.RandomNumberExtractor;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;
    private static final String DEFAULT_REGEX = ", ";

    public Lotto(List<Integer> numbers) {
        if(numbers.isEmpty()) {
            throw new NullPointerException("null일 수 없습니다.");
        }

        if(numbers.size() != 6) {
            throw new ArrayIndexOutOfBoundsException("6개의 숫자가 필요합니다.");
        }

        for(int i = 0 ; i < numbers.size() ; i++) {
            if(numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw  new NumberFormatException("1~45만 입력 가능합니다.");
            }
        }

        this.numbers = numbers;
    }

    public Lotto() {
        RandomNumberExtractor randomNumberExtractor = new RandomNumberExtractor();
        this.numbers = randomNumberExtractor.getRandomNumbers();
    }

    public Lotto(String input) {

    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int compareLotto(List<Integer> winners, List<Integer> numbers) {
        return 0;
    }


}
