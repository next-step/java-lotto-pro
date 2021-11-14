package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManualPurchaseView {

    private static final String MANUAL_LOTTO_DELIMITER = ",";

    private LottoManualPurchaseView() {
    }

    public static List<List<Integer>> input(int purchaseAmount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();

        for (int i=0; i<purchaseAmount; i++) {
            String manualLottoNumber = Console.nextLine();
            final String[] manualLottoNumberSplit = manualLottoNumber.split(MANUAL_LOTTO_DELIMITER);

            manualLottoNumberSizeValid(manualLottoNumberSplit);
            manualLottoNumberValid(manualLottoNumberSplit);

            manualLottoNumbers.add(
                    Arrays.stream(manualLottoNumberSplit)
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
        }

        return manualLottoNumbers;
    }

    private static void manualLottoNumberValid(final String[] manualLottoNumberSplit) {
        for (String manualLottoNumber : manualLottoNumberSplit) {
            manualLottoNumberValid(manualLottoNumber);
            manualLottoNumberRangeValid(Integer.parseInt(manualLottoNumber));
        }
    }

    private static void manualLottoNumberRangeValid(final int manualLottoNumber) {
        if ( manualLottoNumber < LottoNumber.LOTTO_START_NUMBER || manualLottoNumber > LottoNumber.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자입니다.");
        }
    }

    private static int manualLottoNumberValid(final String manualLottoNumber) {
        try {
            return Integer.parseInt(manualLottoNumber);
        }catch (NumberFormatException e) {
            throw new NumberFormatException("로또 번호는 숫자만 가능 합니다.");
        }
    }

    private static void manualLottoNumberSizeValid(final String[] manualLottoNumberSplit) {
        if (Lotto.LOTTO_COUNT != manualLottoNumberSplit.length) {
            throw new IllegalArgumentException("로또 번호는 6개 입니다.");
        }
    }
}
