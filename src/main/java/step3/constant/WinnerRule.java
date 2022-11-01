package step3.constant;

import java.util.HashMap;
import java.util.Map;

public class WinnerRule {
    // 컬렉션은 public으로 열 경우 위험
    private static final Map<Integer, Integer> rules = new HashMap<>();

    public static void setWinnerRules() {
        rules.put(3,5000);
        rules.put(4,50000);
        rules.put(5,1500000);
        rules.put(6,2000000000);
    }

    public static Map<Integer, Integer> getRules() {
        return rules;
    }
}
