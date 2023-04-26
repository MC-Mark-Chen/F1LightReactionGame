import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;


public class LightComponent extends JComponent 
{   
    //Outer circles
    public static Ellipse2D.Double outer1 = new Ellipse2D.Double(36, 178, 100, 100);
    public static Ellipse2D.Double outer2 = new Ellipse2D.Double(172, 178, 100, 100);
    public static Ellipse2D.Double outer3 = new Ellipse2D.Double(308, 178, 100, 100);
    public static Ellipse2D.Double outer4 = new Ellipse2D.Double(444, 178, 100, 100);
    public static Ellipse2D.Double outer5 = new Ellipse2D.Double(580, 178, 100, 100);

    //Inner off lights
    public static Ellipse2D.Double inner1 = new Ellipse2D.Double(46, 188, 80, 80);
    public static Ellipse2D.Double inner2 = new Ellipse2D.Double(182, 188, 80, 80);
    public static Ellipse2D.Double inner3 = new Ellipse2D.Double(318, 188, 80, 80);
    public static Ellipse2D.Double inner4 = new Ellipse2D.Double(454, 188, 80, 80);
    public static Ellipse2D.Double inner5 = new Ellipse2D.Double(590, 188, 80, 80);
}