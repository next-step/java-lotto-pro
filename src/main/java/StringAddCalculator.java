public class StringAddCalculator {

    public static int splitAndSum(String actual) {
        int sum = 0;
        if(actual == null || actual.isEmpty()) {
            return 0;
        }

        String [] numbers = actual.split(",|:");
        for(String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
