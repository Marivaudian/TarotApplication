public class Card {

    private String cardName;
    private String cardUprightDescription;
    private String cardReversedDescription;
    private boolean cardOrientation;

    public Card(String cardName, String cardUprightDescription, String cardReversedDescription){
        this.cardName = cardName;
        this.cardUprightDescription = cardUprightDescription;
        this.cardReversedDescription = cardReversedDescription;     
        this.cardOrientation = true; //false in this case means regular reading, or upright
    }

    public String getCardName(){
        //returns card name
        return cardName;
    }

    public String getCardUprightDescription(){
        //returns card upright description
        return cardUprightDescription;
    }

    public String getCardReversedDescription(){
        //returns card reversed description
        return cardReversedDescription;
    }

    public boolean getCardOrientation(){
        //returns card orientation
        return cardOrientation;
    }

    public void setCardOrientation(boolean cardOrientation){
        //changes card orientation based on given boolean value
        this.cardOrientation = cardOrientation;
    } 

}
