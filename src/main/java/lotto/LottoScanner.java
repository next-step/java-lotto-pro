package lotto;

import java.io.*;

public class LottoScanner {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String DELIMITER = ",";


    public static Integer scanPayAmount() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static Integer[] scanWinningNumbers() throws IOException {
        String[] tokens = br.readLine()
            .split(DELIMITER);
        Integer[] winningNumbers = new Integer[tokens.length];
        for (int i = 0; i < winningNumbers.length; i++) {
            winningNumbers[i] = Integer.parseInt(tokens[i].trim());
        }
        return winningNumbers;
    }
}
