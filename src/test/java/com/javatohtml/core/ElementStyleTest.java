package com.javatohtml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.javatohtml.core.ElementStyle;

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
	public void checkNonExistingProperty() {
		assertFalse(this.elementStyle.has(null));
		assertFalse(this.elementStyle.has(""));
		assertFalse(this.elementStyle.has("prop"));
	}

	@Test
	public void checkNonExistingValue() {
		assertNull(this.elementStyle.get(null));
		assertNull(this.elementStyle.get(""));
		assertNull(this.elementStyle.get("prop"));
	}

	@Test
	public void emptyStyleEnteringAndRemovingValues() {

		this.elementStyle.add("margin", "2px");
		assertTrue(this.elementStyle.has("margin"));
		assertEquals("2px", this.elementStyle.get("margin"));
		assertEquals("margin: 2px;", this.elementStyle.getValues());

		this.elementStyle.remove("margin");
		assertTrue(this.elementStyle.isEmpty());
	}

	@Test
	public void emptyStyleEnteringWrongValues() {

		this.elementStyle.add(null);
		this.elementStyle.add("");
		this.elementStyle.add(";;;");
		this.elementStyle.add("prop;value;");
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
	public void testRemovingNullValue() {
		this.elementStyle.remove(null);
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
