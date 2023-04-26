import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class LightOnComponent2 extends LightComponent
{
  public void paintComponent(Graphics g) 
  {
    Graphics2D g2 = (Graphics2D) g;
    
    //Outer circles
    g2.setColor(Color.BLACK);
    g2.fill(outer1);
    g2.fill(outer2);
    g2.fill(outer3);
    g2.fill(outer4);
    g2.fill(outer5);
    
    //Inner on lights
    g2.setColor(Color.RED);
    g2.fill(inner1);
    g2.fill(inner2);
    
    //Inner off lights
    g2.setColor(Color.WHITE);
    g2.fill(inner3);
    g2.fill(inner4);
    g2.fill(inner5);

    //Instruction text
    g2.setColor(Color.BLACK);
    g2.drawString("Press Space When Lights Go Out", 260, 381);
  }
}