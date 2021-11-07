import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private List<Integer> numbers;

    public Lotto(){
        numbers = new ArrayList<Integer>();
        while(numbers.size() < LOTTO_NUMBER_COUNT) {
            issueLotto();
        }
    }

    public Lotto(String numbers) throws RuntimeException{
        List<Integer> lotto = StringUtil.mapToInteger(numbers);
        if(lotto.size() < LOTTO_NUMBER_COUNT){
            throw new RuntimeException("[ERROR] 숫자 " + LOTTO_NUMBER_COUNT + "개를 입력해야 합니다.");
        }
        this.numbers = lotto;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void issueLotto(){
        int number = LottoMain.getLottoNumber();

        if( ! numbers.contains(number)){
            numbers.add(number);
        }
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }

}
