package com.javatohtml.core.tag;

import static com.javatohtml.core.ElementTestUtil.countSupportedTagToAppend;
import static com.javatohtml.core.ElementTestUtil.countSupportedTagToPrepend;
import static com.javatohtml.core.ElementTestUtil.countUnsupportedTagExceptionToAppend;
import static com.javatohtml.core.ElementTestUtil.countUnsupportedTagExceptionToPrepend;
import static com.javatohtml.core.ElementTestUtil.testStringToAppend;
import static com.javatohtml.core.ElementTestUtil.testStringToPrepend;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.javatohtml.core.Element;
import com.javatohtml.core.ElementUtils;
import com.javatohtml.core.tag.Tag;

/**
 * Unit test for {@link Tag}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 27 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class TagTest {

	private Class<? extends Element<?>> implClass;
	private List<Class<? extends Element<?>>> supportedElements;
	private List<Class<? extends Element<?>>> notSupportedElements;

	@Before
	public void beforeTesting() {
		this.implClass = Tag.class;
		this.supportedElements = new Tag("tag").getSupportedElements();

		this.notSupportedElements = ElementUtils.getAllImplementedElements();
		this.notSupportedElements.removeAll(this.supportedElements);
	}

	@Test
	public void checkNonExistingAttr() {
		assertFalse(new Tag("tag").hasAttr(null));
	}

	@Test
	public void checkSupportedElementsToAppend() {
		int supportedTagCount = countSupportedTagToAppend(this.implClass, this.supportedElements);
		assertEquals(supportedTagCount, this.supportedElements.size());
	}

	@Test
	public void checkSupportedElementsToPrepend() {
		int supportedTagCount = countSupportedTagToPrepend(this.implClass, this.supportedElements);
		assertEquals(supportedTagCount, this.supportedElements.size());
	}

	@Test
	public void checkSupportedStringToAppend() {
		testStringToAppend(this.implClass);
	}

	@Test
	public void checkSupportedStringToPrepend() {
		testStringToPrepend(this.implClass);
	}

	@Test
	public void checkUnsupportedElementsToAppend() {
		int unsupportedTagCount = countUnsupportedTagExceptionToAppend(this.implClass, this.notSupportedElements);
		assertEquals(unsupportedTagCount, this.notSupportedElements.size());
	}

	@Test
	public void checkUnsupportedElementsToPrepend() {
		int unsupportedTagCount = countUnsupportedTagExceptionToPrepend(this.implClass, this.notSupportedElements);
		assertEquals(unsupportedTagCount, this.notSupportedElements.size());
	}

	@Test
	public void customAttrsBuildedInOrder() {
		Tag tag = new Tag("tag").attr("attr1", "value1").attr("attr2", "value2").attr("attr3", "value3");
		
		assertTrue(tag.hasAttr("attr1"));
		assertTrue(tag.hasAttr("attr2"));
		assertTrue(tag.hasAttr("attr3"));
		
		assertEquals("<tag attr1=\"value1\" attr2=\"value2\" attr3=\"value3\"></tag>", tag.toHtml());
	}

	@Test
	public void dropEndTag() {
		assertEquals("<tag />", new Tag("tag").noEndTag().toHtml());
	}

	@Test
	public void emptyCustomAttrsGenerateSimpleTag() {
		Tag tag = new Tag("tag").attr(null, null).attr("", null).attr("attr", null).attr("attr", "");
		assertEquals("<tag></tag>", tag.toHtml());
	}

	@Test(expected = RuntimeException.class)
	public void errorWithEmptyName() {
		new Tag("");
	}

	@Test
	public void simpleTag() {
		assertEquals("<tag></tag>", new Tag("tag").toHtml());
	}

	@Test
	public void simpleTagRemovingPreviouslyAddedAttribute() {
		Tag tag = new Tag("tag");

		tag.attr("attr", "value");
		assertTrue(tag.hasAttr("attr"));
		assertEquals("<tag attr=\"value\"></tag>", tag.toHtml());

		tag.removeAttr("attr");
		assertFalse(tag.hasAttr("attr"));
		assertEquals("<tag></tag>", tag.toHtml());
	}
}
