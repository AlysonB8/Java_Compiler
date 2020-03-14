import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	public File FileObject;
	public String file_content = "";

	public ReadFile(String filename) throws FileNotFoundException {
		FileObject = new File(filename);
		Scanner myReader = new Scanner(FileObject);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			file_content = file_content + data;
			file_content = file_content + "\n";
		}
		myReader.close();
		System.out.println(file_content);
	}
}
