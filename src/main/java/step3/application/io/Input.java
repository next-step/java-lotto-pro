package step3.application.io;

import static java.util.stream.Collectors.toList;

import java.io.Closeable;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import step3.domain.LottoNumber;

public class Input implements Closeable {

    private static final Scanner scanner = new Scanner(System.in);

    public int money() {
        return Integer.parseInt(scanner.nextLine());
    }

    public List<LottoNumber> lottoNumbers() {
        return parseWinningNumbers(scanner.nextLine());
    }

    private List<LottoNumber> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(toList());
    }

    @Override
    public void close() {
        scanner.close();
    }
}
