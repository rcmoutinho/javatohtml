package br.com.javatohtml.examples;

import static br.com.javatohtml.core.ElementCreator.*;

import java.io.File;

import br.com.javatohtml.core.Element;
import br.com.javatohtml.core.tag.Table;

/**
 * Simulate the creation of elements to explore the API possibilities.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 5 de out de 2016
 * @email rcm1989@gmail.com
 */
public class ElementSimulator {
	
	/**
	 * Simulate a photo gallery.
	 * 
	 * @return
	 */
	public Element<?> createPhotoGallery() {
		
		return div().style("border:5px solid #aaa;padding:25px;margin:25px;text-align:center;")
			.append(
				h1("Foods").style("margin:0 0 25px;")
			).append(
				img().src("https://cdn4.iconfinder.com/data/icons/miu/24/food-cupcake-muffin-dessert-birthday-glyph-128.png").classCss("candy")
			).append(
				img().src("https://cdn4.iconfinder.com/data/icons/miu/24/food-pizza-fastfood-glyph-128.png").classCss("slice")
			).append(
				img().src("https://cdn4.iconfinder.com/data/icons/miu/24/food-birthday-cake-party-candle-glyph-128.png").classCss("candy")
			);
	}

	/**
	 * Simulate table creation.
	 * 
	 * @return
	 */
	public Element<?> createSimpleTable() {

		Table table = table()
			.style("background-color", "gray").style("border", "1px solid #000");

		tr()
			.append(th("Título 1"))
			.append(th("Título 2"))
			.append(th("Título 3"))
			.appendTo(table);
		
		tr()
			.append(td("Conteúdo 1"))
			.append(td("Conteúdo 2"))
			.append(td("Conteúdo 3").append(a().classCss("minha-classe").href("#").append("Hello World!!!")))
			.appendTo(table);

		return table;
	}

	public static void main(String[] args) throws Exception {
		ElementSimulator uxSimulator = new ElementSimulator();
		
		File htmlFile = new File(ExampleExport.BASE_EXAMPLE_PATH + "ExSimulator.html");
		
		Element<?> photoGallery = uxSimulator.createPhotoGallery();
		Element<?> simpleTable = uxSimulator.createSimpleTable();
		
		new ExampleExport().exportElementsToFileAndOpenDefaultBrowser(htmlFile, photoGallery, simpleTable);
	}
}
