package examples;

import com.groupdocs.cloud.editor.client.*;
import com.groupdocs.cloud.editor.model.*;
import com.groupdocs.cloud.editor.api.InfoApi;
import examples.Common;

/**
 * This example demonstrates how to obtain all supported file types.
 */
public class GetSupportedFileTypes {

	public static void main(String[] args) {
		
		InfoApi apiInstance = new InfoApi(Common.GetConfiguration());
		
		try {
			FormatsResult response = apiInstance.getSupportedFileFormats();

			for (Format format : response.getFormats()) {
				System.out.println(format.getFileFormat());
			}
		} catch (ApiException e) {
			System.err.println("Exception while calling InfoApi:");
			e.printStackTrace();
		}
	}
}