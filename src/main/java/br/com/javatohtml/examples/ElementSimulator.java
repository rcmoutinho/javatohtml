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
				img().alt("cupcake").classCss("candy")
					.src("https://cdn4.iconfinder.com/data/icons/miu/24/food-cupcake-muffin-dessert-birthday-glyph-128.png")
			).append(
				img().alt("pizza").classCss("slice")
					.src("https://cdn4.iconfinder.com/data/icons/miu/24/food-pizza-fastfood-glyph-128.png")
			).append(
				img().alt("bith cake").classCss("candy")
					.src("https://cdn4.iconfinder.com/data/icons/miu/24/food-birthday-cake-party-candle-glyph-128.png")
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
	
	/**
	 * New tag with new attributes.
	 * <br>
	 * &lt;dog breed="German Shepherd" /&gt;
	 * 
	 * @return
	 */
	public Element<?> createCrazyElement(){
		return tag("dog").attr("breed", "German Shepherd").noEndTag();
	}
	
	/**
	 * Creates an old HTML tag that is not supported anymore by HTML5.
	 * 
	 * @return
	 */
	public Element<?> createOldHtmlTag(){
		return tag("center").append("bye old tag");
	}

	public static void main(String[] args) throws Exception {
		ElementSimulator uxSimulator = new ElementSimulator();
		
		File htmlFile = new File(ExampleExport.BASE_EXAMPLE_PATH + "ExSimulator.html");
		
		new ExampleExport().exportElementsToFileAndOpenDefaultBrowser(htmlFile, 
			uxSimulator.createPhotoGallery(), 
			uxSimulator.createSimpleTable(), 
			uxSimulator.createCrazyElement(),
			uxSimulator.createOldHtmlTag()
		);
	}
}
