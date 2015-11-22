import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class RestCaller {
	private static URLConnection conn;
	private static URL url;
	
	public static void setURL(String url) {
		try {
			RestCaller.url = new URL(url);
		}
		catch(MalformedURLException e) {
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
	}
	
	public static URLConnection getURLConnection() {
		try {
			if(conn == null) {
				conn = url.openConnection();
			}
		} catch(IOException e) {
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
		}
		return conn;
	}
	
	public static void doHttpGetRequest(URL url) {
		
	}
	/*URL url = new URL("http://localhost:8080/postedresults.jsp");
    URLConnection conn = url.openConnection();
    conn.setDoInput(true);
    conn.setDoOutput(true);
    conn.setUseCaches(false);
    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
    String content = "CONTENT=HELLO JSP !&ONEMORECONTENT =HELLO POST !";

    out.writeBytes(content);
    out.flush();
    out.close();

    DataInputStream in = new DataInputStream(conn.getInputStream());
    String str;
    while (null != ((str = in.readUTF()))) {
      System.out.println(str );
    }
    in.close();
  }*/
}
