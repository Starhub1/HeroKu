package TestCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Run {

	private static final BiPredicate<Path, BasicFileAttributes> path = null;

	public void simpleTestNGTest() {

	}

	public static void main(String[] args) throws IOException {
		String dir = "Objects/";
		Path p = Paths.get(dir);
		Properties input = new Properties();

		// Collection<File> listFiles = FileUtils.listFiles(file, new
		// WildcardFileFilter("*.properties"), null);
		// List<String> paths = new ArrayList<>();

		Files.find(p, Integer.MAX_VALUE, (path, attr) -> String.valueOf(path).endsWith("properties")).distinct()
				.limit(5).forEach(action -> System.out.println(action.getFileName()));

		List<Path> load = Files.walk(p).filter(d -> String.valueOf(d).endsWith("properties")).distinct().limit(5)
				.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(load);

		Stream.iterate(10, i -> i + 10).limit(20).forEach(System.out::println);
		Stream.generate(Math::random).map(m -> (m * 10)).mapToInt(m -> m.intValue()).limit(10)
				.forEach(System.out::println);
		IntStream.range(0, 30).filter(t -> t % 2 != 0).forEach(System.out::println);

		for (Path path : load) {
			input.load(new FileInputStream(path.toFile()));
		}
		int d = 10;
		System.out.println("Factorial of a number");
		System.out.println(Stream.iterate(d, i -> i - 1).limit(d).reduce(1, (i, j) -> i * j));
		List<Integer> number = Arrays.asList(14, 3, 1, 5, 4, 8, 10, 2, 3, 6, 13);
		System.out.println("The maximum number is");
		System.out.println(IntStream.rangeClosed(1, 30).reduce(0, (a, b) -> a > b ? a : b));

		Stream.iterate(1, i -> i * ++i).limit(5).forEach(System.out::println);
		/*
		 * System.out.println(input.toString()); System.out.println(
		 * "+++++++++++++++++++++++++++++++++++++++++++++++++");
		 * System.out.println(input.getProperty("test"));
		 */
	}
}

// Workbook wb = WorkbookFactory.create(new File("test.xlsx"));
//
// Sheet sheet = wb.getSheetAt(0);
// int rowcnt = sheet.getLastRowNum();
// int colcnt = sheet.getRow(0).getLastCellNum();
//
// for (int i = 0; i <= rowcnt; i++) {
// Row row = sheet.getRow(i);
// for (int j = 0; j <= colcnt; j++) {
// System.out.println(row.getCell(j));
// }
// }

// // List of xml suites to be considered for test execution
// List<XmlSuite> suites = new ArrayList<XmlSuite>();
// // List of classes to be considered for test execution
// List<XmlClass> classes = new ArrayList<XmlClass>();
//
// // Defines a simple xml suite with a name
// XmlSuite suite = new XmlSuite();
// suite.setName("Simple Config suite");
//
// // Defines a xml test for a suite and with a said name
// XmlTest test = new XmlTest(suite);
// test.setName("Simple config test");
//
// // A single xml class to be considered for execution
// XmlClass clz = new XmlClass("TestCase.DefectTicket");
// classes.add(clz);
// // Sets the list of classes to be considered for execution for a test
// test.setXmlClasses(classes);
//
// // Adds a single suite to the list suites
// suites.add(suite);
//
// // Defining a testng instance
// TestNG tng = new TestNG();
// // Sets the List of xml suites to be considered for execution
// tng.setXmlSuites(suites);
// // Runs the configured testng tests.
// tng.run();
// }
