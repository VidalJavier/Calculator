package s.Calculator;

import java.awt.*;
import javax.swing.*;

public class ScreenPanel extends JPanel{
	public static JTextArea screen;
	
	public ScreenPanel(){
		screen = new JTextArea(10,20);
		screen.setEditable(false);
		screen.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		//Adds panel
		this.add(screen);
	}

	public void setText(String string) {
		screen.setText(string);	
	}
}
