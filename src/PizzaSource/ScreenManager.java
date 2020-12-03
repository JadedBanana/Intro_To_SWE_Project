package PizzaSource;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import Engine.Panel;

/* ===============================================
 * ScreenManager manages screens.
 * Big surprise!
 * ===============================================
*/

public class ScreenManager {
	
	// Variables.
	public static int activeScreenID;
	private static Screen[] screens;
	public static boolean initComplete = false;
	public static BufferedImage[] buttons;
	public static BufferedImage[] images;
	public static Font[] fonts;
	
	
	/* ==================================================================================================================================
	 * Initializes the ScreenManager.
	 * Somewhat hardcoded to set up menu structure.
	 * Ideal future (post-requirements) improvements would make the entire menu structure 
	 * able to be read from an external file and therefore edited more easily.
	 * Menu elements are coded according to integers.
	 * The first int is always the element type.
	 * The second through fifth ints are the position and size, accordingly.
	 * Any other ints are element-specific.
	 * 0: Text (WIDTH points to either a menu item or the GUI TEXT LIST in the constants class, HEIGHT points to a font)
	 * 1. Plain Rectangle (following ints will specify a color)
	 * 2. Button to change screens (following int first specifies button style and then screen ID)
	 * 3. Image (following int points to the specific image)
	 * 4. Button to create order and change screens (following int specifies what kind of order it is)
	 * 5. Current Order Window
	 * =================================================================================================================================
	*/
	public static void initialize() {
		// Time to make screens.
		int screenCount = 0;
		// First is the landing screen. It has a rectangle, a few buttons, graphics, and some text.
		Screen landingScreen = new Screen();
		landingScreen.screenElements = new int[][]{ 
			new int[]{ 1, 0, 0, 720, 540, 240, 240, 240 },
			new int[]{ 1, 0, 0, 720, 100, 254, 165, 0 },
			new int[]{ 0, 30, 65, 0, 0 },
			new int[]{ 3, 560, 5, 105, 90, 3 },
			new int[]{ 4, 100, 200, 520, 70, 0 },
			new int[]{ 4, 100, 300, 520, 70, 1 },
			new int[]{ 0, 290, 500, 3, 2 },
			new int[]{ 2, 10, 490, 200, 50, 1, 1, 4, 2},
		};
		landingScreen.screenID = screenCount++;
		// Second is the screen that comes up after clicking manager login. Says feature not implemented.
		Screen managerScreen = new Screen();
		managerScreen.screenElements = new int[][]{ 
			new int[]{ 1, 0, 0, 720, 540, 240, 240, 240 },
			new int[]{ 1, 0, 0, 720, 100, 254, 165, 0 },
			new int[]{ 0, 30, 65, 0, 0 },
			new int[]{ 3, 560, 5, 105, 90, 3 },
			new int[]{ 0, 30, 65, 0, 0 },
			new int[]{ 0, 140, 280, 5, 3 },
			new int[]{ 2, 10, 490, 200, 50, 0, 0, 6, 2},
		};
		managerScreen.screenID = screenCount++;
		// Third is the main screen menu thing.
		// Put all the screens into the screens list.
		screens = new Screen[screenCount];
		screenCount = 0;
		screens[screenCount++] = landingScreen;
		screens[screenCount++] = managerScreen;
		// All screens implemented. Next, load button icons and images.
		buttons = new BufferedImage[9];
		images = new BufferedImage[4];
		try {
			buttons[0] = ImageIO.read(ScreenManager.class.getResource("/Back Button Background.png"));
			buttons[1] = ImageIO.read(ScreenManager.class.getResource("/Customer Information Background.png"));
			buttons[2] = ImageIO.read(ScreenManager.class.getResource("/Deep Half-Rounded Rectangle.png"));
			buttons[3] = ImageIO.read(ScreenManager.class.getResource("/Deep Reflected Half-Rounded Rectangle.png"));
			buttons[4] = ImageIO.read(ScreenManager.class.getResource("/Half-Rounded Rectangle.png"));
			buttons[5] = ImageIO.read(ScreenManager.class.getResource("/Oval Background.png"));
			buttons[6] = ImageIO.read(ScreenManager.class.getResource("/Pay Button Background.png"));
			buttons[7] = ImageIO.read(ScreenManager.class.getResource("/Reflected Half-Rounded Rectangle.png"));
			buttons[8] = ImageIO.read(ScreenManager.class.getResource("/Rounded Rectangle.png"));
			images[0] = ImageIO.read(ScreenManager.class.getResource("/Whole Pizza.png"));
			images[1] = ImageIO.read(ScreenManager.class.getResource("/Left Half Pizza.png"));
			images[2] = ImageIO.read(ScreenManager.class.getResource("/Right Half Pizza.png"));
			images[3] = ImageIO.read(ScreenManager.class.getResource("/pizzaicon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Plus fonts! Don't forget fonts.
		fonts = new Font[] {
			new Font("Georgia", 0, 50),	
			new Font("Arial", 0, 35),	
			new Font("Arial", 0, 25),
			new Font("Arial", 0, 40)
		};
		// Init complete.
		initComplete = true;
		Panel.panel.repaint();
	}
	
	
	/* =============================================================================
	 * Switch method. Takes an order from a screen to switch to a different screen.
	 * Will only ever be called by Screens themselves.
	 * Notifies the switched screen once it has been led away.
	 * =============================================================================
	*/
	public static void switchScreen(int toID) {
		screens[activeScreenID].notifySwitchAway();
		activeScreenID = toID;
		Panel.panel.repaint();
	}

	
	/* ============================================================================
	 * Input method. Essentially only passes the input along to the active screen.
	 * ============================================================================
	*/
	public static void push(MouseEvent e) { if(initComplete) screens[activeScreenID].push(e); }
	
	
	/* =================================================================
	 * Draw method. Simply calls the same method in the current screen.
	 * All drawing is handled by the subscreen.
	 * =================================================================
	*/
	public static void draw(Graphics g) { 
		if(initComplete) 
			screens[activeScreenID].draw(g); 
		else 
			return;
	}

}
