package Code.Generic_Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileEdit {
	public static void WriteString(File file, String name, String value) throws IOException {
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(name + "=" + value);
		bw.close();
	}

	public static String ReadString(File file, String find) throws IOException {
		String value = null;
		Scanner s = new Scanner(file);
		s.findWithinHorizon(find + "=", 0);
		if(s.hasNext("\\d+")){
			value = Integer.toString(s.nextInt());
		} else if(s.hasNext("\\w+")){
			value = Character.toString(s.findWithinHorizon("\\w+", 0).charAt(0));
		}
		s.close();
		return value;
	}

	public static void DeleteString(File file, String delete) throws IOException {
		List<String> lines = new ArrayList<String>();
		Scanner s = new Scanner(file);
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		String line;
		while ((s.hasNextLine()) == true) {
			line = s.nextLine();
			lines.add(line);
		}
		s.close();
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).contains(delete)) {
				lines.remove(i);
			}
		}
		FileWriter fw1 = new FileWriter(file.getAbsoluteFile(), false);
		BufferedWriter bw2 = new BufferedWriter(fw1);
		bw2.close();
		for(String current : lines){
			bw.write(current + "\r");
		}
		bw.close();
	}

	public static void ChangeValue(File file, String name, String newValue) throws IOException {
		DeleteString(file, name);
		WriteString(file, name, newValue);
	}
	
	public static void SetDefault(File file, String name, String value) throws IOException{
		Scanner s = new Scanner(file);
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		if (s.findWithinHorizon(name + "=", 0) == null) {
			s.close();
			s = new Scanner(file);
			bw.write(name + "=" + value + "\r");
		} else {
			System.out.println("Defualt already in place!");
			bw.close();
			s.close();
			return;
		}
		bw.close();
		s.close();
	}
}
