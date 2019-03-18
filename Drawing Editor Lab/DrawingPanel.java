import javax.swing.JColorChooser;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D.Double;
import java.awt.geom.Point2D;
/**
 * The panel in which draws all of the shapes in the drawing editor
 * 
 * @author gcschmit
 * @version 23 June 2015
 */
public class DrawingPanel extends JPanel
{
    private Color fillColor;
    private ArrayList<DrawingShape> shapes;
    private Point2D.Double point;
    private Dimension size;
    private DrawingShape selected;
    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DrawingPanel()
    {
        MouseListener listener = new MouseClickListener();
        MouseMotionListener mlistener = new MouseMovedListener();
        this.addMouseListener(listener);
        this.addMouseMotionListener(mlistener);
        shapes = new ArrayList<DrawingShape>();
        point = new Point2D.Double((size.getHeight()/2),(size.getWidth()/2));
    }

    /**
     * Invoked when the "Pick Color" button is clicked. Displays a JColorChooser and sets the
     *  selected color as the new fill color. Leaves the fill color unchanged if the user clicks
     *  "Cancel"
     *
     */
    public void pickColor()
    {
        Color selectedColor = JColorChooser.showDialog( this, "select the fill color", this.fillColor );

        if( selectedColor != null )
        {
            this.fillColor = selectedColor;
        }
    }

    public Color getColor()
    {
        return fillColor;
    }

    public Dimension getPreferredSize()
    {
        Dimension newSize = new Dimension(500, 500);
        newSize = size;
        return size;
    }

    public void addCircle()
    {
        shapes.add(new Circle(point, Math.random() * 24 + 1,fillColor));
        selected = shapes.get(shapes.size() - 1);
    }

    public void addSquare()
    {
        shapes.add(new Square(point, Math.random() * 24 + 1,fillColor));
        selected = shapes.get(shapes.size() - 1);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(DrawingShape shape : shapes)
        {
            shape.draw(g2 , true);
            if(shape == selected)
            {
                shape.draw(g2 , false);
            }
        }
    }

    public class MouseClickListener implements MouseListener
    {
        public void mouseClicked(MouseEvent event)
        {
        }

        public void mouseEntered(MouseEvent event)
        {
        }

        public void mouseExited(MouseEvent event)
        {
        }

        public void mousePressed(MouseEvent event)
        {
            //
        }

        public void mouseReleased(MouseEvent event)
        {
        }
    }
    public class MouseMovedListener implements MouseMotionListener
    {
        public void mouseMoved(MouseEvent event)
        {
        }

        public void mouseDragged(MouseEvent event)
        {
            //
        }
    }
}
