package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nums {

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
            DELIMITER_PATTERN += (SEPARATOR + m.group(1));
            input = m.group(2);
        }

        String[] nums = input.split(DELIMITER_PATTERN);

        for (int i = 0; i < nums.length; i++) {
            this.nums.add(new Num(nums[i]));
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
