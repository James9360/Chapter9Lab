# Lab 2: Chapter 9
**Due:** February 29th by 6:30 PM

## Question 1 (PC #1): `Employee` and `ProductionWorker` Classes.
Design a class named `Employee`. The class should keep the following information in fields:

	- `name`
	- `staffId` in the format XXX-L, where each X is a digit within the range 0-9 and the L is a letter within the range A-M.
	- `hireDate`

Write one or more constructors (including a no-arg constructor) and the appropriate getter and setter methods for the class.

Next, write a class named `ProductionWorker` that inherits from the `Employee` class. The `ProductionWorker` class should
have fields to hold the following information:

	- `shift` (an integer)
	- `hourlyPayRate` (a double)
	
The workday is divided into two shifts: day and night. The shift field will be an integer value representing the shift
that the employee works. The day shift is shift 1 and the night shift is shift 2. Write one or more constructors and the appropriate
getter and setter methods for the class. Demonstrate the classes by writing a program that uses a `ProductionWorker` object in the 
Question1 main method.

**Points breakdown**

- Technical: 10 points
- Style: 5 points
- Total: 15 points

## Question 2 (PC #2): `ShiftSupervisor` Class
In a particular factory a shift supervisor is a salaried employee who supervises a shift. In addition to a salary, the shift
supervisor earns a yearly bonus when his or her shift meets production goals. Design a `ShiftSupervisor` class that inherits from
the `Employee` class you created in Question 1. The `ShiftSupervisor` class should have a field that holds the annual salary
and a field that holds the annual production bonus that a shift supervisor has earned. Write one or more constructors 
(including a no-arg constructor) and appropriate accessor and mutator methods for the class. Demonstrate the class by writing a 
program that uses at least one `ShiftSupervisor` object in the Question2 main method.

**Points breakdown**

- Technical: 10 points
- Style: 5 points
- Total: 15 points

## Question 3 (PC #3): `TeamLeader` Class
In a particular factory, a team leader is an hourly paid production worker who leads a small team. In addition to hourly
pay, team leaders earn a fixed monthly bonus. Team leaders are required to attend a minimum number of hours of training per
year. Design a TeamLeader class that inherits from the `ProductionWorker` class you designed in Programming Challenge 1.
The `TeamLeader` class should have fields for the monthly bonus amount, the required number of training hours, and the
number of training hours that the team leader has attended. Write one or more constructors and the appropriate accessor
and mutator methods for the class. Demonstrate the class by writing a program that uses a `TeamLeader` object in the 
Question3 main method.

**Points breakdown**

- Technical: 10 points
- Style: 5 points
- Total: 15 points
 
## Question 4 (PC #10): `Ship`, `CruiseShip`, and `CargoShip` Classes
Design a `Ship` class that has at least the following members:
	- A field for the name of the ship (a string)
	- A field of the year that the ship was built (a string)
	- A constructor and appropriate accessors and mutators
	- A `toString` method that displays the ship's name and the year it was built

Design a `CruiseShip` class that extends the `Ship` class. The `CruiseShip` class should
have the following members:
	- A field for the maximum number of passengers (an int)
	- A constructor and appropriate accessors and mutators
	- A `toString` method that overrides teh `toString` method in the base class. The 
	`CruiseShip` class's `toString` method should display only the ships name and the maximum number of passengers.
	
Demonstrate the classes in a program that has a `Ship` array. Assign various `Ship`, `CruiseShip`, and `CargoShip`
objects to the array elements. The program should then step through the array, calling each object's `toString` method.

**Points breakdown**

- Technical: 20 points
- Style: 5 points
- Total: 25 points

----
### How to submit the lab
This section outlines how to get the lab on to your computer and how to submit it.

1. Fork the Chapter 9 lab repository
2. Import the project into Eclipse
	1. Click File->Import...
	2. Choose Git->Projects from Git
	3. Choose "Clone URI", press Next
	4. Copy the clone URI on **your forked** github repository (bottom right)
	5. Paste the URI into the Eclipse window
	6. Set your GitHub user name and password, leave everything else as it is.
	7. Press Next
	8. Choose Master on the "Branch Selection" screen and press Next
	9. Choose a local destination directory and press Next
	10. Select "Import existing Eclipse project" (should be default choice), press Next.
	11. Press Finish and your project is imported!
	12. Right click the project in the package explorer, click Maven->Update Project... (Or press Alt+F5)
3. Do the actual lab work
	1. Read/implement the Question 1 section above
	2. Keep all existing and new classes in the edu.carroll.cis232 package.
	3. Do not rename any existing files.
4. Test your work. (Unit Testing currently not available)
	1. Run the application by pressing the Play button to test your program manually.
5. Submit your work
	1. Right click the project
	2. Choose Team->Commit...
	3. Enter a comment such as "My solution for the chapter 9 lab"
	4. Enter your name/email for the author/committer fields if it is not set
	5. Press "Commit and Push". (Committing saves the changes locally, Pushing saves the changes on your GitHub fork)
	6. Your work is now on your GitHub fork.  Open up the browser to your GitHub fork of the example lab.
	7. Press the green pull request button at the top to the left of the "Branch: master" dropdown.
	8. To finally submit your lab, Click the green "Create new pull request" button, enter a title and message, and press "Create pull request".
	9. Your lab is now submitted!
