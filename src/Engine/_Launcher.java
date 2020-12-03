package Engine;

import PizzaSource.Menu;
import PizzaSource.ScreenManager;

/* =============================================================================
 * Launcher launches the program. 
 * It asks the save manager to load any data it can find. See src/Utility/Save.
 * Then it initializes the frame. See src/_Main/Frame.
 * It's very simple and quick.
 * =============================================================================
*/

public class _Launcher {
	
	// Main.
	public static void main(String[] args) {
		Logging.info("Program launched with arguments " + Util.arrayToString(args, true));
		new Frame(args);
		Menu.initialize();
		ScreenManager.initialize();
	}
}
