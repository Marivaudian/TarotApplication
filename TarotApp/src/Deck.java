import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> deck;
    private List<Card> originalDeck;
    private int deckSize;
    

    public Deck(){
        //Primarily serves to add cards to the deck, in this case only the major arcana

        this.originalDeck = new ArrayList<>();
        this.deck = new ArrayList<>();

        originalDeck.add(new Card("0. The Fool",
                "beginnings, freedom, innocence, originality, adventure, idealism, spontaneity",
                "reckless, careless, distracted, naive, foolish, gullible, stale, dull", new Color(255,223,186)));

        originalDeck.add(new Card("1. The Magician",
                "skill, mastery, manifestation, concentration, resourcefulness",
                "manipulation, deception, illusions, lack of focus", new Color(128,0,128)));

        originalDeck.add(new Card("2. The High Priestess",
                "intuition, subconscious mind, wisdom, mystery, spiritual insight",
                "secrets, confusion, superficial knowledge, imbalance", new Color(72,61,139)));

        originalDeck.add(new Card("3. The Empress",
                "fertility, abundance, nurturing, creativity, motherhood, beauty",
                "infertility, lack of growth, neglect, smothering", new Color(144,238,144)));

        originalDeck.add(new Card("4. The Emperor",
                "authority, structure, discipline, stability, leadership",
                "tyranny, rigidity, lack of discipline, abuse of power", new Color(139,69,19)));

        originalDeck.add(new Card("5. The Hierophant",
                "tradition, conformity, spiritual guidance, education, wisdom",
                "dogma, ignorance, rebellion, being too rigid", new Color(255,215,0)));

        originalDeck.add(new Card("6. The Lovers",
                "partnership, love, union, choices, harmony, attraction",
                "disharmony, disconnection, imbalanced relationships, poor choices", new Color(255,182,193)));

        originalDeck.add(new Card("7. The Chariot",
                "victory, determination, control, self-discipline, willpower",
                "lack of control, aggression, obstacles, confusion", new Color(0,0,139)));

        originalDeck.add(new Card("8. Strength",
                "courage, inner strength, patience, determination, compassion",
                "weakness, insecurity, self-doubt, lack of courage", new Color(255,140,0)));

        originalDeck.add(new Card("9. The Hermit",
                "introspection, solitude, wisdom, guidance, inner search",
                "isolation, loneliness, depression, lack of direction", new Color(169,169,169)));

        originalDeck.add(new Card("10. Wheel of Fortune",
                "change, cycles, destiny, luck, karma, fate",
                "bad luck, stagnation, cycles of misfortune, lack of control", new Color(255,223,0)));

        originalDeck.add(new Card("11. Justice",
                "fairness, truth, accountability, law, balance",
                "injustice, dishonesty, unfair treatment, imbalance", new Color(195,195,195)));

        originalDeck.add(new Card("12. The Hanged Man",
                "sacrifice, new perspective, letting go, patience, enlightenment",
                "stagnation, selfishness, lack of perspective, victimhood", new Color(70,130,180)));

        originalDeck.add(new Card("13. Death",
                "transformation, endings, new beginnings, rebirth",
                "fear of change, stagnation, avoidance of transformation", new Color(0,0,0)));

        originalDeck.add(new Card("14. Temperance",
                "balance, harmony, moderation, patience, purpose",
                "imbalance, excess, lack of purpose, disharmony", new Color(135,206,250)));

        originalDeck.add(new Card("15. The Devil",
                "addiction, materialism, bondage, temptation, unhealthy attachments",
                "liberation, breaking free, self-realization, overcoming addiction", new Color(139,0,0)));

        originalDeck.add(new Card("16. The Tower",
                "sudden change, upheaval, chaos, revelation, destruction",
                "disaster, collapse, ruin, sudden loss, avoidance of change", new Color(255,69,0)));

        originalDeck.add(new Card("17. The Star",
                "hope, inspiration, serenity, spiritual guidance, renewal",
                "hopelessness, despair, lack of faith, discouragement", new Color(255,240,132)));

        originalDeck.add(new Card("18. The Moon",
                "illusion, intuition, dreams, subconscious, mystery",
                "deception, confusion, false illusions, uncertainty", new Color(105,105,115)));

        originalDeck.add(new Card("19. The Sun",
                "positivity, success, vitality, enlightenment, joy, confidence",
                "lack of clarity, failure, missed opportunities, lack of joy", new Color(255,255,0)));

        originalDeck.add(new Card("20. Judgement",
                "rebirth, inner calling, absolution, renewal, reflection",
                "self-doubt, refusal to change, stagnation, harsh judgment", new Color(255,99,71)));

        originalDeck.add(new Card("21. The World",
                "completion, wholeness, achievement, fulfillment, integration",
                "unfinished business, lack of closure, incomplete, isolation", new Color(0,128,0)));

        deck.addAll(originalDeck);
        deckSize = deck.size();
        
    }

    public void shuffleOrientations(){
        //Shuffles orientation of each card via random boolean assignment
        Random random = new Random();
        for(Card card : deck){
            card.setCardOrientation(random.nextBoolean());
        }
    }

    public void shuffleDeck(){
        //shuffles the order of the deck
        Collections.shuffle(deck);
    }

    public void unshuffleDeck(){
        deck.clear();
        deck.addAll(originalDeck);
    }

    public void printDeck(){
        //prints the current deck in order
        for (Card card : deck) {
            if (card.getCardOrientation()) {
                //System.out.println(card.getCardName() + " / " + "Upright" + " / " + card.getCardUprightDescription());
            } else {
                //System.out.println(card.getCardName() + " / " + "Reverse" + " / " + card.getCardReversedDescription());
            }
        }
    }

    public void numberDraw(int index) {
        //Draws a card based off of the given integer value
        int cardIndex = Math.abs(index % deckSize);
        Card drawnCard = deck.get(cardIndex);

        if (drawnCard.getCardOrientation()) {
            //System.out.println(drawnCard.getCardName() + " / " + "Upright" + " / " + drawnCard.getCardUprightDescription());
        } else {
            //System.out.println(drawnCard.getCardName() + " / " + "Reverse" + " / " + drawnCard.getCardReversedDescription());
        }
    }

    public Card randomDraw() {
        //Randomly draws a card based off of a random integer value
        Random random = new Random();
        int randomIndex = random.nextInt(deckSize);
        //System.out.println("Randomly chosen index: " + randomIndex);
        numberDraw(randomIndex);
        return deck.get(randomIndex);
    }
    

}
