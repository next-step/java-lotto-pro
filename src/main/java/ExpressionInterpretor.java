import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionInterpretor {
    private static final String DEFAULT_DELIMITER = ",|:";

    private String expression;

    private String[] numbers;

    public ExpressionInterpretor(String expression) {
        this.expression = expression;
        interpret();
    }

    private void interpret() {
        if (hasCustomDelimitPart()) {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
            m.find();
            String customDelimiter = m.group(1);
            numbers = m.group(2).split(customDelimiter);
            return;
        }
        numbers = expression.split(DEFAULT_DELIMITER);
        return;
    }

    private boolean hasCustomDelimitPart() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        return m.find();
    }

    public List<Integer> getNumbers () {
        List<Integer> numberList = new ArrayList<>();
        for(String numberString : numbers){
            int number = Integer.parseInt(numberString);
            checkNagative(number);
            numberList.add(number);
        }
        return numberList;
    }

    private void checkNagative(int number){
        if(number < 0 ){
            throw new RuntimeException();
        }
    }
}
