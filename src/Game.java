import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.awt.event.KeyEvent;


public class Game extends JFrame implements KeyListener 
{
	//Frame initialization
	private static JFrame frame = new JFrame();
	private static JLabel label;
    private static JPanel panel = new JPanel();

	//Class initializations
	private static Random random = new Random();
	private static LightComponent[] lc = new LightComponent[6];

	//Variable initializations
	private static final int LIGHT_OFF_TIME_UPPERBOUND = 50;				//Random class upperbound: 50 seconds
	private static final int LIGHT_OFF_TIME_LOWERBOUND = 10;				//Random class lowerbound: 10 seconds
	private static long lightOffTime = 0;									//Record the time when all the lights are turned off
	private static long pressTime = 0;										//Record the time when the player press space
    private static int index = 0;											//The index for the while loop
    private static boolean finishStatus = false;							//Used to pause the program when the space is pressed
	public static String endString = "";									//Displaying "Jump Start" or the time

    Game()
	{
		//Frame initialization
		frame.setSize(721, 484);
		frame.setTitle("Start Light");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);											//Add KeyListener method to the JFrame

		//Class initializations
		lc[0] = new LightOffComponent();									//All lights off
		lc[1] = new LightOnComponent1();									//One lights on
		lc[2] = new LightOnComponent2();									//Two lights on
		lc[3] = new LightOnComponent3();									//Three lights on
		lc[4] = new LightOnComponent4();									//Four lights on
		lc[5] = new LightOnComponent5();									//Five lights on
	}

	public void begin()
    {
		while(index < 6)
        {
			if (index > 0)                                                  //For all stages except when all the lights are off
            {										
				frame.remove(lc[index - 1]);						        //Remove the previous class
			}
			frame.add(lc[index]);									        //Add the next class
			frame.setVisible(true);
			if (index < 5)                                                  //For all stages except when all the lights are on
            {										
				try 
                {
					Thread.sleep(1500);					            		//Pause for 1.5 seconds between every light
				}
                catch (InterruptedException e) 
                {
					e.printStackTrace();
				}
			}
            index++;
		}
		try 
        {																	//Pause for random seconds before turning off all the lights
			Thread.sleep((random.nextInt(LIGHT_OFF_TIME_UPPERBOUND - LIGHT_OFF_TIME_LOWERBOUND) + LIGHT_OFF_TIME_LOWERBOUND) * 100);
		}
		catch (InterruptedException e) 
        {
			e.printStackTrace();
		}
		frame.remove(lc[5]);
		lightOffTime = System.nanoTime();
		frame.add(new LightOffComponent());									//Turn off all the lights
		frame.setVisible(true);
	}

    @Override
    public void keyPressed(KeyEvent e) 
	{
        if(e.getKeyCode() == KeyEvent.VK_SPACE && !finishStatus)			//If the space is pressed, and it isn't't pressed it before
        {
            pressTime = System.nanoTime();
            if(lightOffTime == 0)											//If the space is pressed before all the lights are off
            {
				endString = "Jump Start";									//endString displays "Jump Start"
                frame.remove(lc[index]);
                index = 6;													//to end the while loop in the begin method
            }
            else
            {																//endString displays the time interval
				endString = Double.toString((pressTime - lightOffTime) / 1000000000.0).substring(0, 5) + " Seconds";
            }
			label = new JLabel(endString);
			label.setFont(new Font("Calibri", Font.PLAIN,50));
			panel.add(label);												//Use JPanel to centered the endString text
			frame.add(panel);
			frame.setVisible(true);
			finishStatus = true;											//to end the if statement of the keyPressed method
        }
    }

	@Override
	public void keyTyped(KeyEvent e) 
    {
	}

	@Override
	public void keyReleased(KeyEvent e) 
    {
	}
}