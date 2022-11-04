package lotto.view;

import lotto.controller.LottoValidator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int nextInt() {
        return scanner.nextInt();
    }

    public static int insertMoney() {
        OutputView.print("구입금액을 입력해 주세요.");
        int money = nextInt();

        if (!LottoValidator.isValidMoney(money)) {
            return insertMoney();
        }

        return money;
    }

    public static int insertManualLottoCount() {
        OutputView.print("수동으로 구매할 로또 수를 입력해 주세요");
        return nextInt();
    }

    public static List<Lotto> insertManualLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        List<List<LottoNumber>> lottoNumbers = new ArrayList<>();

        OutputView.print("수동으로 구매할 번호를 입력해 주세요.");
        for(int i=0; i<count; i++) {
            lottoNumbers.add(inputLotto());
        }

        if (!lottoNumbers.stream().allMatch(LottoValidator::isValidLotto)) {
            return insertManualLotto(count);
        }

        lottoNumbers.forEach(ln -> lottos.add(new Lotto(ln)));
        return lottos;
    }

    public static List<LottoNumber> insertWinningLotto() {
        OutputView.print("지난 주 당첨 번호를 입력해 주세요.");
        List<LottoNumber> lottoNumbers = inputLotto();
        if (!LottoValidator.isValidLotto(lottoNumbers)) {
            return insertWinningLotto();
        }
        return lottoNumbers;
    }

    public static List<LottoNumber> inputLotto() {
        String[] input = scanner.next().split(",");
        if (!Arrays.stream(input).map(Integer::parseInt).allMatch(LottoValidator::isValidLottoNumber)) {
            return inputLotto();
        }
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static LottoNumber insertBonusBall() {
        OutputView.print("보너스 볼을 입력해 주세요.");
        int lottoNumber = nextInt();
        if (!LottoValidator.isValidLottoNumber(lottoNumber)) {
            return insertBonusBall();
        }
        return new LottoNumber(lottoNumber);
    }
}
