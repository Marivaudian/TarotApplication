import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

public class TarotFrame extends JFrame{

    private Deck deck = new Deck();
    private String cardDescription = "";
    private String previousCardName = "";

    private JPanel north;
    private JPanel east;
    private JPanel central;
    private JPanel west;
    private JPanel south;

    private int counter = 0;

    public TarotFrame(){
        /* Creates the frame for the application, as well as setting up the initial GUI. Follows the naming
         * convention of NECSW that is used in BorderLayout.
        */

        try {
        GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("TarotApp\\src\\Resources\\Canterbury.ttf")));
        } catch (IOException|FontFormatException e) {
        //Thanks to Cory on StackOverflow, https://stackoverflow.com/questions/5652344/how-can-i-use-a-custom-font-in-java
        }

        this.setTitle("Tarot Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setSize(500, 750);

        north = new JPanel();
        east = new JPanel();
        central = new JPanel();
        west = new JPanel();
        south = new JPanel();

        north.setBackground(Color.DARK_GRAY);
        east.setBackground(Color.ORANGE);
        central.setBackground(Color.YELLOW);
        west.setBackground(Color.GREEN);
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
        south.setLayout(new GridLayout(1, 2));

        JLabel cardNameLabel = new JLabel();
        cardNameLabel.setFont(new Font("Canterbury", Font.PLAIN, 50));
        cardNameLabel.setText("Card Name Goes Here");
        cardNameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton drawButton = new JButton("Draw");
        drawButton.setPreferredSize(new Dimension(150, 75));
        drawButton.setFont(new Font("Canterbury", Font.PLAIN, 25));

        //When button is clicked, draws a random card. Repeating cards trigger a font size increase and unique color change.
        drawButton.addActionListener(e ->{
            Card drawnCard = deck.randomDraw();
            addDraw(drawnCard.getCardName());
            if(previousCardName == drawnCard.getCardName()){
                cardNameLabel.setFont(new Font("Canterbury", Font.BOLD, 50));
                cardNameLabel.setForeground(drawnCard.getCardColor());
            }else{
                previousCardName = drawnCard.getCardName();
                cardNameLabel.setFont(new Font("Canterbury", Font.PLAIN, 50));
                cardNameLabel.setForeground(Color.BLACK);
            }
            cardNameLabel.setText(drawnCard.getCardName());
            // if(drawnCard.getCardOrientation()){
            //     cardDescription = drawnCard.getCardUprightDescription();
            // }else{ 
            //     cardDescription = drawnCard.getCardReversedDescription();
            // }
        });

        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.setPreferredSize(new Dimension(150, 75));
        shuffleButton.setFont(new Font("Canterbury", Font.PLAIN, 25));

        //When button is clicked, shuffles the deck.
        shuffleButton.addActionListener(e ->{
            
        });
        
        north.add(cardNameLabel);

        //JPanel southernPanel = new JPanel();
        south.add(drawButton);
        south.add(shuffleButton);

        // JLabel test = new JLabel("Cat");
        // test.setPreferredSize(new Dimension(50, 50));
        // test.setBackground(Color.WHITE);
        // test.setOpaque(true);
        // test.setHorizontalAlignment(SwingConstants.CENTER);
        // test.setFont(new Font("Canterbury", Font.PLAIN, 25));
        // west.add(test);

        // JLabel teste = new JLabel();
        // teste.setPreferredSize(new Dimension(50, 50));
        // west.add(teste);

        // JLabel testee = new JLabel();
        // testee.setPreferredSize(new Dimension(50, 50));
        // west.add(testee);

        // JLabel testeee = new JLabel();
        // testeee.setPreferredSize(new Dimension(50, 50));
        // west.add(testeee);

        //south.add(south, BorderLayout.CENTER);


        this.setLayout(new BorderLayout());
        this.add(north, BorderLayout.NORTH);
        this.add(east, BorderLayout.EAST); 
        this.add(central, BorderLayout.CENTER);
        this.add(west, BorderLayout.WEST);
        this.add(south, BorderLayout.SOUTH);

        this.setVisible(true);
        
    }

    private void addDraw(String cardName) {
        counter++;
    
        JLabel cardLabel = new JLabel(cardName);
    
        if (west.getComponentCount() >= 4) {
            Component oldestDraw = west.getComponent(3);
            west.remove(3);
            east.add(oldestDraw, 0);
        }
    
        if (east.getComponentCount() > 4) {
            east.remove(4);
        }
    
        west.add(cardLabel, 0);
    
        west.revalidate();
        west.repaint();
        east.revalidate();
        east.repaint();
    }
}
