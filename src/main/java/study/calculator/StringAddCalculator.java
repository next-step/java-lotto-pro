package study.calculator;

import study.splitter.Splitter;
import study.util.NumberUtil;
import study.util.StringUtil;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String str) {
        if(StringUtil.isEmpty(str)) {
            return NumberUtil.ZERO;
        }

        return sum(Splitter.split(str));
    }

    private static int sum(String[] strings) {
        int sum = NumberUtil.ZERO;
        for(String str : strings) {
            int num = NumberUtil.convertToPositiveInt(str);
            sum += num;
        }
        return sum;
    }

}
