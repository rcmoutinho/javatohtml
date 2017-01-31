package br.com.rcmoutinho.javatohtml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link ElementDataAttributes}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 30 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class ElementDataAttributesTest {

	private ElementDataAttributes elementDataAttributes;

	@Before
	public void beforeTesting() {
		this.elementDataAttributes = new ElementDataAttributes();
	}

	@Test
	public void checkAddedValue() {

		this.elementDataAttributes.add("test1", "value1");

		assertTrue(this.elementDataAttributes.has("test1"));
		assertEquals("value1", this.elementDataAttributes.get("test1"));

		assertEquals(1, this.elementDataAttributes.getAttributesMap().size());
	}

	@Test
	public void emptyDataAttrEnteringAndRemovingValues() {

		this.elementDataAttributes.add("test", "value");
		assertTrue(this.elementDataAttributes.has("test"));

		this.elementDataAttributes.remove("test");
		assertTrue(this.elementDataAttributes.isEmpty());
	}
}
