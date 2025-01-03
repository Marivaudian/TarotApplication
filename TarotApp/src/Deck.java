import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> deck;
    private int deckSize;

    public Deck(){
        //Primarily serves to add cards to the deck, in this case only the major arcana

        this.deck = new ArrayList<>();

        deck.add(new Card("The Fool",
                "beginnings, freedom, innocence, originality, adventure, idealism, spontaneity",
                "reckless, careless, distracted, naive, foolish, gullible, stale, dull"));

        deck.add(new Card("The Magician",
                "skill, mastery, manifestation, concentration, resourcefulness",
                "manipulation, deception, illusions, lack of focus"));

        deck.add(new Card("The High Priestess",
                "intuition, subconscious mind, wisdom, mystery, spiritual insight",
                "secrets, confusion, superficial knowledge, imbalance"));

        deck.add(new Card("The Empress",
                "fertility, abundance, nurturing, creativity, motherhood, beauty",
                "infertility, lack of growth, neglect, smothering"));

        deck.add(new Card("The Emperor",
                "authority, structure, discipline, stability, leadership",
                "tyranny, rigidity, lack of discipline, abuse of power"));

        deck.add(new Card("The Hierophant",
                "tradition, conformity, spiritual guidance, education, wisdom",
                "dogma, ignorance, rebellion, being too rigid"));

        deck.add(new Card("The Lovers",
                "partnership, love, union, choices, harmony, attraction",
                "disharmony, disconnection, imbalanced relationships, poor choices"));

        deck.add(new Card("The Chariot",
                "victory, determination, control, self-discipline, willpower",
                "lack of control, aggression, obstacles, confusion"));

        deck.add(new Card("Strength",
                "courage, inner strength, patience, determination, compassion",
                "weakness, insecurity, self-doubt, lack of courage"));

        deck.add(new Card("The Hermit",
                "introspection, solitude, wisdom, guidance, inner search",
                "isolation, loneliness, depression, lack of direction"));

        deck.add(new Card("Wheel of Fortune",
                "change, cycles, destiny, luck, karma, fate",
                "bad luck, stagnation, cycles of misfortune, lack of control"));

        deck.add(new Card("Justice",
                "fairness, truth, accountability, law, balance",
                "injustice, dishonesty, unfair treatment, imbalance"));

        deck.add(new Card("The Hanged Man",
                "sacrifice, new perspective, letting go, patience, enlightenment",
                "stagnation, selfishness, lack of perspective, victimhood"));

        deck.add(new Card("Death",
                "transformation, endings, new beginnings, rebirth",
                "fear of change, stagnation, avoidance of transformation"));

        deck.add(new Card("Temperance",
                "balance, harmony, moderation, patience, purpose",
                "imbalance, excess, lack of purpose, disharmony"));

        deck.add(new Card("The Devil",
                "addiction, materialism, bondage, temptation, unhealthy attachments",
                "liberation, breaking free, self-realization, overcoming addiction"));

        deck.add(new Card("The Tower",
                "sudden change, upheaval, chaos, revelation, destruction",
                "disaster, collapse, ruin, sudden loss, avoidance of change"));

        deck.add(new Card("The Star",
                "hope, inspiration, serenity, spiritual guidance, renewal",
                "hopelessness, despair, lack of faith, discouragement"));

        deck.add(new Card("The Moon",
                "illusion, intuition, dreams, subconscious, mystery",
                "deception, confusion, false illusions, uncertainty"));

        deck.add(new Card("The Sun",
                "positivity, success, vitality, enlightenment, joy, confidence",
                "lack of clarity, failure, missed opportunities, lack of joy"));

        deck.add(new Card("Judgement",
                "rebirth, inner calling, absolution, renewal, reflection",
                "self-doubt, refusal to change, stagnation, harsh judgment"));

        deck.add(new Card("The World",
                "completion, wholeness, achievement, fulfillment, integration",
                "unfinished business, lack of closure, incomplete, isolation"));

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

    public void printDeck(){
        //prints the current deck in order
        for (Card card : deck) {
            if (card.getCardOrientation()) {
                System.out.println(card.getCardName() + " / " + "Upright" + " / " + card.getCardUprightDescription());
            } else {
                System.out.println(card.getCardName() + " / " + "Reverse" + " / " + card.getCardReversedDescription());
            }
        }
    }

    public void numberDraw(int index) {
        //Draws a card based off of the given integer value
        int cardIndex = Math.abs(index % deckSize);
        Card drawnCard = deck.get(cardIndex);

        if (drawnCard.getCardOrientation()) {
            System.out.println(drawnCard.getCardName() + " / " + "Upright" + " / " + drawnCard.getCardUprightDescription());
        } else {
            System.out.println(drawnCard.getCardName() + " / " + "Reverse" + " / " + drawnCard.getCardReversedDescription());
        }
    }

    public Card randomDraw() {
        //Randomly draws a card based off of a random integer value
        Random random = new Random();
        int randomIndex = random.nextInt(deckSize);
        System.out.println("Randomly chosen index: " + randomIndex);
        numberDraw(randomIndex);
        return deck.get(randomIndex);
    }

}
