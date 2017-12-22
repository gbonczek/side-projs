// this will eventually be a grade calculator
// So far I am just working on a login screen so you do not need to enter all of your information every time

import java.util.*;
import java.io.*;

public class GradeCalculator{
	private static HashMap<String, String> users = new HashMap<String, String>();
	private static String user;
	
	public static void main (String [] args) {
		Scanner userIn = new Scanner(System.in);
		File f = new File("users.txt");
		Scanner savedUsers = null;
		try {
			savedUsers = new Scanner(f);
		}
		catch (IOException e) {
			System.out.println("Users file not found.");
			System.exit(1);
		}
		getUsers(savedUsers); // this fills out the users hash map <username, everything else on that line>
		
		System.out.println("Grants Grade Generator");
		System.out.print("Username: ");
		String userName = userIn.next().trim();	
		while(!users.containsKey(userName)) {
			System.out.print("User not found try again\nUsername: ");
			userName = userIn.next().trim();
		}
		user = userName;
		
		System.out.print("Passoword: ");
		String password = userIn.next().trim();
		while(!users.get(user).trim().startsWith(password+" ")) {
			System.out.print("Incorrecet password try again\nPassword: ");
			password = userIn.next().trim();
		}
		System.out.println("Login Successful!\nFor a list of commands type in help.");
		System.out.print(" > ");
		while (userIn.hasNext()) {
			String cmd = userIn.next().toLowerCase().trim();
			if (cmd.equals("get current grades")) {
				System.out.println(users.get(user).trim());
				System.out.print(" > ");
				continue;
			}
			else if (cmd.equals("help")) {
				System.out.println("Commands (Not case sensitive) : ");
				System.out.println("\"Get current grades\", this command get current grades for a class");
				System.out.println("\"Quit\", this command quits the program.");
				System.out.print(" > ");
				continue;
			}
			else if (cmd.equals("quit")) {
				String ans = "invalid";
				while (!ans.equals("Y") && !ans.equals("N")) {
					System.out.print("Are you sure you want to quit? (Y/N) ");
					ans = userIn.next().trim();
				}
				if (ans.equals("Y")) {
					System.exit(1);
				}
				else {
					System.out.print(" > ");
					continue;
				}
				System.out.print(" > ");
				continue;
			}
			System.out.println(" > ");
		}
	}
	
	private static void getUsers(Scanner savedUsers) {
		while (savedUsers.hasNextLine()) {
			String line = savedUsers.nextLine().trim();
			int splitAt = line.indexOf(" ");
			String userName = line.substring(0, splitAt);
			String description = line.substring(splitAt);
			users.put(userName, description);
		}
	}
}