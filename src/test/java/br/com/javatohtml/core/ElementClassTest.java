package br.com.javatohtml.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link ElementClass}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 1 de fev de 2017
 * @email rcm1989@gmail.com
 */
public class ElementClassTest {

	private ElementClass elementClass;

	@Before
	public void beforeTesting() {
		this.elementClass = new ElementClass();
	}

	@Test
	public void checkAddingClass() {
		this.elementClass.add("test");
		assertFalse(this.elementClass.isEmpty());
		assertTrue(this.elementClass.has("test"));
		assertEquals("test", this.elementClass.getValues());
	}

	@Test
	public void checkAddingClassInOrder() {
		this.elementClass.add("test1");
		this.elementClass.add("test2");
		this.elementClass.add("test3");
		assertEquals("test1 test2 test3", this.elementClass.getValues());
	}

	@Test
	public void checkAddingClassInOrderAfterRemoving() {
		this.elementClass.add("test1");
		this.elementClass.add("test2");
		this.elementClass.add("test3");
		this.elementClass.toggle("test4");
		this.elementClass.remove("test3");
		assertEquals("test1 test2 test4", this.elementClass.getValues());
	}

	@Test
	public void checkAddingDuplicatedClass() {
		this.elementClass.add("test");
		this.elementClass.add("test2");
		this.elementClass.add("test");
		this.elementClass.add("test2");
		assertFalse(this.elementClass.isEmpty());
		assertEquals("test test2", this.elementClass.getValues());
	}
	
	@Test
	public void checkAddingMultipleClasses() {
		this.elementClass.add("test1 test2");
		this.elementClass.add(" test2   test3 ");
		this.elementClass.add("test1 test2 test3     test4");
		assertFalse(this.elementClass.isEmpty());
		assertEquals("test1 test2 test3 test4", this.elementClass.getValues());
	}

	@Test
	public void checkAddingNull() {
		this.elementClass.add(null);
		assertTrue(this.elementClass.isEmpty());
		assertEquals("", this.elementClass.getValues());
	}

	@Test
	public void checkNonExistingClass() {
		assertFalse(this.elementClass.has(null));
	}

	@Test
	public void checkRemovingNonExistingClass() {
		this.elementClass.remove(null);
		this.elementClass.remove("");
		this.elementClass.remove("test");
		assertTrue(this.elementClass.isEmpty());
		assertEquals("", this.elementClass.getValues());
	}

	@Test
	public void emptyDataAttrEnteringAndRemovingValues() {

		this.elementClass.add("test");
		assertTrue(this.elementClass.has("test"));
		assertEquals("test", this.elementClass.getValues());

		this.elementClass.remove("test");
		assertTrue(this.elementClass.isEmpty());
		assertEquals("", this.elementClass.getValues());
	}

	@Test
	public void toggleInvalidClasses() {
		this.elementClass.toggle(null);
		this.elementClass.toggle("");
		assertTrue(this.elementClass.isEmpty());
		assertEquals("", this.elementClass.getValues());
	}

	@Test
	public void togglingClasses() {
		this.elementClass.add("test");
		assertTrue(this.elementClass.has("test"));
		assertEquals("test", this.elementClass.getValues());

		this.elementClass.toggle("test");
		assertTrue(this.elementClass.isEmpty());
		assertEquals("", this.elementClass.getValues());

		this.elementClass.toggle("test2");
		assertFalse(this.elementClass.isEmpty());
		assertEquals("test2", this.elementClass.getValues());

		this.elementClass.toggle("test");
		assertFalse(this.elementClass.isEmpty());
		assertEquals("test2 test", this.elementClass.getValues());
	}
}
