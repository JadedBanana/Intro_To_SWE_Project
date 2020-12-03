package Engine;

/* ============================================================
 * Input is the input manager.
 * Mouse movements and keyboard strokes all head through here.
 * ============================================================
*/

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import PizzaSource.ScreenManager;

public class Input {	
	
	// Simple setup.
	public Input(Panel panel) {
		PanelInput input = new PanelInput();
		panel.addMouseListener(input);
	}
	
	/* =========================================================================
	 * Input methods.
	 * Usually, more than just one of these would be implemented, but this demo
	 * exclusively takes mouse input, so there is no need to.
	 * =========================================================================
	*/
	public class PanelInput implements MouseListener {

		public void mouseClicked(MouseEvent e) { ScreenManager.push(e); }
		public void mousePressed(MouseEvent e) { }
		public void mouseReleased(MouseEvent e) { }		
		public void mouseEntered(MouseEvent e) { }		
		public void mouseExited(MouseEvent e) { }
	}
	
}
