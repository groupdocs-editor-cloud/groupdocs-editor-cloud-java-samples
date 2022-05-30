package examples;

import com.groupdocs.cloud.editor.client.*;
import com.groupdocs.cloud.editor.model.*;
import com.groupdocs.cloud.editor.api.LicenseApi;


/**
 * This example demonstrates how to get metered license consumption information
 */
public class GetMeteredConsumption {

	public static void main(String[] args) {
		
		LicenseApi apiInstance = new LicenseApi(Common.GetConfiguration());
		
		try {
			ConsumptionResult response = apiInstance.getConsumptionCredit();

			System.out.println("Credit: " + response.getCredit());
			System.out.println("Quantity: " + response.getQuantity());
		} catch (ApiException e) {
			System.err.println("Exception while calling LicenseApi:");
			e.printStackTrace();
		}
	}
}