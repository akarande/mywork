package systemdependencies;

public class Main {

	public static void main(String arg[]) {
		CommandParser cp = new CommandParser();
		try {
			cp.readInput("input2");
		} catch(Exception e) {
			System.out.println("Exception caused: " + e.getMessage());
		}
	}
}
