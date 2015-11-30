package systemdependencies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DependencyGraph {

	private static Map<String, List<String>>dependencyMap;
	
	private DependencyGraph() {}
	
	public static Map<String, List<String>> getDependencyMap() {
		if(dependencyMap == null) {
			dependencyMap = new HashMap<String, List<String>>();
		}
		return dependencyMap;
	}
}
