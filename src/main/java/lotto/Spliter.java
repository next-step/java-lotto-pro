package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Spliter {
    public List<Integer> split(String input) {
        StringTokenizer token = new StringTokenizer(input, ", ");
        List<Integer> winningNumbers = new ArrayList<>();
        while (token.hasMoreTokens()) {
            winningNumbers.add(Integer.parseInt(token.nextToken()));
        }
        return winningNumbers;
    }
}
