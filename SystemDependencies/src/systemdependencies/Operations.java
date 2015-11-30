package systemdependencies;

public interface Operations {

	void depend(String dependent, String supporter);
	void install(String component);
	void remove(String component);
	void list();
	void end();
}
