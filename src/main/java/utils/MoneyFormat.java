package utils;

import java.text.DecimalFormat;

public class MoneyFormat {

    private static final DecimalFormat DF = new DecimalFormat("###,###");

    public static String getMoneyExpression(long money) {
        return DF.format(money);
    }
}
