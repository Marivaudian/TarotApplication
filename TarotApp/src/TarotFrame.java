import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TarotFrame extends JFrame {

    private Deck deck = new Deck();
    private String cardDescription = "";
    private String previousCardName = "";

    private JPanel north;
    private JPanel east;
    private JPanel central;
    private JPanel west;
    private JPanel south;

    private int counter = 0;

    /**
     * Creates the primary frame for the application, as well as setting up the GUI.
     * Utilizes the naming convention of NECSW used in BorderLayout.
     * Also handles the shuffling of the deck, as well as the drawing of new cards
     * from said deck.
     */
    public TarotFrame() {

        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("TarotApp\\src\\Resources\\Canterbury.ttf")));
        } catch (IOException | FontFormatException e) {
            // Thanks to Cory on StackOverflow,
            // https://stackoverflow.com/questions/5652344/how-can-i-use-a-custom-font-in-java
        }

        this.setTitle("Tarot Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 750);

        north = new JPanel();
        east = new JPanel();
        central = new JPanel();
        west = new JPanel();
        south = new JPanel();

        north.setBackground(Color.DARK_GRAY);
        east.setBackground(Color.DARK_GRAY);
        central.setBackground(Color.YELLOW);
        west.setBackground(Color.DARK_GRAY);
        south.setBackground(Color.BLUE);

        north.setPreferredSize(new Dimension(100, 100));
        east.setPreferredSize(new Dimension(100, 100));
        central.setPreferredSize(new Dimension(100, 100));
        west.setPreferredSize(new Dimension(100, 100));
        south.setPreferredSize(new Dimension(100, 100));

        north.setLayout(new GridLayout(1, 1));
        east.setLayout(new GridLayout(4, 1));
        central.setLayout(new BorderLayout());
        west.setLayout(new GridLayout(4, 1));
        south.setLayout(new GridLayout(1, 3));

        JTextField cat = new JTextField(16);

        JLabel cardNameLabel = new JLabel();
        createText(cardNameLabel, 50, Color.BLACK);
        cardNameLabel.setText("Draw a card");
        cardNameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton drawButton = new JButton("Draw");
        drawButton.setPreferredSize(new Dimension(150, 75));
        createText(drawButton, 50, Color.BLACK);

        // When button is clicked, draws a random card. Repeating cards trigger a font
        // size increase and unique color change.
        drawButton.addActionListener(e -> {
            // disableButton(drawButton, 1000);
            Card drawnCard = deck.draw();
            addDraw(drawnCard);
            if (previousCardName == drawnCard.getCardName()) {
                createText(cardNameLabel, 50, drawnCard.getCardColor());
            } else {
                previousCardName = drawnCard.getCardName();
                createText(cardNameLabel, 50, Color.BLACK);
            }
            cardNameLabel.setText(drawnCard.getCardName());
            // if(drawnCard.getCardOrientation()){
            // cardDescription = drawnCard.getCardUprightDescription();
            // }else{
            // cardDescription = drawnCard.getCardReversedDescription();
            // }
        });

        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.setPreferredSize(new Dimension(150, 75));
        shuffleButton.setFont(new Font("Canterbury", Font.PLAIN, 25));

        // When button is clicked, shuffles the deck.
        shuffleButton.addActionListener(e -> {
            deck.shuffleDeck();
        });

        JButton resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(150, 75));
        resetButton.setFont(new Font("Canterbury", Font.PLAIN, 25));

        // When button is clicked, shuffles the deck.
        resetButton.addActionListener(e -> {
            deck.unshuffleDeck();
            west.removeAll();
            east.removeAll();

            cardNameLabel.setText("Draw a card");

            this.revalidate();
            this.repaint();
            
        });

        


        north.add(cardNameLabel);

        south.add(drawButton);
        south.add(shuffleButton);
        south.add(resetButton);

        JButton card = new JButton();

        this.setLayout(new BorderLayout());
        this.add(north, BorderLayout.NORTH);
        this.add(east, BorderLayout.EAST);
        this.add(central, BorderLayout.CENTER);
        this.add(west, BorderLayout.WEST);
        this.add(south, BorderLayout.SOUTH);

        this.setVisible(true);

    }

    /**
     * Adds recently drawn card to GUI, while pushing older cards down the line,
     * starting from the top of the eastern side
     * 
     * @param card
     */
    private void addDraw(Card card) {
        counter++;

        JLabel cardLabel = new JLabel(card.GetCardNumber(), SwingConstants.CENTER);
        createText(cardLabel, 50, Color.BLACK);
        

        if (west.getComponentCount() > 0) {
            Component nextCard = west.getComponent(0);
            JLabel nextCardLabel = (JLabel) nextCard;
            if (nextCardLabel.getText().equals(card.GetCardNumber())) {
                createText(cardLabel, 50, card.getCardColor());
            }
        }

        if (west.getComponentCount() >= 4) {
            Component oldestDraw = west.getComponent(3);
            west.remove(3);
            east.add(oldestDraw, 0);
        }

        if (east.getComponentCount() > 4) {
            east.remove(4);
        }

        west.add(cardLabel, 0);

        this.revalidate();
        this.repaint();
    }

    static void disableButton(JButton button, int time) {
        button.setEnabled(false);

        Timer delay = new Timer(time, e -> button.setEnabled(true));
        delay.setRepeats(false);
        delay.start();

    }

    static void createText(Component component, int fontSize, Color fontColor) {
        component.setFont(new Font("Canterbury", 1, fontSize));
        component.setForeground(fontColor);
    }

}
