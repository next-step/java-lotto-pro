package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nums {

    private static final String ILLEGAL_DELIMITER_MESSAGE = "커스텀 구분자는 1자리의 단일 값이어야 합니다.";
    private static String DELIMITER_PATTERN = ",|:";
    private static String SEPARATOR = "|";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";
    List<Num> nums;

    public Nums(String input) {
        this.nums = new ArrayList<>();
        setElements(input);
    }

    private void setElements(String input) {

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

        if (m.find()) {
            validateDelimiterPattern(m);
            DELIMITER_PATTERN += (SEPARATOR + m.group(1));
            input = m.group(2);
        }

        String[] nums = input.split(DELIMITER_PATTERN);

        for (int i = 0; i < nums.length; i++) {
            this.nums.add(new Num(nums[i]));
        }

    }

    private void validateDelimiterPattern(Matcher m) {
        if (m.group(1).length() != 1) {
            System.out.println(ILLEGAL_DELIMITER_MESSAGE);
            throw new RuntimeException();
        }
    }

    public int addElements() {
        int sum = 0;

        for (Num e : nums) {
            sum += e.getElement();
        }

        return sum;
    }

}
