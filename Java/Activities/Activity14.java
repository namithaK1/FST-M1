package Activities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			File file = new File("./activityFile.txt");
			System.out.println(file.createNewFile());
			System.out.println(FileUtils.readFileToString(file, "UTF-8"));
			File obj = FileUtils.getFile("./activityFile.txt");
			System.out.println(FileUtils.readFileToString(obj, "UTF-8"));

			File resourceFolder = new File("Resource");
			FileUtils.copyFileToDirectory(file, resourceFolder);

			File fileFromTheDirectory = FileUtils.getFile(resourceFolder, file.getName());
			System.out.println(FileUtils.readFileToString(fileFromTheDirectory, Charset.defaultCharset()));
		} catch (Exception e) {

			System.out.println("Caught exception" + e.getMessage());
		}
	}

}
