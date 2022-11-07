package lotto.strategy;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

import static lotto.io.InputUtils.*;

public class ConsoleLottoGenerateStrategy implements LottoGenerateStrategy{

    private Logger log = LoggerFactory.getLogger(ConsoleLottoGenerateStrategy.class);

    @Override
    public Lotto generateLotto() {
        List<String> numberStrings = Arrays.asList(readConsole().split(","));

        try{
            return Lotto.create(numberStrings
                    .stream()
                    .map(number -> new Integer(number))
                    .collect(Collectors.toList()));
        }catch(IllegalArgumentException e){
            log.error("[ERROR] "+e.getLocalizedMessage());
            return generateLotto();
        }
    }
}
