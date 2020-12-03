package Engine;

/* =======================================
 * Constants used throughout the program.
 * Can be changed to the user's liking.
 * =======================================
*/

import java.awt.Font;
import java.time.format.DateTimeFormatter;

public class Constants {
	
	
	// JSON constants.
	public static final String NUMBERS = "0123456789.-";
	
	
	// Logging constants.
	public static DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
	
	
	// Frame constants.
	public static final String WINDOW_TITLE = "Sprint 3 Test";
	public static final boolean RESIZABLE = false;
	public static final short DEFAULT_WIDTH = 720;
	public static final short DEFAULT_HEIGHT = 540;
	
	
	// Input constants.
	// These were made for the engine specifically, so these input codes are never actually used in the program, nor is debug mode.
	public static final byte[] UP_KEY_CODES = {38, 87, 104};
	public static final byte[] LEFT_KEY_CODES = {37, 65, 100};
	public static final byte[] DOWN_KEY_CODES = {40, 83, 98};
	public static final byte[] RIGHT_KEY_CODES = {39, 68, 102};
	public static final byte[] SELECT_KEY_CODES = {8, 27, 67};
	public static final byte[] BACK_KEY_CODES = {10, 32, 88};
	// Toggles debug stuff when debug mode is on.
	public static final byte DEBUG_KEY_CODE = 114;
	// Debug font and fontMetrics.
	public static final Font DEBUG_FONT = new Font("Courier New", 0, 14);
	
	
	// TestScreen constants.
	public static final String TEST_SCREEN_JSON_PATH = "/testScreen.json";
	public static final String TEST_IMAGE_PATH = "/diddyKongInVietnam.png";
	
	
	// Menu constants.
	public static final String MENU_JSON_PATH = "/menu.json";
	
	// List of all menu text.
	public static final String[] GUI_TEXT = {
		"Mom and Pop's Pizza",
		"Carry Out",
		"Delivery",
		"Location: NULL",
		"Manager Login",
		"Feature not implemented",
		"Back",
		"Current Order",
		"Total: $",
		"Pizza",
		"Pan Style",
		"Toppings",
		"Go to Payment",
		"Demo Complete",
		"Save Log File"
	};
	
}
