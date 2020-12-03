package PizzaSource;

/* ==================
 * Screen interface.
 * ==================
*/

import java.awt.Graphics;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import Engine.Constants;

public class Screen {
	
	public int screenID;
	public int[][] screenElements;

	/* =============================================================================
	 * Push method. Goes through all the screenElements and detects which one
	 * was pressed, if any.
	 * =============================================================================
	*/
	public void push(MouseEvent e) {
		for(int i = 0; i < screenElements.length; i++) {
			int[] element = screenElements[i];
			switch(element[0]) {
			case 0: // 0, plain text. no action.
			case 1: // 1, rectangle. no action.
				break;
			case 2: // 2, button leading to another screen.
				if (e.getX() >= element[1] && e.getX() <= element[1] + element[3] && e.getY() >= element[2] && e.getY() <= element[2] + element[4])
					ScreenManager.switchScreen(element[6]);
				break;
			case 3: // 3, image. no action.
				break;
			case 4: // 4, button that starts the order.
				if (e.getX() >= element[1] && e.getX() <= element[1] + element[3] && e.getY() >= element[2] && e.getY() <= element[2] + element[4]) {
					Order.currentOrder = new Order(element[5]);
					ScreenManager.switchScreen(2);
				}
				break;
			default:
				break;
			}
		}
	}
	
	
	/* =============================================================================
	 * Draw method. Goes through all the screenElements and draws them.
	 * =============================================================================
	*/
	public void draw(Graphics g) {
		for(int i = 0; i < screenElements.length; i++) {
			int[] element = screenElements[i];
			switch(element[0]) {
			case 0: // 0, plain text.
				g.setColor(Color.black);
				g.setFont(ScreenManager.fonts[element[4]]);
				if(element[3] < 100)
					g.drawString(Constants.GUI_TEXT[element[3]], element[1], element[2]);
				break;
			case 1: // 1, rectangle.
				g.setColor(new Color(element[5], element[6], element[7]));
				g.fillRect(element[1], element[2], element[3], element[4]);
				break;
			case 2: // 2, button leading to another screen.
				g.drawImage(ScreenManager.buttons[element[5]], element[1], element[2], element[3], element[4], null);
				g.setFont(ScreenManager.fonts[element[8]]);
				FontMetrics fm = g.getFontMetrics();
				g.drawString(Constants.GUI_TEXT[element[7]], element[1] + (int) ((element[3] - fm.stringWidth(Constants.GUI_TEXT[element[7]])) / 2), element[2] + (int) (element[4] / 2) + 10);
				break;
			case 3: // 3, image.
				g.drawImage(ScreenManager.images[element[5]], element[1], element[2], element[3], element[4], null); 
				break;
			case 4: // 4, button that starts the order.
				g.drawImage(ScreenManager.buttons[5], element[1], element[2], element[3], element[4], null);
				g.setFont(ScreenManager.fonts[1]);
				FontMetrics fm2 = g.getFontMetrics();
				g.drawString(Constants.GUI_TEXT[element[5] + 1], element[1] + (int) ((element[3] - fm2.stringWidth(Constants.GUI_TEXT[element[5] + 1])) / 2), element[2] + (int) (element[4] / 2) + 10);
				break;
			default:
				break;
			}
		}
	}
	
	
	// Method that notifies the screen that it is being switched away from/to.
	public void notifySwitchAway() {
		
	}
	
}
