package lotto.domain;

import static java.util.Arrays.stream;

import generic.Money;
import java.util.List;
import java.util.stream.Collectors;
import lotto.InputPurchaseDto;
import lotto.InputWinningNumbersDto;

public class LottoMachine {
    private static final String SPLITTER = ",";

    private LottoMachine() {
    }

    public static PurchaseLottos purchase(final InputPurchaseDto inputPurchaseDto) {
        return PurchaseLottos.of(purchase(inputPurchaseDto.mapToLottoArray()), purchase(inputPurchaseDto.calculateAutoMoney()));
    }

    private static Lottos purchase(final Money purchaseMoney) {
        return Lottos.purchaseAuto(purchaseMoney);
    }

    private static Lottos purchase(final Lotto[] lottoArray) {
        return Lottos.of(lottoArray);
    }

    public static WinningNumbers winningLottoNumbers(final InputWinningNumbersDto inputWinningNumbersDto) {
        return WinningNumbers.of(inputWinningNumbersDto.mapToLottoNumbers(), inputWinningNumbersDto.mapToBonusNumber());
    }

}
