package study.calculator;

import study.splitter.Splitter;
import study.util.NumberUtil;
import study.util.StringUtil;

public class StringAddCalculator {

    public static int splitAndSum(String str) {
        if(StringUtil.isEmpty(str)) {
            return NumberUtil.ZERO;
        }
        if(StringUtil.isNotSplit(str)) {
            return NumberUtil.ONE;
        }
        return sum(Splitter.split(str));
    }

    private static int sum(String[] strings) {
        int sum = NumberUtil.ZERO;
        for(String str : strings) {
            int num = NumberUtil.convertStrToInt(str);
            sum += num;
        }
        return sum;
    }

}
