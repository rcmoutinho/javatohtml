package br.com.javatohtml.examples;

import static br.com.javatohtml.core.ElementCreator.*;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;

import br.com.javatohtml.core.Element;

/**
 * Helps exporting the created examples.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 12 de fev de 2017
 * @email rcm1989@gmail.com
 */
public class ExampleExport {
	
	public static final String BASE_EXAMPLE_PATH = "src/main/java/br/com/javatohtml/examples/";

	/**
	 * Exports the values to the needed file and tries to open directly 
	 * on browser (not supported in some OS).
	 * 
	 * @param clazz
	 * @param values
	 */
	public void exportElementsToFileAndOpenDefaultBrowser(File htmlFile, Element<?>... values) {
		
		try {
			FileWriter fw = new FileWriter(htmlFile);
			
			for (Element<?> element : values) {
				String html = element.toHtml();
				
				System.out.println(html);
				System.out.println("--------------------\n\n");
				
				fw.write(html);
				fw.write(hr().style("margin: 30px 0;").toHtml());
			}
			
			fw.close();
			
			// tries to open on default web browser
			Desktop.getDesktop().browse(htmlFile.toURI());
			
		} catch (Exception e) {
			throw new RuntimeException("Sorry!", e);
		}
	}
}
