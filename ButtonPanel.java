package s.Calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel implements ActionListener{
	
	private Stack<Float> num = new Stack<Float>();
	private Stack<Character> oper = new Stack<Character>();
	private JButton[] button;
	private String[] btn = {"7", "8", "9", "+",
							"4", "5", "6", "-",
							"1", "2", "3", "*",
							"0", "CE", "+/-", "/",
							"", "", "", "="};
	
	public ButtonPanel(){
		//Design
		setLayout(new GridLayout(5,5));
		Dimension regDimension = new Dimension(10, 10); 
		
		//Initiates array
		button = new JButton[20];
		
		//Assigns text to buttons
		int r;
		for (r = 0; r < 20; r++){
			button[r] = new JButton();
			button[r].setText(btn[r]);
			button[r].addActionListener(this);
		}
		
		//Resize buttons
		for(r = 0; r < 20; r++){
			button[r].setPreferredSize(regDimension);
		}

		//Adds buttons
		for(r = 0; r < 20; r++){
			this.add(button[r]);
		}
	}
	
	//gets result of numbers and functions entered into calculator
	public void result(){
		float temp_float1 = 0;
		float temp_float2 = 0;
		char temp_oper;
		while(num.size() > 1){
			if(num.size() == 2){
				temp_float1 = num.pop();
				switch(oper.pop()){
					case '+':
						num.push(num.pop() + temp_float1);
						break;
					case '-':
						num.push(num.pop() - temp_float1);
						break;
					case '*':
						num.push(num.pop() * temp_float1);
						break;
					case '/':
						num.push(num.pop() / temp_float1);
						break;
				}
			}else{
				temp_float1 = num.pop();
				temp_float2 = num.pop();
				temp_oper = oper.pop();
				if(temp_oper == '+' || temp_oper == '-'){
					switch(oper.pop()){
						case '+':
							num.push(num.pop() + temp_float2);
							num.push(temp_float1);
							oper.push(temp_oper);
							break;
						case '-':
							num.push(num.pop() - temp_float2);
							num.push(temp_float1);
							oper.push(temp_oper);
							break;
						case '*':
							num.push(num.pop() * temp_float2);
							num.push(temp_float1);
							oper.push(temp_oper);
							break;
						case '/':
							num.push(num.pop() / temp_float2);
							num.push(temp_float1);
							oper.push(temp_oper);
							break;
					}
				}else if(oper.peek() == '*' || oper.peek() == '/'){
					switch(oper.pop()){
						case '*': 
							num.push(num.pop() * temp_float2);
							num.push(temp_float1);
							oper.push(temp_oper);
							break;
						case '/': 
							num.push(num.pop() / temp_float2);
							num.push(temp_float1);
							oper.push(temp_oper);
							break;
					}
				}else{
					switch(temp_oper)
					{
						case '*': 
							num.push(temp_float2 * temp_float1);
							break;
						case '/': 
							num.push(temp_float2 / temp_float1);
							break;
					}
				}
			}
		}
		
		ScreenPanel.screen.setText((Float.toString(num.pop())));
	}
	
	public void signChange(){
		float temp = num.pop() * -1;
		num.push(temp);
		ScreenPanel.screen.setText((Float.toString(temp)));
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == button[0]){
			ScreenPanel.screen.append("7");
			num.push((float) 7);
		}else if(event.getSource() == button[1]){
			ScreenPanel.screen.append("8");
			num.push((float) 8);
		}else if(event.getSource() == button[2]){
			ScreenPanel.screen.append("9");
			num.push((float) 9);
		}else if(event.getSource() == button[3] && !ScreenPanel.screen.getText().equals("")){
			ScreenPanel.screen.setText("");
			oper.push('+');
		}else if(event.getSource() == button[4]){
			ScreenPanel.screen.append("4");
			num.push((float) 4);
		}else if(event.getSource() == button[5]){
			ScreenPanel.screen.append("5");
			num.push((float) 5);
		}else if(event.getSource() == button[6]){
			ScreenPanel.screen.append("6");
			num.push((float) 6);
		}else if(event.getSource() == button[7] && !ScreenPanel.screen.getText().equals("")){
			ScreenPanel.screen.setText("");
			oper.push('-');
		}else if(event.getSource() == button[8]){
			ScreenPanel.screen.append("1");
			num.push((float) 1);
		}else if(event.getSource() == button[9]){
			ScreenPanel.screen.append("2");
			num.push((float) 2);
		}else if(event.getSource() == button[10]){
			ScreenPanel.screen.append("3");
			num.push((float) 3);
		}else if(event.getSource() == button[11] && !ScreenPanel.screen.getText().equals("")){
			ScreenPanel.screen.setText("");
			oper.push('*');
		}else if(event.getSource() == button[12] && !ScreenPanel.screen.getText().equals("")){
			ScreenPanel.screen.append("0");
			num.push((float) 0);
		}else if(event.getSource() == button[13]){
			ScreenPanel.screen.setText("");
			num.clear();
			oper.clear();
		}else if(event.getSource() == button[14] && !ScreenPanel.screen.getText().equals("")){
			signChange();
		}else if(event.getSource() == button[15] && !ScreenPanel.screen.getText().equals("")){
			ScreenPanel.screen.setText("");
			oper.push('/');
		}else if(event.getSource() == button[19] && !ScreenPanel.screen.getText().equals("")){
			result();
		}
	}
}
