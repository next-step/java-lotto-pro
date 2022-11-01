package study.calculator;

import study.splitter.Splitter;
import study.util.NumberUtil;
import study.util.StringUtil;

public class StringAddCalculator {

    private StringAddCalculator() {}

    public static int splitAndSum(String str) {
        if(StringUtil.isEmpty(str)) {
            return NumberUtil.INIT_ZERO;
        }

        return sum(Splitter.split(str));
    }

    private static int sum(String[] strings) {
        int sum = NumberUtil.INIT_ZERO;

        for(String str : strings) {
            int num = NumberUtil.convertToPositiveInt(str);
            sum += num;
        }

        return sum;
    }

}
