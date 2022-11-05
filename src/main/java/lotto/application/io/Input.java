package lotto.application.io;

import static java.util.stream.Collectors.toList;

import java.io.Closeable;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class Input implements Closeable {

    private static final Scanner scanner = new Scanner(System.in);

    public int money() {
        return Integer.parseInt(scanner.nextLine());
    }

    public List<LottoNumber> lottoNumbers() {
        return parseWinningNumbers(scanner.nextLine());
    }

    public LottoNumber bonusNumber() {
        return new LottoNumber(Integer.parseInt(scanner.nextLine()));
    }

    public Lottos manualLottos(int lottoCount) {
        return new Lottos(
            IntStream.range(0, lottoCount)
                .mapToObj(__ -> Lotto.manual(this.lottoNumbers()))
                .collect(toList())
        );
    }

    public int selfLottoCount() {
        return Integer.parseInt(scanner.nextLine());
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
