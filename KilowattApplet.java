/*
Erica Cooper
10/10/16
Kilowatt Applet
Applet understanding

*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class KilowattApplet extends Applet implements ActionListener
{
		// declare variables and set up decimal formatting
		double costOfKilowatt, hours, index;
		DecimalFormat two = new DecimalFormat ("$#,###.00");

		//construct components
		Label companyLabel = new Label("Welcome to the Appliance Energy Calculator");
		Label costPerKilowatt = new Label("Please enter the cost per kilowatt-hour:");
			TextField kilowattField = new TextField(5);
		Label hoursConsumed = new Label("Please enter the kilowatt-hours consumed: ");
			TextField hoursField = new TextField(5);
		Button calcButton = new Button("Calculate");
		Label outputLabel = new Label("Click the Calculate button to display the monthly energy cost.");

		public void init()
		{

			setBackground(Color.yellow);
			setForeground(Color.red);
			add(companyLabel);
			add(costPerKilowatt);
			add(kilowattField);
			add(hoursConsumed);
			add(hoursField);
			add(calcButton);
			calcButton.addActionListener(this);
			add(outputLabel);

		}

		public void actionPerformed(ActionEvent e)
		{

			costOfKilowatt = Double.parseDouble(kilowattField.getText());
			hours = Double.parseDouble(hoursField.getText());
			//calculate
			index = costOfKilowatt * hours;
			// output
			outputLabel.setText("The monthly cost to operate this appliance is " + two.format(index) + ".");
		}


}