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
 * Unit test for {@link A}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 15 de nov de 2016
 * @email rcm1989@gmail.com
 */
public class ATest {

	private Class<? extends Element<?>> implClass;
	private List<Class<? extends Element<?>>> supportedElements;
	private List<Class<? extends Element<?>>> notSupportedElements;

	@Before
	public void beforeTesting() {
		this.implClass = A.class;
		this.supportedElements = new A().getSupportedElements();

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

	public void checkSupportedStringToAppend() {
		testStringToAppend(this.implClass);
	}

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
	public void emptyAttrsGenerateSimpleTag() {
		A a = new A().download("").href("").hrefLang("").media("").rel("").target("").type("");
		assertEquals("<a></a>", a.toHtml());
	}

	@Test
	public void fullAttrsBuildedInOrder() {
		A a = new A().download("#").href("#").hrefLang("#").media("#").rel("#").target("#").type("#");
		assertEquals("<a download=\"#\" href=\"#\" hrefLang=\"#\" media=\"#\" rel=\"#\" target=\"#\" type=\"#\"></a>",
				a.toHtml());
	}

	@Test
	public void textWithHref() {
		A a = new A().href("#anchor").append("testing");
		assertEquals("<a href=\"#anchor\">testing</a>", a.toHtml());
	}
}
