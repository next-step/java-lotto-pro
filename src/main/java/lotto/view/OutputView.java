package lotto.view;

import java.util.List;

public class OutputView {

    private OutputView() {

    }

    public static void printLottoCount(int countOfLotto) {
        System.out.println(countOfLotto + "개를 구매했습니다.");
    }

    public static void printLotto(List<List<Integer>> lottos) {
        StringBuilder output = new StringBuilder();
        for (List<Integer> lotto : lottos) {
            output.append("[");
            lotto.stream()
                    .forEach(number -> output.append(number + ", "));
            output.delete(output.length() - 2, output.length());
            output.append("]\n");
        }
        System.out.println(output);
    }
}
