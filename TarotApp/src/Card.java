import java.awt.Color;

public class Card {

    private String cardName;
    private String cardUprightDescription;
    private String cardReversedDescription;
    private String cardNumber;
    private boolean cardOrientation;
    private Color cardColor;

    public Card(String cardNumber, String cardName, String cardUprightDescription, String cardReversedDescription, Color cardColor){
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardUprightDescription = cardUprightDescription;
        this.cardReversedDescription = cardReversedDescription;     
        this.cardOrientation = true; //false in this case means regular reading, or upright
        this.cardColor = cardColor;
    }

    public String GetCardNumber(){
        //returns card number
        return cardNumber;
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

    public Color getCardColor(){
        //returns card name
        return cardColor;
    }

}
