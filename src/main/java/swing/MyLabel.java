package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author keruzam
 *
 */
public class MyLabel extends JLabel {

	public MyLabel(String txt) {
		super();
		this.setText(txt);
		// label.setVerticalTextPosition(SwingConstants.TOP);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setForeground(Color.WHITE);
		// label.setBackground(Color.BLACK);
		this.setFont(new Font("Arial", Font.PLAIN, 18));
		this.setVisible(true);
		// label.setOpaque(false);
	}

}
