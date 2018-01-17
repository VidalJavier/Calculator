package s.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorPanel extends JPanel{
	private ButtonPanel btn_pnl;
	private ScreenPanel display;
	
	public CalculatorPanel(){
		//Design
		setLayout(new GridLayout(2,1));
		
		//Creates Panels
		display = new ScreenPanel();
		btn_pnl = new ButtonPanel();
		
		//Adds Panels
		this.add(display);
		this.add(btn_pnl);
	}
}
