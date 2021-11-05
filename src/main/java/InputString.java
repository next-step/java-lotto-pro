import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputString {
    public static final String DELIMITER = ",|:";
    private String str;
    private int[] numbers;

    public InputString(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public boolean isNullOrEmpty(){
        return StringUtil.isNullOrEmpty(this.str);
    }

    public boolean isOneNumber(){
        return StringUtil.isOneNumber(this.str);
    }

    public boolean isValidNumber(){
        if(Arrays.stream(numbers).anyMatch(i -> i < 0)) {
            throw new RuntimeException("[ERROR] 양의 정수를 입력하세요.");
        }
        return true;
    }

    public int[] splitToNumberArray(){
        return toNumberArray(splitString());
    }

    private Matcher hasCustomDelimiter(){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(this.str);
        if(m.find()) {
            return m;
        }
        return null;
    }

    private String[] splitString(){
        Matcher m = hasCustomDelimiter();
        if(Objects.isNull(m)){
            return StringUtil.splitString(this.str, DELIMITER);
        }

        String customDelimiter = m.group(1);
        return StringUtil.splitString(m.group(2), customDelimiter);
    }

    private int[] toNumberArray(String[] stringNumberArray){
        int[] numberArray = new int[stringNumberArray.length];
        for(int i = 0; i < stringNumberArray.length; i++){
            numberArray[i] = Integer.parseInt(stringNumberArray[i]);
        }
        return numberArray;
    }

    public int sumNumbers(){
        return Arrays.stream(numbers).sum();
    }
}
