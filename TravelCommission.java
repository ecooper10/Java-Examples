/*
	Chapter 12:  Travel Commission
	Programmer: Erica Cooper
	Date: 11/19/2016
	Filename: TravelCommissionjava
	Purpose: exception handeling
*/

import javax.swing.JOptionPane;
import java.text.DecimalFormat;


public class TravelCommission
{
			public static void main(String[] args)
			{
				// declare and construct variables

				double dollars, answer;
				int empCode;

				// call methods

				dollars = getSales();
				empCode = getCode();
				answer = getComm(dollars,empCode);
				output(dollars, answer);
				finish();
		   }

	public static double getSales()
	{
	  //declare method variables
	  double dollars = 0;
	  boolean done = false;

	  // get amount for sales and error check
	  while(!done)
	  {
	  	String answer = JOptionPane.showInputDialog(null, "Enter the sales amount \n(do not use commas or dollar signs) \nor click Cancel to exit:");
		if (answer == null) finish();

		try
		{
			dollars = Double.parseDouble(answer);
			if (dollars <= 0) throw new NumberFormatException();
			done = true;
		}
		//error check
		catch (NumberFormatException ie)
		{
			JOptionPane.showMessageDialog(null, "   Error - Enter a number greater than 0","Error",JOptionPane.INFORMATION_MESSAGE);

		}


		}
		return dollars;
	}

	public static int getCode()
	{
	 //declare method varaibles
	 int empCode = 0;
	 boolean done = false;

	//get code to determine commission amount
	while(!done)
	{
		String answer = JOptionPane.showInputDialog(null, "Enter the commission code: \n1) Telephone Sales \n2) In-Store Sales \n3) Outside Sales");
		if (answer == null) finish();

		try
		{
			empCode = Integer.parseInt(answer);
			if (empCode < 1 || empCode > 3) throw new NumberFormatException();
			done = true;
		}

		catch (NumberFormatException ie)
		{
			JOptionPane.showMessageDialog(null, "  Please enter a 1, 2, or 3.","Error",JOptionPane.INFORMATION_MESSAGE);
		}


	}
		return empCode;
	}

	//calculate commission
	public static double getComm (double dollars, int empCode)
	{
	double answer = 0;

	if (empCode == 1)
	{
		answer = (dollars *.10);
	}
	if (empCode == 2)
	{
		answer = (dollars *.14);
	}
	if (empCode == 3)
	{
		answer = (dollars *.18);
	}

	return answer;
	}


	//output commission amount based off of empcode
	public static void output(double dDollars, double dAnswer)
	{
		DecimalFormat two = new DecimalFormat ("$#,###.00");
		JOptionPane.showMessageDialog(null, "Your commission on sales of " + two.format(dDollars) + " is " + two.format(dAnswer) + " . " ,"Commission Totals",JOptionPane.INFORMATION_MESSAGE);
	}



  //The finish() method ends the program.
 	public static void finish()
	{
		System.exit(0);
	}
}
