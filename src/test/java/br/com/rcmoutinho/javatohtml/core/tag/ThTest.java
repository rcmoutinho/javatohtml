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
 * Unit test for {@link Th}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 27 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class ThTest {

	private Class<? extends Element<?>> implClass;
	private List<Class<? extends Element<?>>> supportedElements;
	private List<Class<? extends Element<?>>> notSupportedElements;

	@Before
	public void beforeTesting() {
		this.implClass = Th.class;
		this.supportedElements = new Th().getSupportedElements();

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
	public void emptyAttrsGenerateSimpleTag() {
		Th th = new Th().abbr("").colspan(1).headers("").rowspan(1).scope("").sorted("");
		assertEquals("<th></th>", th.toHtml());
	}

	@Test
	public void fullAttrsBuildedInOrder() {
		Th th = new Th().abbr("#").colspan(2).headers("#").rowspan(2).scope("#").sorted("#");
		assertEquals("<th abbr=\"#\" colspan=\"2\" headers=\"#\" rowspan=\"2\" scope=\"#\" sorted=\"#\"></th>",
				th.toHtml());
	}

	@Test
	public void textWith3RowsAnd2Columns() {
		Th th = new Th("text").rowspan(3).colspan(2);
		assertEquals("<th colspan=\"2\" rowspan=\"3\">text</th>", th.toHtml());
	}
	
	@Test
	public void withSpan() {
		Th th = new Th(new Span());
		assertEquals("<th><span></span></th>", th.toHtml());
	}
}
