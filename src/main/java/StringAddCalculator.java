public class StringAddCalculator {
    public static int splitAndSum(String str) {
        if (str == null || str.isEmpty())
            return 0;

        String[] strs = str.split(",");
        if (strs.length == 1)
            return Integer.parseInt(strs[0]);

        if (strs.length == 2)
            return Integer.parseInt(strs[0]) + Integer.parseInt(strs[1]);

        return 0;
    }
}
