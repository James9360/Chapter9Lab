package edu.carrollcc.cis232;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Question1 
{
	public static void main(String[] args) 
	{	
		Employee e = getInput();
		System.out.println(e);
	}
	
	/**
	 * Gets user input and calls the ProductionWorker constructor
	 * @return Returns a ProductionWorker object.
	 */
	public static ProductionWorker getInput()
	{
		Scanner keyboard = new Scanner (System.in);
		String name, staffId;
		int day, month, year, shift;
		double payRate;
		
		/*
		 * This code block gets the users name, ID, hire date, shift, and payrate.
		 */
		System.out.print("Enter your name: ");
		name = keyboard.nextLine();
		staffId = checkId(keyboard);
		System.out.print("Enter the day hired: ");
		day = keyboard.nextInt();
		System.out.print("Enter the month hired (0-11) 0 being Janurary: ");
		month = keyboard.nextInt();
		System.out.print("Enter the year hired: ");
		year = keyboard.nextInt();		
		shift = checkShift (keyboard);		
		System.out.print("Enter your payrate: ");
		payRate = keyboard.nextDouble();		
		
		/*
		 * This block sets up the date into a date object.
		 */
		Calendar c = GregorianCalendar.getInstance();
		c.set(year, month, day);
		Date date = c.getTime();
		return new ProductionWorker(name, staffId, date, shift, payRate);
	}
	
	/**
	 * Checks the id if it is in the correct format.
	 */
	public static String checkId(Scanner keyboard)
	{
		System.out.print("Enter a staffID ###-L (Letter between A-M): ");
		String staffId = keyboard.nextLine();
		for (int i = 0; i < staffId.length(); i++)
		{
			while (i >= 0 && i < 3)
			{
				if (!Character.isDigit(staffId.charAt(i)))
				{
					System.out.print("Invalid format, please try again.");
					staffId = keyboard.next();						
				}
				else
				{
					break;
				}
			}
			while (i == 3)
			{
				if (staffId.charAt(i) != '-')
				{
					System.out.print("Invalid format, please try again.");
					staffId = keyboard.next();					
				}
				else
				{
					break;
				}
			}
			while (i == staffId.length()-1)
			{
				if (!(staffId.charAt(i) >= 'A' && staffId.charAt(i) <= 'M'))
				{
					System.out.print("Invalid format, please try again.");
					staffId = keyboard.next();					
				}
				else
				{
					break;
				}
			}
		}
		return staffId;
	}
	
	public static int checkShift (Scanner keyboard)
	{
		int shift;
		System.out.print("Enter your shift (1 for day, 2 for night): ");
		shift = keyboard.nextInt();	
		while (shift <= 0 || shift > 2)
		{
			System.out.print ("Invalid shift number, please enter a valid shift number (1 for day, 2 for night): ");
			shift = keyboard.nextInt();
		}
		return shift;
	}
}
