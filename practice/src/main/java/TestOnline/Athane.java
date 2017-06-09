package TestOnline;

/**
 * Created by phandung on 5/29/17.
 */
public class Athane {
    private static char[] players  = {'A','B','C'};
    private static Integer[] cards= {4,5,3,2,1,9,11,17,13,19,21,6,4};

    public static void main(String[] args) {
       doPlay(players,cards);
    }
    private static int getMaxPosition(Integer[] cards){
        int max = cards[0];
        int index = 0;
        for(int i = 0 ; i < cards.length ; i ++){
            if(max <= cards[i]){
                max = cards[i];
                index = i;
            }
        }
        return index;
    }


    private static void doPlay(char[] players , Integer[] cards){
        if(players.length < cards.length){
            players = concatArray(players,cards);
        }
        // length of players always greater or equal length of cards
        for(int i = 0 ; i <players.length ; i ++){
            if(cards.length == 0){
                System.out.println(" Winner is "+players[i -1]);
                break;
            }
            int maxPosition = getMaxPosition(cards);
            Integer[] newCard = new Integer[maxPosition];
            for(int j = 0 ; j < maxPosition ; j++){
                newCard[j] = cards[j];
            }
            cards = newCard;
        }

    }



    private static char[] concatArray(char[] players , Integer[] cards){
        char[] newPlayers = new char[cards.length];
        int distance = cards.length - players.length;
        for(int i = 0 ; i < players.length; i ++){
                newPlayers[i] = players[i];
        }
        for(int i = 0 ; i < distance ; i ++){
            newPlayers[players.length + i] = newPlayers[i];
        }
        return newPlayers;
    }





}
