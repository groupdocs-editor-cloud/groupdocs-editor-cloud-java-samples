package examples.EditOperations;

import com.groupdocs.cloud.editor.client.*;
import com.groupdocs.cloud.editor.model.*;
import com.groupdocs.cloud.editor.model.requests.*;
import com.groupdocs.cloud.editor.api.*;
import examples.Common;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * This example demonstrates how to edit presentation document.
 */
public class EditPresentationDocument {

	public static void main(String[] args) {
		try {
			// Create necessary API instances
			EditApi editApi = new EditApi(Common.GetConfiguration());
			FileApi fileApi = new FileApi(Common.GetConfiguration());

			// The document already uploaded into the storage.
			// Load it into editable state
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Presentation/with-notes.pptx");
			PresentationLoadOptions loadOptions = new PresentationLoadOptions();
			loadOptions.setFileInfo(fileInfo);
			loadOptions.setOutputPath("output");
			loadOptions.setSlideNumber(0);
			LoadResult loadResult = editApi.load(new LoadRequest(loadOptions));

			// Download html document
			File file = fileApi.downloadFile(new DownloadFileRequest(loadResult.getHtmlPath(), null, null));
						
			// Edit something...
			List<String> lines = Files.readAllLines(file.toPath());
			List<String> newLines = new ArrayList<String>();
			for (String line : lines) {
				newLines.add(line.replaceAll("Slide sub-heading", "Hello world!"));
			}
			Files.write(file.toPath(), newLines);
			
			// Upload html back to storage
			fileApi.uploadFile(new UploadFileRequest(loadResult.getHtmlPath(), file, Common.MYStorage));

			// Save html back to pptx
			PresentationSaveOptions saveOptions = new PresentationSaveOptions();
			saveOptions.setFileInfo(fileInfo);
			saveOptions.setOutputPath("output/edited.pptx");	
			saveOptions.setHtmlPath(loadResult.getHtmlPath());		
			saveOptions.setResourcesPath(loadResult.getResourcesPath());
			DocumentResult saveResult = editApi.save(new SaveRequest(saveOptions));

			System.out.println("Document edited: " + saveResult.getPath());

		} catch (ApiException e) {
			System.err.println("Exception:");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Exception:");
			e.printStackTrace();
		}
	}
}