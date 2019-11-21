package examples;
import com.groupdocs.cloud.editor.client.Configuration;

public class Common {

	// TODO: Get your AppSID and AppKey at https://dashboard.groupdocs.cloud (free
	// registration is required).

	private static String AppSID = "XXXXXXXXXXXXXXXXXXXXX";
	private static String AppKey = "XXXXXXXXXXXXXXXXXXX";
	public static String MYStorage = "First Storage";

	public static Configuration GetConfiguration()
	{
		Configuration cfg = new Configuration(Common.AppSID, Common.AppKey);		
		cfg.setTimeout(60000);
		return cfg;
	}	
}