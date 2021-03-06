import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel that contains the controls and indicators for the drawing editor
 * 
 * @author gcschmit
 * @version 23 June 2015
 */
public class ControlPanel extends JPanel
{
    private JButton pick;
    private JButton addc;
    private JButton adds;
    private JPanel panel;
    private DrawingPanel canvas;

    /**
     * Constructor for objects of class ControlPanel
     */
    public ControlPanel( DrawingPanel canvas)
    {
        this.canvas = canvas;
        //
        // Creates buttons and selected color panel
        this.pick = new JButton("Pick Color");
        this.panel = new JPanel();
        this.panel.setBackground(this.canvas.getColor());
        this.addc = new JButton("Add Circle");
        this.adds = new JButton("Add Square");
        // Adds  buttons and selected color panel
        this.add(this.pick);
        this.add(this.panel);
        this.add(this.addc);
        this.add(this.adds);
        //Listener created and added to buttons
        ClickListener clicked = new ClickListener();
        this.pick.addActionListener(clicked);
        this.addc.addActionListener(clicked);
        this.adds.addActionListener(clicked);
        

    }
    // ... create inner class that implements the ActionListener interface to respond to button clicks
    public class ClickListener implements ActionListener
    {
        //Initializes listeners
        public void actionPerformed(ActionEvent event)
        {
            // Changes the color of the shape
            if(event.getSource() == pick)
            {
                canvas.pickColor();
                panel.setBackground(canvas.getColor());
            }
            // Adds a circle object
            else if(event.getSource() == addc)
            {
                canvas.addCircle();
                canvas.repaint();
            }
            // Adds a square object
            else if(event.getSource() == adds)
            {
                canvas.addSquare();
                canvas.repaint();
            }
        }
    }
    //
}
