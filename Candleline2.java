/*
	Chapter 11:	lab 11
	Programmer: Erica Cooper
	Date: 12/5/16
	Filename:	Candleline.java
	Purpose:	This program calculates cost of shipping candles
*/
import java.util.Scanner;
import java.util.*;
import java.text.DecimalFormat;

public class Candleline2
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("\tCandleLine - Candles Online");
		System.out.println(" ");


		double candleCost = getCandleCost();
		int shippingType = getShippingType();
		double shippingCost = getShippingCost(candleCost, shippingType);


		output(candleCost, shippingCost);

	}

public static double getCandleCost()
	{
		Scanner input = new Scanner(System.in);
		boolean done = false;
		String inputCost;
		double candleCost = 0;
		while(!done)
			{
				System.out.print("Enter the cost of the candle order: ");

				try
				{

					inputCost = input.next();
					candleCost = Double.parseDouble(inputCost);
					if (candleCost <=0) throw new NumberFormatException();
					done = true;
				}
				catch(NumberFormatException nfe)
				{
					System.out.println("Error, enter a dollar amount greater than 0");
					input.nextLine();
				}
			}
		return candleCost;
	}


	public static int getShippingType()
		{
			Scanner input = new Scanner(System.in);
			boolean done = false;
			String inputCost;
			int shippingCost = 0;
			while(!done)
				{
					System.out.println(" ");
					System.out.print("Enter the type of shipping: \n\t1) Priority(Overnight) \n\t2) Express (2 business days) \n\t3) Standard (3 to 7 business days) \nEnter type number: ");


					try
					{
						inputCost = input.next();
						shippingCost = Integer.parseInt(inputCost);
						if (shippingCost <=0 || shippingCost >= 4) throw new NumberFormatException();
						done = true;
					}
					catch(NumberFormatException nfe)
					{
						System.out.println(" ");
						System.out.println("Error, enter a 1, 2 or 3");
						input.nextLine();
					}
				}
			return shippingCost;
	}

	public static double getShippingCost(double candleCost, int shippingType)
	{
		double shippingCost = 0;


		if (shippingType == 1)
		{
			shippingCost = 16.95;
		}
		else if (shippingType == 2)
		{
			shippingCost = 13.95;
		}
		else if (shippingType == 3)
		{
			shippingCost = 7.95;
		}
		else if (candleCost >= 100 && shippingType == 3)
		{
			shippingCost = 0;
		}
		return shippingCost;
}

public static void output(double fCandleCost, double fShippingCost)
{
		Scanner input = new Scanner(System.in);
		DecimalFormat currency = new DecimalFormat("$#,###.00");
		System.out.println("");
		System.out.println("The candle cost of " + currency.format(fCandleCost) + " plus the shipping cost of " + currency.format(fShippingCost) + " equals " + currency.format(fCandleCost+fShippingCost));
}

}