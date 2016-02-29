package edu.carrollcc.cis232;

import java.util.ArrayList;

public class Question4 {

	public static void main(String[] args) 
	{
		ArrayList<Ship> ships = new ArrayList<Ship>();
		ships.add(new CargoShip("Red October", "1986", 1000));
		ships.add(new CruiseShip("Freedom of the Seas", "2006", 3586));
		
		for (Ship ship : ships)
		{
			System.out.println(ship);
		}
	}
}
