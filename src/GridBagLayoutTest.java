import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GridBagLayoutTest extends JFrame {

    public GridBagLayoutTest(){
        super();
        this.setTitle("JVectorView");
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = this.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(new JLabel("Hello!"));
        content.add(new Controls());
        content.add(Box.createGlue());
        this.setVisible(true);
    }


    private class Controls extends JPanel{
        private static final int WIDTH = 3, HEIGHT = 3;

        public Controls(){
            GridBagConstraints constraints = new GridBagConstraints();

            //this.setBorder(BorderFactory.createLineBorder(Color.red));
            this.setBorder(BorderFactory.createTitledBorder("Some stuff"));
            constraints.fill = GridBagConstraints.NONE;
            this.setLayout(new GridBagLayout());
            for(int row = 0; row < HEIGHT; row++){
                for(int col = 0; col < WIDTH; col++){
                    constraints.gridx = col;
                    constraints.gridy = row;
                    this.add(new JButton("B"+(col+row*WIDTH)), constraints);

                }
            }
            constraints.gridx = 1;
            constraints.gridy = 3;
            this.add(new JButton("B"+(10)), constraints);
        }
    }

    public static void main(String[] args) {
        new GridBagLayoutTest();
    }

}
