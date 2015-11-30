package systemdependencies;

import java.util.HashMap;
import java.util.Map;

public class ComponentsList {
	private static Map<String, Boolean>componentList;
	
	private ComponentsList() {}
	
	public static Map<String, Boolean> getComponentsList() {
		if(componentList == null) {
			componentList = new HashMap<String, Boolean>();
		}
		return componentList;
	}
	
	public static void addComponent(String componentName, Boolean isInstalled) {
		componentList.put(componentName, isInstalled);
	}
}
