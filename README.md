# 로또

## FeatureList

- Model

    - [X] 입력받은 구매금액을 로또 개수로 변환
    
        * [X] 예외 상황
    
          |내용   |Exception|
          |---|---|
          | 구매 금액이 1000원 미만(로또 최소 금액)인 경우 |IllegalArgumentException|
          | 구매 금액이 너무 클 경우 (1000만원 제한) |IllegalArgumentException|
          | 구매 금액이 1000원 단위가 아닌 경우 |IllegalArgumentException|
        
    - [X] 로또 개수 만큼 번호 생성하기
        * [X] 한 게임 당 6개의 랜덤 번호
        * [X] 로또 번호는 1~45 숫자 사이
        
    - [X] 입력받은 당첨 로또 번호와 구매한 로또의 일치 여부를 계산
        * 개수별 일치 여부를 저장
        * [X] 예외 상황
    
          |내용   |Exception|
          |---|---|
          | 당첨 로또 번호가 1~45 숫자 사이가 아닌 경우 |IllegalArgumentException|
          | 당첨 로또 번호가 6개가 아닌 경우 |IllegalArgumentException|
          | 당첨 로또 번호가 중복이 있는 경우 |IllegalArgumentException|
          
    - [X] 보너스볼 포함하여 등수 계산 추가
        * [X] 예외 상황

          |내용   |Exception|
          |---|---|
          | 보너스 번호가 1~45 숫자 사이가 아닌 경우 |IllegalArgumentException|
          | 당첨 로또 번호와 보너스 번호가 중복이 있는 경우 |IllegalArgumentException|
    
    - [X] 구매금액과 총 당첨금액에 대한 수익률을 계산
        * 5등 [5,000원], 4등 [50,000원], 3등 [1,500,000원], 2등[3,000,0000], 1등 [2,000,000,000원]

    - [ ] 수동으로 입력받은 번호로 로또를 생성
        * [ ] 예외 상황
    
          |내용   |Exception|
          |---|---|
          | 수동입력 개수가 숫자가 아닌 경우 |IllegalArgumentException|
          | 수동입력 개수가 구매금액을 초과하는 경우 |IllegalArgumentException|
    
- View
    - [X] 로또 구입금액 입력 Message 
    - [X] 당첨 로또 번호 입력 Message
    - [X] 보너스 볼 입력 Message
    - [ ] 수동 구매 로또 수 입력 Message
    - [ ] 수동 구매 로또 번호 입력 Message
    - [X] 로또 개수 구매 View
    - [X] 로또 번호뷰 View
    - [X] 당첨 통계 View 
       - 일치 개수
       - 총 수익률
    
- Controller & Main
  
   - [X] 입력에 대한 흐름제어 추가(Main <-> Controller)
   - [X] 입력 예외에 대한 재시도 처리 추가  

> 입력에 대한 예외상황 발생시 [ERROR] 형태의 에러 메세지를 출력한다.
