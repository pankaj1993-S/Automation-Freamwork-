package Utils;
import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GenerateTestNG {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createTestNG();
	}

	public static void createTestNG() {
		try {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element suite = document.createElement("suite");
			suite.setAttribute("name", "Practice");
			document.appendChild(suite);
			Object[][] masterSheet = ExcelOperations.readExcel("Mastersheet");
			for(int i = 0; i < masterSheet.length; i++) {
				if(((HashMap<String, String>)masterSheet[i][0]).get("Execute").equalsIgnoreCase("Yes")) {
					Element test = document.createElement("test");
					test.setAttribute("name", ((HashMap<String, String>)masterSheet[i][0]).get("TestCaseName"));
					suite.appendChild(test);
					Element parameter = document.createElement("parameter");
					parameter.setAttribute("name", "Browser");
					parameter.setAttribute("value", ((HashMap<String, String>)masterSheet[i][0]).get("Browser"));
					test.appendChild(parameter);
					
					Element classes = document.createElement("classes");
					test.appendChild(classes);
					
					Element tagClass = document.createElement("class");
					tagClass.setAttribute("name", "Tests." + ((HashMap<String, String>)masterSheet[i][0]).get("TestCaseName"));
					classes.appendChild(tagClass);
					
				}
			}
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			StreamResult testng = new StreamResult(new File(System.getProperty("user.dir") + "/testng.xml"));
			transformer.transform(new DOMSource(document), testng);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
