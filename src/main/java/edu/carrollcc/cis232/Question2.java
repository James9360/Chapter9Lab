package edu.carrollcc.cis232;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Question2 
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
	public static ShiftSupervisor getInput()
	{
		Scanner keyboard = new Scanner (System.in);
		String name, staffId;
		int day, month, year;
		double annualSalary, bonus;
		
		/*
		 * This code block gets the users name, ID, hire date, shift, and pay rate.
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
		System.out.print("Enter your annual salary: ");
		annualSalary = keyboard.nextInt();		
		System.out.print("Enter your bonus: ");
		bonus = keyboard.nextDouble();		
		
		/*
		 * This block sets up the date into a date object.
		 */
		Calendar c = GregorianCalendar.getInstance();
		c.set(year, month, day);
		Date date = c.getTime();
		return new ShiftSupervisor(name, staffId, date, annualSalary, bonus);
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
}
