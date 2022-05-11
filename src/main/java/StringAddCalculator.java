public class StringAddCalculator {
    public static int splitAndSum(String str) {
        if (str == null || str.isEmpty())
            return 0;

        String[] strs = str.split(",");
        if (strs.length == 1)
            return Integer.parseInt(strs[0]);

        int sum = 0;
        for(String s : strs)
            sum += Integer.parseInt(s);

        return sum;
    }
}
