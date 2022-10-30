package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoMachine implements LottoMachine{


    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<LottoNumber>();
    private static final int LOTTE_MIN_NUMBER = 1;
    private static final int LOTTE_MAX_NUMBER = 45 ;

    public AutoLottoMachine(){
        setupLotto();
    }

    public static void setupLotto(){
        for (int i=LOTTE_MIN_NUMBER; i<=LOTTE_MAX_NUMBER; i++ ){
            LOTTO_NUMBERS.add(new LottoNumber(i));
        }

    }

    public void shuffleLottoNumber(List<LottoNumber> lottoNumbersList){
        Collections.shuffle(lottoNumbersList);
    }
    @Override
    public Lotto createLottoNumber() {

        shuffleLottoNumber(LOTTO_NUMBERS);

        return new Lotto(LOTTO_NUMBERS.subList(0,6));
    }


}
