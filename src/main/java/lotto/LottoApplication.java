package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

import lotto.controller.LottoController;
import lotto.controller.exception.BadRequestException;
import lotto.controller.view.LottoPurchaseView;
import lotto.controller.view.LottoResultView;

public class LottoApplication {
    private static final String QUERY_FOR_PAYMENT = "구입금액을 입력해주세요.";
    private static final String QUERY_FOR_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    private static final LottoController CONTROLLER = new LottoController();
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        LottoPurchaseView lottoPurchase = getLottoPurchase();
        System.out.println(lottoPurchase.purchaseInfoAsString);
        System.out.println();
        LottoResultView lottoResult = getLottoResult(lottoPurchase.paymentId, lottoPurchase.lottoId);
        System.out.println();
        System.out.println(lottoResult.resultAsString);
    }

    private static LottoPurchaseView getLottoPurchase() {
        return handleException(() -> {
            System.out.println(QUERY_FOR_PAYMENT);
            String payment = readLine();
            return CONTROLLER.getLottoPurchase(payment);
        });
    }

    private static LottoResultView getLottoResult(String paymentId, String lottoId) {
        return handleException(() -> {
            System.out.println(QUERY_FOR_WINNING_NUMBERS);
            String winningNumbers = readLine();
            return CONTROLLER.getLottoResult(paymentId, lottoId, winningNumbers);
        });
    }

    private static void handleException(final Runnable runnable) {
        handleException(() -> {
            runnable.run();
            return null;
        });
    }

    private static <O> O handleException(final Supplier<O> supplier) {
        try {
            return supplier.get();
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
            return handleException(supplier);
        }
    }

    private static String readLine() {
        try {
            return BUFFERED_READER.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
