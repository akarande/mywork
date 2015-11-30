package systemdependencies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OperationsImpl implements Operations {

	@Override
	public void depend(String dependent, String supporter) {
		List<String> currentList = new ArrayList<String>();
		if(DependencyGraph.getDependencyMap().get(supporter) != null) {
			currentList.addAll(DependencyGraph.getDependencyMap().get(supporter));
		}
		if(DependencyGraph.getDependencyMap().containsKey(supporter) && !currentList.contains(dependent)) {
			//Check if the dependent already exists
			currentList.add(dependent);
			DependencyGraph.getDependencyMap().put(supporter, currentList);
		} else {
			//currentList = new ArrayList<String>(temp);
			currentList.add(dependent);
			DependencyGraph.getDependencyMap().put(supporter, currentList);
		}
		if(!ComponentsList.getComponentsList().containsKey(dependent)) {
			ComponentsList.addComponent(dependent, false);
		}
		if(!ComponentsList.getComponentsList().containsKey(supporter)) {
			ComponentsList.addComponent(supporter, false);
		}
	}

	@Override
	public void install(String component) {
		//Get the supporters for this particular component
		//Check if they are installed, if not install that first and then install the component
		Map<String, List<String>>dependencyMap = DependencyGraph.getDependencyMap();
		List<String>dependencyList = dependencyMap.get(component);
		Map<String, Boolean>compMap = ComponentsList.getComponentsList();
		if(dependencyList != null) {//Check if the current component has any dependencies
			for(String comp : dependencyList) {
				if(!compMap.get(comp)) {
					install(comp);
					if(!compMap.get(comp)) {//Check before you install otherwise the component is already installed
						compMap.put(comp, true);
						System.out.println("Installing Component: " + comp);
					}
				}
			}
		} else {//No dependency found for current component so install it and return back, this is the base case.
			if(compMap.get(component) == null || !compMap.get(component)) {
				ComponentsList.addComponent(component, true);
				System.out.println("Installing Component: " + component);
				return;
			}
		}
	}

	@Override
	public void remove(String component) {
		//Get the dependency list for the current component
		Map<String, List<String>>dependencyMap = DependencyGraph.getDependencyMap();
		Map<String, Boolean>compMap = ComponentsList.getComponentsList();
		boolean removal = true;
		for(String key : dependencyMap.keySet()) {
			if(dependencyMap.get(key).contains(component) && !compMap.get(key)) {
				continue;
			} else if(dependencyMap.get(key).contains(component)){
				System.out.println("Cannot remove " + component + ", it is needed for " + key);
				removal = false;
			} else if(dependencyMap.get(key).contains(component) && compMap.get(key)) {
				break;
			}
		}
		if(removal) {
			compMap.put(component, false);
			System.out.println("Removing component: " + component);
		}
	}

	@Override
	public void list() {
		Map<String, Boolean> aList = ComponentsList.getComponentsList();
		for(String key : aList.keySet()) {
			if(aList.get(key)) {
				System.out.println(key);
			}
		}
	}

	@Override
	public void end() {
		System.out.println("END");
	}
}
