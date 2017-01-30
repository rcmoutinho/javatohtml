package br.com.rcmoutinho.javatohtml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link ElementStyle}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 30 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class ElementStyleTest {

	private ElementStyle elementStyle;

	@Before
	public void beforeTesting() {
		this.elementStyle = new ElementStyle();
	}

	@Test
	public void emptyStyleEnteringAndRemovingValues() {

		this.elementStyle.add("margin", "2px");
		assertEquals("margin: 2px;", this.elementStyle.getValues());

		this.elementStyle.remove("margin");
		assertTrue(this.elementStyle.isEmpty());
	}

	@Test
	public void emptyStyleEnteringWrongValues() {

		this.elementStyle.add("prop value");
		this.elementStyle.add("prop:");
		this.elementStyle.add("value");
		this.elementStyle.add(":");
		this.elementStyle.add("prop: value prop:value");

		this.elementStyle.add("", "");
		this.elementStyle.add(null, null);
		this.elementStyle.add("prop", "");
		this.elementStyle.add("prop", null);
		this.elementStyle.add("", "value");
		this.elementStyle.add(null, "value");

		assertTrue(this.elementStyle.isEmpty());
	}

	@Test
	public void testLongStyleValues() {

		String values = "border: 1px solid #000; float: left; margin: 2px;";
		this.elementStyle.add(values);

		assertEquals(values, this.elementStyle.getValues());
	}

	@Test
	public void testSimpleStyleValues() {

		this.elementStyle.add("border", "1px solid #000");
		this.elementStyle.add("float", "left");
		this.elementStyle.add("margin", "2px");

		String style = "border: 1px solid #000; float: left; margin: 2px;";
		assertEquals(style, this.elementStyle.getValues());
	}
	
	@Test
	public void testSimpleStyleWithInvalidCharacters() {
		
		this.elementStyle.add("margin:", "2px;");
		assertEquals("margin: 2px;", this.elementStyle.getValues());
	}
}
