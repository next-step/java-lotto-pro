package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class ResultView {

    private static final String QUANTITY_PRINT_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String DELIMITER = ", ";
    private static final String LOTTO_MESSAGE_START_CHAR = "[";
    private static final String LOTTO_MESSAGE_END_CHAR = "]";

    public static void printLottos(Lottos lottos) {
        printQuantity(lottos.getQuantity());
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    private static void printQuantity(int quantity) {
        String message = String.format(QUANTITY_PRINT_MESSAGE_FORMAT, quantity);
        System.out.println(message);
    }

    private static void printLotto(Lotto lotto) {
        List<String> stringNumbers = lotto.getNumbers().stream().map(Object::toString).collect(Collectors.toList());
        String lottoMessage = LOTTO_MESSAGE_START_CHAR + String.join(DELIMITER, stringNumbers) + LOTTO_MESSAGE_END_CHAR;
        System.out.println(lottoMessage);
    }

}
