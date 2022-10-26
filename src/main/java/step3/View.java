package step3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {

    private final Scanner sc;

    public View() {
        this.sc = new Scanner(System.in);
    }

    public int purchase() {
        System.out.println(Message.START.getMessage());
        return sc.nextInt();
    }

    public List<Integer> inputWinnerNumbers() {
        System.out.println("\n" + Message.WIN_NUMBERS.getMessage());
        return Arrays.asList(sc.next().split(","))
                .stream()
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
    }

    public void statistic(Map<Integer, Integer> statistics, double statisticLottos) {
        System.out.println("\n" + Message.STATISTICS.getMessage());
        System.out.println(Message.MATCH_THREE.resultMatchNumber(statistics.get(Award.THREE.getCount())));
        System.out.println(Message.MATCH_FOUR.resultMatchNumber(statistics.get(Award.FOUR.getCount())));
        System.out.println(Message.MATCH_FIVE.resultMatchNumber(statistics.get(Award.FIVE.getCount())));
        System.out.println(Message.MATCH_SIX.resultMatchNumber(statistics.get(Award.SIX.getCount())));
        System.out.println(Message.STATISTICS_RESULT.resultStatistic(statisticLottos));
    }

}
