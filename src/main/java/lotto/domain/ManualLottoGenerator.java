package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {
    private static final Pattern STANDARD_PATTERN = Pattern.compile(",");

    private final List<Integer> numbers;

    public ManualLottoGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<LottoTicket> createMany(List<String> inputs) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (String input : inputs) {
            List<Integer> numbers = ManualLottoGenerator.toNumbers(input);
            tickets.add(LottoTicket.create(toLottoNumber(numbers)));
        }

        return tickets;
    }

    public static List<Integer> toNumbers(String input) {
        return Arrays.stream(STANDARD_PATTERN.split(input))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> toLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::get)
                .collect(Collectors.toList());
    }

    @Override
    public LottoTicket create() {
        return LottoTicket.create(ManualLottoGenerator.toLottoNumber(numbers));
    }
}
