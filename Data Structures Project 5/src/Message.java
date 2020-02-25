//Chin-Chap & MacMahon

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Message {

	public SortedList getMessage() throws FileNotFoundException {
		SortedList<Packet> finalSorted = new SortedList<Packet>();

		Scanner s = new Scanner(new File("encoded.txt"));

		while (s.hasNextLine()) {
			int num = s.nextInt();
			String str = s.nextLine();
			str = str.substring(1);
			Packet p = new Packet(num, str);
			finalSorted.addEntry(p);
		}
		return finalSorted;
	}


}