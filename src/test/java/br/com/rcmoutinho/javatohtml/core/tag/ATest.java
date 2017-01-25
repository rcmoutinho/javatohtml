package br.com.rcmoutinho.javatohtml.core.tag;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.rcmoutinho.javatohtml.core.Element;
import br.com.rcmoutinho.javatohtml.core.ElementTestUtil;
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

	private ElementTestUtil elementTester;
	private List<Class<? extends Element<?>>> supportedElements;
	private List<Class<? extends Element<?>>> notSupportedElements;

	@Before
	public void beforeTesting() {
		this.elementTester = new ElementTestUtil();

		this.supportedElements = new A().getSupportedElements();

		this.notSupportedElements = ElementUtils.getAllImplementedElements();
		this.notSupportedElements.removeAll(this.supportedElements);
	}

	@Test
	public void checkSupportedElementsToAppend() throws InstantiationException, IllegalAccessException {
		int supportedTagCount = this.elementTester.countSupportedTagToAppend(A.class, this.supportedElements);

		assertEquals(supportedTagCount, this.supportedElements.size());
	}

	@Test
	public void checkSupportedElementsToPrepend() throws InstantiationException, IllegalAccessException {
		int supportedTagCount = this.elementTester.countSupportedTagToPrepend(A.class, this.supportedElements);

		assertEquals(supportedTagCount, this.supportedElements.size());
	}

	public void checkSupportedStringToAppend() {
		elementTester.testStringToAppend("a", A.class);
	}

	public void checkSupportedStringToPrepend() {
		elementTester.testStringToPrepend("a", A.class);
	}

	@Test
	public void checkUnsupportedElementsToAppend() {
		int unsupportedTagCount = this.elementTester.countUnsupportedTagExceptionToAppend(new A(),
				this.notSupportedElements);

		assertEquals(unsupportedTagCount, this.notSupportedElements.size());
	}

	@Test
	public void checkUnsupportedElementsToPrepend() {
		int unsupportedTagCount = this.elementTester.countUnsupportedTagExceptionToPrepend(new A(),
				this.notSupportedElements);

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
