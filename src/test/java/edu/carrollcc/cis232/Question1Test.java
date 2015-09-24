package edu.carrollcc.cis232;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class Question1Test {
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();

	@Test
	public void testCourseGradesExists() {
		try {
			Class<?> grades = Class.forName("edu.carrollcc.cis232.CourseGrades");
			assertNotNull("CourseGrades class does not exist", grades);
		} catch (ClassNotFoundException e) {
			fail("CourseGrades does not exist!");
		}
	}

	@Test
	public void testCourseGradesImplementsAnalyzable() {
		try {
			Class<?> grades = Class.forName("edu.carrollcc.cis232.CourseGrades");
			assertTrue("CourseGrades must implement Analyzable", Analyzable.class.isAssignableFrom(grades));
		} catch (ClassNotFoundException e) {
			fail("CourseGrades does not exist!");
		}
	}

	@Test
	public void testCourseGradesHasGradesArrayList() {
		try {
			Class<?> courseGrades = Class.forName("edu.carrollcc.cis232.CourseGrades");
			Field grades = courseGrades.getDeclaredField("grades");
			assertTrue("grades field must be an ArrayList of GradedActivity",
					ArrayList.class.isAssignableFrom(grades.getType()));
			ParameterizedType type = (ParameterizedType) grades.getGenericType();
			assertTrue("grades field must be an ArrayList of GradedActivity",
					GradedActivity.class.getName().equals(type.getActualTypeArguments()[0].getTypeName()));
		} catch (ClassNotFoundException e) {
			fail("CourseGrades does not exist!");
		} catch (NoSuchFieldException e) {
			fail("CourseGrades does not have grades ArrayList field");
		}
	}

	@Test
	public void testCourseGradesHasAddGradeMethod() {
		try {
			Class<?> courseGrades = Class.forName("edu.carrollcc.cis232.CourseGrades");
			assertNotNull(courseGrades.getMethod("addGrade", GradedActivity.class));
		} catch (ClassNotFoundException e) {
			fail("CourseGrades does not exist!");
		} catch (NoSuchMethodException e) {
			fail("CourseGrades is missing addGrade method that has GradedActitivity parameter");
		}
	}

	@Test
	public void testGradedActivityHasFieldsFromUML() {
		try {
			GradedActivity.class.getDeclaredField("name");
			GradedActivity.class.getDeclaredField("earnedPoints");
			GradedActivity.class.getDeclaredField("maxPoints");
		} catch (NoSuchFieldException e) {
			fail("GradedActivity does not have at least the fields specified in the UML");
		}
	}

	@Test
	public void testGradedActivityHasMethodsFromUML() {
		try {
			GradedActivity.class.getMethod("getName");
			GradedActivity.class.getMethod("setName", String.class);
			GradedActivity.class.getMethod("setEarnedPoints", double.class);
			GradedActivity.class.getMethod("getEarnedPoints");
			GradedActivity.class.getMethod("setMaxPoints", double.class);
			GradedActivity.class.getMethod("getMaxPoints");
			GradedActivity.class.getMethod("getPercentage");
			GradedActivity.class.getMethod("getGrade");
		} catch (NoSuchMethodException e) {
			fail("GradedActivity is missing methods specified in the UML");
		}
	}

	@Test
	public void testGetLowestGrade() {
		try {
			Class<?> courseGradesClass = Class.forName("edu.carrollcc.cis232.CourseGrades");
			Object courseGrade = courseGradesClass.newInstance();
			Method addGrade = courseGradesClass.getMethod("addGrade", GradedActivity.class);
			GradedActivity lowest = getGradedActivity("Lowest", 10, 100);
			
			addGrade.invoke(courseGrade, getGradedActivity("Not lowest", 11, 100));
			addGrade.invoke(courseGrade, getGradedActivity("Not lowest #2", 12, 100));
			addGrade.invoke(courseGrade, getGradedActivity("Not lowest #3", 1, 10));
			addGrade.invoke(courseGrade, lowest);
			addGrade.invoke(courseGrade, getGradedActivity("Not lowest #4", 5, 10));
			
			Method getLowest = courseGradesClass.getMethod("getLowestGrade");
			assertEquals("Lowest grade not retrieved from getLowestGrade method", lowest, getLowest.invoke(courseGrade));
		} catch (ClassNotFoundException e) {
			fail("CourseGrades does not exist!");
		} catch (InstantiationException e) {
			fail("CourseGrades must have a no-arg constructor");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			fail("CourseGrades missing addGrade method or Analyzable methods");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			fail("CourseGrades addGrade method not accepting GradedActivity class");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetHighestGrade() {
		try {
			Class<?> courseGradesClass = Class.forName("edu.carrollcc.cis232.CourseGrades");
			Object courseGrade = courseGradesClass.newInstance();
			Method addGrade = courseGradesClass.getMethod("addGrade", GradedActivity.class);
			GradedActivity highest = getGradedActivity("Highest", 900, 1000);
			
			addGrade.invoke(courseGrade, getGradedActivity("Not Highest", 9, 10));
			addGrade.invoke(courseGrade, getGradedActivity("Not Highest #2", 90, 100));
			addGrade.invoke(courseGrade, getGradedActivity("Not Highest #3", 8, 10));
			addGrade.invoke(courseGrade, highest);
			addGrade.invoke(courseGrade, getGradedActivity("Not Highest #4", 7, 10));
			
			Method getHighest = courseGradesClass.getMethod("getHighestGrade");
			assertEquals("Highest grade not retrieved from getHighestGrade method", highest, getHighest.invoke(courseGrade));
		} catch (ClassNotFoundException e) {
			fail("CourseGrades does not exist!");
		} catch (InstantiationException e) {
			fail("CourseGrades must have a no-arg constructor");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			fail("CourseGrades missing addGrade method or Analyzable methods");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			fail("CourseGrades addGrade method not accepting GradedActivity class");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetPercentage() {
		try {
			Class<?> courseGradesClass = Class.forName("edu.carrollcc.cis232.CourseGrades");
			Object courseGrade = courseGradesClass.newInstance();
			Method addGrade = courseGradesClass.getMethod("addGrade", GradedActivity.class);
			GradedActivity highest = getGradedActivity("Highest", 900, 1000);
			
			addGrade.invoke(courseGrade, getGradedActivity("Not Highest", 9, 10));
			addGrade.invoke(courseGrade, getGradedActivity("Not Highest #2", 90, 100));
			addGrade.invoke(courseGrade, getGradedActivity("Not Highest #3", 8, 10));
			addGrade.invoke(courseGrade, highest);
			addGrade.invoke(courseGrade, getGradedActivity("Not Highest #4", 7, 10));
			
			Method getPercentage = courseGradesClass.getMethod("getPercentage");
			assertEquals("Percentage grade not retrieved from getPercentage method", 1014.0/1130.0, 
					(Double)getPercentage.invoke(courseGrade), 0.00001);
		
		} catch (ClassNotFoundException e) {
			fail("CourseGrades does not exist!");
		} catch (InstantiationException e) {
			fail("CourseGrades must have a no-arg constructor");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			fail("CourseGrades missing addGrade method or Analyzable methods");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			fail("CourseGrades addGrade method not accepting GradedActivity class");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCourseGradesToStringReport(){
		try {
			Class<?> courseGradesClass = Class.forName("edu.carrollcc.cis232.CourseGrades");
			Object courseGrade = courseGradesClass.newInstance();
			Method addGrade = courseGradesClass.getMethod("addGrade", GradedActivity.class);

			addGrade.invoke(courseGrade, getGradedActivity("TESTC", 700, 1000));
			addGrade.invoke(courseGrade, getGradedActivity("TESTB", 800, 1000));
			addGrade.invoke(courseGrade, getGradedActivity("TESTD", 600, 1000));
			addGrade.invoke(courseGrade, getGradedActivity("TESTF", 500, 1000));
			
			Method toString = courseGradesClass.getMethod("toString");
			
			String report = (String)toString.invoke(courseGrade);
			String lines[] = report.split("\\r?\\n");
			boolean hasB = false, hasF = false;
			for(String line : lines){
				if (line.contains("TESTB") && line.contains("800") && line.contains("B")){
					hasB = true;
				}else if (line.contains("TESTF") && line.contains("500") && line.contains("F")){
					hasF = true;
				}
			}
			assertTrue("CourseGrades toString method must create a report of grades.", hasB && hasF);
		} catch (ClassNotFoundException e) {
			fail("CourseGrades does not exist!");
		} catch (InstantiationException e) {
			fail("CourseGrades must have a no-arg constructor");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			fail("CourseGrades missing addGrade method or Analyzable methods");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			fail("CourseGrades addGrade method not accepting GradedActivity class");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private GradedActivity getGradedActivity(String name, double earnedPoints, double maxPoints) {
		GradedActivity activity = null;
		try {
			activity = GradedActivity.class.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e1) {

		}
		if(activity == null){
			for (Constructor<?> constructor : GradedActivity.class.getDeclaredConstructors()) {
				ArrayList<Object> args = new ArrayList<>();
				for (Class<?> type : constructor.getParameterTypes()) {
					if (type.isAssignableFrom(double.class)) {
						args.add(0);
					} else {
						args.add(null);
					}
				}
				try {
					return (GradedActivity) constructor.newInstance(args.toArray());
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
				}
			}
		}
		
		assertNotNull("Could not instantiate GradedActivity, add a no-arg constructor", activity);
		
		try {
			GradedActivity.class.getMethod("setEarnedPoints", double.class).invoke(activity, earnedPoints);
			GradedActivity.class.getMethod("setMaxPoints", double.class).invoke(activity, maxPoints);
			GradedActivity.class.getMethod("setName", String.class).invoke(activity, name);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			fail("GradedActivity needs to implement at least the methods specified in the UML diagram");
		}
		
		return activity;
	}
}
