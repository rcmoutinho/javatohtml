package br.com.rcmoutinho.javatohtml.core.tag;

import static br.com.rcmoutinho.javatohtml.core.ElementTestUtil.countSupportedTagToAppend;
import static br.com.rcmoutinho.javatohtml.core.ElementTestUtil.countSupportedTagToPrepend;
import static br.com.rcmoutinho.javatohtml.core.ElementTestUtil.countUnsupportedTagExceptionToAppend;
import static br.com.rcmoutinho.javatohtml.core.ElementTestUtil.countUnsupportedTagExceptionToPrepend;
import static br.com.rcmoutinho.javatohtml.core.ElementTestUtil.testStringToAppend;
import static br.com.rcmoutinho.javatohtml.core.ElementTestUtil.testStringToPrepend;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.rcmoutinho.javatohtml.core.Element;
import br.com.rcmoutinho.javatohtml.core.ElementUtils;

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
		Tag tag = new Tag("tag").addAttr("attr1", "value1").addAttr("attr2", "value2").addAttr("attr3", "value3");
		assertEquals("<tag attr1=\"value1\" attr2=\"value2\" attr3=\"value3\"></tag>", tag.toHtml());
	}

	@Test
	public void dropEndTag() {
		assertEquals("<tag />", new Tag("tag").noEndTag().toHtml());
	}

	@Test
	public void emptyCustomAttrsGenerateSimpleTag() {
		Tag tag = new Tag("tag").addAttr(null, null).addAttr("", null).addAttr("attr", null).addAttr("attr", "");
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

		tag.addAttr("attr", "value");
		assertEquals("<tag attr=\"value\"></tag>", tag.toHtml());

		tag.removeAttr("attr");
		assertEquals("<tag></tag>", tag.toHtml());
	}
}
