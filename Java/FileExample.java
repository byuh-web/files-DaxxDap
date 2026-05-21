import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.ArrayList;

public class FileExample extends JPanel {
	
	public FileExample() {
		String filename = "friends.txt";
		File f = new File(filename);
		ArrayList<String> amis = new ArrayList<String>();
		try {
			Scanner s = new Scanner(f);
			while (s.hasNext() ==true) {
				IO.println("Inside the while");
				String friend = s.next();
				//IO.println(friend + "'s favorite class is CS202.") ;
				amis.add(friend);
			}
			s.close();
		} catch (FileNotFoundException e) {
			IO.println("Could not open " + filename);
		}
		IO.println("Sorting the names...");
		Collection.sort(amis);
		
		for (String a : amis) {
			if (a.equals("Fequil")) {
				continue;
			}
			IO.print(a + "'s favorite class is CS202.");
		}
	}
		
		
	@Override
	// Method
	public void paintComponent(Graphics g) {

		
	}
		
	public static void main(String[] arg) {
		var window =new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setContentPane(new FileExample());
		window.setVisible(true);
		
		

	
	
	}
}