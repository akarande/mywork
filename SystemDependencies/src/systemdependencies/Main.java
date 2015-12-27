package systemdependencies;

public class Main {

	public static void main(String arg[]) {
		CommandParser cp = new CommandParser();
		try {
			cp.readInput("input");
		} catch(Exception e) {
			System.out.println("Exception caused: " + e.getMessage());
		}
	}
}
