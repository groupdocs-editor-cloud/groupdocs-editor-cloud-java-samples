package examples;

import examples.EditOperations.EditWordProcessingDocument;
import examples.EditOperations.EditSpreadsheetDocument;
import examples.EditOperations.EditPresentationDocument;
import examples.EditOperations.EditDsvDocument;
import examples.EditOperations.EditTextDocument;

public class RunExamples {

	public static void main(String[] args) {

		// Upload files
		UploadResoruces.main(args);

		// Info API examples
		GetSupportedFileTypes.main(args);
		GetDocumentInformation.main(args);

		// Edit API examples
		EditWordProcessingDocument.main(args);
		EditSpreadsheetDocument.main(args);
		EditPresentationDocument.main(args);
		EditDsvDocument.main(args);
		EditTextDocument.main(args);

		System.out.println("Completed");
	}	
}