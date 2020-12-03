package Engine;

/* =====================================================
 * Frame is essentially the window the program runs in.
 * It is the window, but not the contents inside.
 * =====================================================
*/

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	
	// Self-referencing variable, allows this to be pulled from anywhere with minimal issue.
	public static Frame frame;
	
	// Current frame size. Set to the constant value first.
	public static int frameWidth = Constants.DEFAULT_WIDTH;
	public static int frameHeight = Constants.DEFAULT_HEIGHT;
	
	
	// Constructor.
	public Frame(String[] args) {
		// Adds the panel to the frame.
		Logging.debug("Setting up frame...");
		add(new Panel(this));
		frame = this;
		
		// Customizes the window to the game's specifications.
		setResizable(Constants.RESIZABLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(frameWidth + this.getInsets().right + this.getInsets().left, frameHeight + this.getInsets().top + this.getInsets().bottom);
	}
	
}
