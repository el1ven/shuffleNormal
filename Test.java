import java.util.Random;
public class Test5 {
    public static void main(String[] args){
        DeskOfCard gameDesk = new DeskOfCard();
        gameDesk.initCards();//初始化牌组
        gameDesk.shuffleCards();//洗牌
        gameDesk.dealCard();//发牌
    }
    
    static class Card{
        
        private String num;//点数
        private String suit;//花色
        public Card(){}
        public Card(String num, String suit){
            this.num = num;
            this.suit = suit;
        }
        public String toString(){
            //打印信息,继承Object方法并重写,我们在发牌的时候就只用调用cards[i]就可以打出对象的信息，否则打出的是对象的地址！
            String str = this.suit+":"+this.num+" ";
            return str;
        }
        
        public String getNum() {
            return num;
        }
        
        public void setNum(String num) {
            this.num = num;
        }
        
        public String getSuit() {
            return suit;
        }
        
        public void setSuit(String suit) {
            this.suit = suit;
        }
    }
    
    static class DeskOfCard{
        private Card cards[];
        public void initCards(){
            String num[] = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
            String suit[] = new String[]{"♠","♣","♥","♦"};
            cards = new Card[52];
            for(int i = 0; i < 52; i++){
                cards[i] = new Card(num[i%13],suit[i/13]);//分配点数和花色
            }
        }
        public void shuffleCards(){
            Random random = new Random();
            for(int i = 0; i < 52; i++){
                int j = random.nextInt(52);
                Card temp = cards[i];//swap功能，完成打乱洗牌功能
                cards[i] = cards[j];
                cards[j] = temp;
            }
            
        }
        public void dealCard(){
            for(int i = 0; i < 52; i++){
                if(i%4 == 0){//4个一组
                    System.out.println("\n");
                }
                System.out.print(cards[i]);
            }
        }
    }
}


