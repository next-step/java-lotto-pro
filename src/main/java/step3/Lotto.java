package step3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int PRICE = 1000;
    public static final int NUMBER_SIZE = 6;
    public static final int TICKET_MIN_VALUE = 1;
    public static final int TICKET_MAX_VALUE = 45;

    private static final String NUMBER_SIZE_MESSAGE = "번호는 6개만 허용합니다";
    private static final String DUPLICATE_NUMBER_MESSAGE = "중복없는 번호만 허용합니다";
    private static final String OUT_OF_RANGE_MESSAGE = "1에서 45사이 번호만 허용합니다";


    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers){
        validateNumbers(numbers);
        this.numbers = numbers;

    }
    public int getPrice(){
        return PRICE;
    }

    public List<Integer> getNumbers(){
        return numbers.stream().collect(Collectors.toList());
    }

    private void validateNumbers(List<Integer> numbers){
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if(distinctNumbers.size() != numbers.size())throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        if(distinctNumbers.size() != NUMBER_SIZE)throw new IllegalArgumentException(NUMBER_SIZE_MESSAGE);
        distinctNumbers.forEach(integer -> {
            if(integer < TICKET_MIN_VALUE || integer > TICKET_MAX_VALUE) throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        });
    }

    public Rank getRank(List<Integer> winningNumbers){
        int count = (int) numbers
                .stream()
                .filter(number -> winningNumbers.contains(number))
                .count();
        return Rank.getRankFromMatchCount(count);
    }

}
