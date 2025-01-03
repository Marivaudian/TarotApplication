import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class TarotFrame extends JFrame{

    public TarotFrame(){
        
        this.setTitle("Tarot Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 750);

        JPanel north = new JPanel();
        JPanel east = new JPanel();
        JPanel central = new JPanel();
        JPanel west = new JPanel();
        JPanel south = new JPanel();

        this.setLayout(new BorderLayout());
        this.add(north, BorderLayout.NORTH);
        this.add(east, BorderLayout.EAST);
        this.add(central, BorderLayout.CENTER);
        this.add(west, BorderLayout.WEST);
        this.add(south, BorderLayout.SOUTH);

        this.setVisible(true);
        
    }
}
