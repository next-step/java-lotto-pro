package lotto.ui;

import static lotto.ui.LottoNumberParser.parseLottoNumbers;

import java.util.List;
import java.util.Scanner;
import lotto.domain.lotto.LottoNumbers;

public class LottoNumberReader {
    private final Scanner scanner;

    public LottoNumberReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Integer> readLottoNumbers() {
        final String nextLine = scanner.nextLine();

        try {
            return parseLottoNumbers(nextLine);
        } catch (NumberFormatException e) {
            System.out.println("정수를 입력해 주세요.");
            return readLottoNumbers();
        } catch (LottoNumberSizeException e) {
            System.out.println("숫자 " + LottoNumbers.SIZE + "개를 입력해주세요.");
            return readLottoNumbers();
        }
    }
}
