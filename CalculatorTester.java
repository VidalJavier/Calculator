import javax.swing.*;

public class CalculatorTester{
	
  public static void main(String[]args){
    //Creates Main Frame
		JFrame mainWindow = new JFrame("Javier's Calculator");
		mainWindow.setResizable(false);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creates Panels
		JPanel mainPanel = new JPanel();
		CalculatorPanel panel = new CalculatorPanel();
		
		//Adds panel to main panel
		mainPanel.add(panel);
		mainWindow.getContentPane().add(panel);
		
		//makes it visible
		mainWindow.pack();
		mainWindow.setVisible(true);
	}
}
