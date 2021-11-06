package lotto.controller;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import lotto.controller.exception.BadRequestException;
import lotto.controller.view.LottoPurchaseView;
import lotto.controller.view.LottoResultView;
import lotto.model.LottoMatcher;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoNumbers;
import lotto.model.dto.MatchResult;
import lotto.repository.LottoNumbersCollectionRepository;
import lotto.repository.PaymentRepository;

public class LottoController {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
    private static final String INVALID_PAYMENT_INPUT_ERR_MSG = "구입 금액으로 숫자만 입력해야 합니다.";
    private static final String NUMBER_DELIMITER = ",";
    private static final Pattern LOTTO_NUMBER_PATTERN = Pattern.compile("\\d+(" + NUMBER_DELIMITER + "\\d+)*");
    private static final String INVALID_LOTTO_NUMBER_INPUT_ERR_MSG = "잘못된 형식의 로또 번호입니다.";

    private static final PaymentRepository PAYMENT_REPOSITORY = new PaymentRepository();
    private static final LottoNumbersCollectionRepository LOTTO_NUMBERS_COLLECTION_REPOSITORY =
        new LottoNumbersCollectionRepository();

    public LottoPurchaseView getLottoPurchase(String inputPayment) {
        if (!NUMBER_PATTERN.matcher(inputPayment).matches()) {
            throw new BadRequestException(INVALID_PAYMENT_INPUT_ERR_MSG);
        }
        return handleException(() -> {
            int payment = Integer.parseInt(inputPayment);
            LottoNumberGenerator generator = new LottoNumberGenerator(payment);
            Collection<LottoNumbers> numbersCollection = generator.getLottoNumbersCollection();
            String paymentId = PAYMENT_REPOSITORY.save(payment);
            String lottoId = LOTTO_NUMBERS_COLLECTION_REPOSITORY.save(numbersCollection);
            return new LottoPurchaseView(paymentId, lottoId, numbersCollection);
        });
    }

    public LottoResultView getLottoResult(String paymentId, String lottoId, String winningNumbers) {
        String processedWinningNumbers = winningNumbers.replace(" ", "");
        if (!LOTTO_NUMBER_PATTERN.matcher(processedWinningNumbers).matches()) {
            throw new BadRequestException(INVALID_LOTTO_NUMBER_INPUT_ERR_MSG);
        }
        return handleException(() -> {
            int payment = PAYMENT_REPOSITORY.getById(paymentId);
            Collection<LottoNumbers> lottoNumbersCollection = LOTTO_NUMBERS_COLLECTION_REPOSITORY.getById(lottoId);
            LottoMatcher lottoMatcher = new LottoMatcher(payment, processedWinningNumbers.split(NUMBER_DELIMITER));
            MatchResult matchResult = lottoMatcher.getMatchResult(lottoNumbersCollection);
            return new LottoResultView(matchResult);
        });
    }

    private <O> O handleException(final Supplier<O> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            throw new BadRequestException(e.getMessage());
        }
    }
}
