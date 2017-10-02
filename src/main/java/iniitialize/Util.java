package iniitialize;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.TestNG;

import com.google.common.collect.Lists;

public class Util {

	private static String filePath;

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        Util.filePath = filePath+"Execution Report " + Util.getCurrentDateTime() + "/index.html";
    }



	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return a.compareTo(b);
		    }
		});
		Random random = new Random();
		random.ints().limit(10).forEach(System.out :: println);
		LocalDateTime time  = LocalDateTime.now();
		
		names.forEach(System.out :: println);
		System.out.println(names);
		TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("testng.xml");
        testng.setTestSuites(suites);
        testng.run();

		//collection
		
		//Stack
    	System.out.println("THis is a Stack Example");
    	Stack<Integer> s = new  Stack<>();
    	s.push(3);
    	s.push(3);
    	s.push(6);
    	s.push(2);
    	System.out.println("The removed part is at"+ s.pop());
    	System.out.println(s);
    	System.out.println(s.peek());    	
    	System.out.println("Stack Example Ends here ");    	
    	//End Stack
    	
    	
    	System.out.println("THis is a Queue Example");
    	Queue<Integer> q = new LinkedList<>();
    	q.add(1);
    	q.add(4);
    	q.add(2);
    	q.add(3);
    	
    	System.out.println(q);
    	System.out.println(q.poll());    	
    	System.out.println("Queue Example Ends here ");    	
    	//End Queue
    	
    	//Linked List
    	System.out.println("THis is a Linked list Example");
    	LinkedList<Integer> l = new LinkedList<>();
    	l.add(1);
    	l.add(4);
    	l.add(2);
    	l.add(3);
    	System.out.println("The removed part is at"+ l.remove());
    	System.out.println(l);
    	System.out.println(l.poll());    	
    	System.out.println("Linked list Example Ends here ");    	
    	//End Linked List
    	
    	
		//LIST--ARRAY LIST
    	System.out.println("THis is a List Example");

		List<String> list = new ArrayList<>();
		list.add("s");
		list.add("3");
		System.out.println(list.contains("3"));
		list.add(1, "4");
		for(String a : list) {
			System.out.println(a);
			
		}
		System.out.println(list);
		list.clear();
	
		System.out.println(list);
    	

    	//MAP
    	System.out.println("THis is a Map Example");
    	NavigableMap<String,Integer> map  = new TreeMap<>();
    	map.put("One", 1);
    	map.put("two", 2);
    	map.put("three",3);
    	map.put("four",4);
		map.put("five",5);
		map.descendingKeySet();
		for (String m : map.keySet()) {
			System.out.println(map.get(m));
		}
    	System.out.println("Map Example Ends here");

		
		System.out.println(Integer.valueOf((int)(Math.random()*10+1)));
    	
    	
		Integer i = new Integer(2);
		String filepath = "./test-results/" + "Execution Report " + System.nanoTime() + "/index.html";
        System.out.println(filepath.substring(0,filepath.length()-10));
        System.out.println("The current time in millis: " + System.currentTimeMillis());
		System.out.println("THe current time in nanos" + System.nanoTime());
		Date date = new Date();
		System.out.println("The current date is " + date.toString());
		Date afterdate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
		System.out.println("The future date is " + afterdate);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MMM.yyyy hh-mm-ss");
		System.out.println(sdf.format(afterdate));
		System.out.println(sdf.format(date));
	}

	public static String getCurrentDateTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MMM.yyyy hh-mm-ss");
		return sdf.format(date);

	}

	public static String takeScreenShot(String methodName, WebDriver driver) {

		/*File file = new File("C:\\Users\\nasir\\IdeaProjects\\HerokuApp\\test-results\\"+"Execution Report "+init.getReportName()+"\\screenshots\\");
			if (!file.exists()){
				file.mkdir();
			}*/
		Path path =Paths.get(filePath).getParent();
	
		path = path.resolve("Screenhshots");

		if (!path.toFile().exists()){
			try {
				FileUtils.forceMkdir(path.toFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		path = path.resolve(methodName + "/" + methodName+getCurrentDateTime() + ".png");

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile,path.toFile());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return path.toString();
	}
}