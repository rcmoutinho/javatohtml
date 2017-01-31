package br.com.rcmoutinho.javatohtml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
	public void checkAddingNullAttr() {
		this.elementDataAttributes.add(null, null);
		assertEquals(0, this.elementDataAttributes.getAttributesMap().size());
	}

	@Test
	public void checkAddingAttrAndValue() {
		this.elementDataAttributes.add("test1", "value1");

		assertTrue(this.elementDataAttributes.has("test1"));
		assertEquals("value1", this.elementDataAttributes.get("test1"));
		assertEquals(1, this.elementDataAttributes.getAttributesMap().size());
	}

	@Test
	public void fixingNullAttrValue() {
		this.elementDataAttributes.add("test", null);

		assertTrue(this.elementDataAttributes.has("test"));
		assertEquals("", this.elementDataAttributes.get("test"));
		assertEquals(1, this.elementDataAttributes.getAttributesMap().size());
	}

	@Test
	public void checkNonExistingAttr() {
		assertFalse(this.elementDataAttributes.has(null));
	}

	@Test
	public void checkRemovingNonExistingAttr() {
		
		this.elementDataAttributes.add("test1", "value1");
		assertEquals(1, this.elementDataAttributes.getAttributesMap().size());
		
		this.elementDataAttributes.remove(null);
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
