package systemdependencies;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class OperationsTest {

	@Test
	public void test() {
		CommandParser cp = new CommandParser();
		List<String>commands = Arrays.asList("DEPEND DNS TCPIP NETCARD", 
				"INSTALL NETCARD", "LIST", "REMOVE TCPIP", "REMOVE BROWSER");
		cp.readInput(commands);
	}

}
