package TestCase;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.TestNG;

import com.beust.jcommander.internal.Lists;

import iniitialize.Init;

public class Run {

	public static void main(String[] args) {
		

		InputStream is =Run.class.getResourceAsStream("/testng.xml");
		java.io.File f = null;
		try {
			f = java.io.File.createTempFile("testng", ".xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		f.deleteOnExit();
		
		try {
			FileUtils.copyInputStreamToFile(is, f);
		} catch (IOException e) {
			e.printStackTrace();
		};
		TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add(f.getAbsolutePath());
        testng.setTestSuites(suites);
        testng.run();
        
        
		
		

	}

}
