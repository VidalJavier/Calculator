package s.Calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel implements ActionListener{
	private JButton[] button;
    	private boolean[] math = {false, false, false};
	private int[] temp = {0,0};
	private String[] btn = {"7", "8", "9", "+",
				"4", "5", "6", "-",
				"1", "2", "3", "*",
				"0", "CE", "+/-", "="};
	
	public ButtonPanel(){
		//Design
		setLayout(new GridLayout(4,4));
		Dimension regDimension = new Dimension(50, 50); 
		
		//Initiates array
		button = new JButton[16];
		
		//Assigns text to buttons
		int r;
		for (r = 0; r <= 15; r++){
			button[r] = new JButton();
			button[r].setText(btn[r]);
			button[r].addActionListener(this);
		}
		
		//Resize buttons
		for(r = 0; r <= 15; r++){
			button[r].setPreferredSize(regDimension);
		}

		//Adds buttons
		for(r = 0; r <= 15; r++){
			this.add(button[r]);
		}
	}
	
	//gets result of numbers and functions entered into calculator
	public void result(){
		int result = 0;
		
		if(ScreenPanel.screen.getText().equals("")){
			temp[1] = temp[0];
		}else{
			temp[1] = Integer.parseInt(ScreenPanel.screen.getText());
		}
		
		if(math[0] == true){
			result = temp[0] + temp[1];
			math[0] = false;
		}else if(math[1] == true){
			result = temp[0] - temp[1];
			math[1] = false;
		}else if(math[2] == true){
			result = temp[0] * temp[1];
			math[2] = false;
		}
		ScreenPanel.screen.setText((Integer.toString(result)));
	}
	
	//clears calculator inputs
	public void clear(){
		ScreenPanel.screen.setText("");
		for(int r = 0; r <=2; r++){
			math[r] = false;
		}
	}
	
	public void signChange(){
		ScreenPanel.screen.setText(Integer.toString(-temp[0]));
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == button[0]){
			ScreenPanel.screen.append("7");
		}else if(event.getSource() == button[1]){
			ScreenPanel.screen.append("8");
		}else if(event.getSource() == button[2]){
			ScreenPanel.screen.append("9");
		}else if(event.getSource() == button[3] && !ScreenPanel.screen.getText().equals("")){		
			temp[0] = Integer.parseInt(ScreenPanel.screen.getText());
			math[0] = true;
			ScreenPanel.screen.setText("");
		}else if(event.getSource() == button[4]){
			ScreenPanel.screen.append("4");
		}else if(event.getSource() == button[5]){
			ScreenPanel.screen.append("5");
		}else if(event.getSource() == button[6]){
			ScreenPanel.screen.append("6");
		}else if(event.getSource() == button[7] && !ScreenPanel.screen.getText().equals("")){
			temp[0] = Integer.parseInt(ScreenPanel.screen.getText());
			math[1] = true;
			ScreenPanel.screen.setText("");
		}else if(event.getSource() == button[8]){
			ScreenPanel.screen.append("1");
		}else if(event.getSource() == button[9]){
			ScreenPanel.screen.append("2");
		}else if(event.getSource() == button[10]){
			ScreenPanel.screen.append("3");
		}else if(event.getSource() == button[11] && !ScreenPanel.screen.getText().equals("")){
			temp[0] = Integer.parseInt(ScreenPanel.screen.getText());
			math[2] = true;
			ScreenPanel.screen.setText("");
		}else if(event.getSource() == button[12] && !ScreenPanel.screen.getText().equals("")){
			ScreenPanel.screen.append("0");
		}else if(event.getSource() == button[13]){
			clear();
		}else if(event.getSource() == button[14] && !ScreenPanel.screen.getText().equals("")){
			temp[0] = Integer.parseInt(ScreenPanel.screen.getText());
			signChange();
		}else if(event.getSource() == button[15] && !ScreenPanel.screen.getText().equals("")){
			 result();
		}
	}
}
