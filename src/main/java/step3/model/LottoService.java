package step3.model;

public class LottoService {

    private int purchasePrice;
    private final Lottos lottos;

    public LottoService(int purchasePrice,Lottos lottos){
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
    }

    public void purchaseByAuto(){
        while(lottos.getSumOfPriceLottos() < purchasePrice){
            lottos.addByAuto();
        }
    }

}
