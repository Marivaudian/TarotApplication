import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class TarotFrame extends JFrame{

    public TarotFrame(){
        /* Creates the frame for the application, as well as setting up the initial GUI. Follows the naming
         * convention of NECSW that is used in BorderLayout.
        */
        
        this.setTitle("Tarot Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 750);

        JPanel north = new JPanel();
        JPanel east = new JPanel();
        JPanel central = new JPanel();
        JPanel west = new JPanel();
        JPanel south = new JPanel();

        north.setBackground(Color.RED);
        //east.setBackground(Color.ORANGE);
        central.setBackground(Color.YELLOW);
        //west.setBackground(Color.GREEN);
        south.setBackground(Color.BLUE);

        north.setPreferredSize(new Dimension(100, 100));
        //east.setPreferredSize(new Dimension(100, 100));
        central.setPreferredSize(new Dimension(100, 100));
        //west.setPreferredSize(new Dimension(100, 100));
        south.setPreferredSize(new Dimension(100, 100));

        north.setLayout(new BorderLayout());
        //east.setLayout(new BorderLayout());
        central.setLayout(new BorderLayout());
        //west.setLayout(new BorderLayout());
        south.setLayout(new BorderLayout());

        JLabel cardNameLabel = new JLabel();
        cardNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        cardNameLabel.setText("Card Name Goes Here");
        cardNameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton drawButton = new JButton("Draw");
        drawButton.setPreferredSize(new Dimension(150, 75));

        JButton shuffleButton = new JButton("Shuffle");
        shuffleButton.setPreferredSize(new Dimension(150, 75));
        


        JPanel northernPanel = new JPanel();
        northernPanel.setLayout(new BorderLayout());
        northernPanel.add(cardNameLabel);

        JPanel southernPanel = new JPanel();
        southernPanel.add(drawButton);
        southernPanel.add(shuffleButton);

        

        south.add(southernPanel, BorderLayout.CENTER);
        north.add(northernPanel, BorderLayout.CENTER);



        this.setLayout(new BorderLayout());
        this.add(north, BorderLayout.NORTH);
        //this.add(east, BorderLayout.EAST); 
        this.add(central, BorderLayout.CENTER);
        //this.add(west, BorderLayout.WEST);
        this.add(south, BorderLayout.SOUTH);

        this.setVisible(true);
        
    }
}
