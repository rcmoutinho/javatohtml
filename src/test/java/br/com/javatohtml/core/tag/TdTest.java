package br.com.javatohtml.core.tag;

import static br.com.javatohtml.core.ElementTestUtil.countSupportedTagToAppend;
import static br.com.javatohtml.core.ElementTestUtil.countSupportedTagToPrepend;
import static br.com.javatohtml.core.ElementTestUtil.countUnsupportedTagExceptionToAppend;
import static br.com.javatohtml.core.ElementTestUtil.countUnsupportedTagExceptionToPrepend;
import static br.com.javatohtml.core.ElementTestUtil.testStringToAppend;
import static br.com.javatohtml.core.ElementTestUtil.testStringToPrepend;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.javatohtml.core.Element;
import br.com.javatohtml.core.ElementUtils;

/**
 * Unit test for {@link Td}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 27 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class TdTest {

	private Class<? extends Element<?>> implClass;
	private List<Class<? extends Element<?>>> supportedElements;
	private List<Class<? extends Element<?>>> notSupportedElements;

	@Before
	public void beforeTesting() {
		this.implClass = Td.class;
		this.supportedElements = new Td().getSupportedElements();

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
		Td td = new Td().colspan(1).headers("").rowspan(1);
		assertEquals("<td></td>", td.toHtml());
	}

	@Test
	public void fullAttrsBuildedInOrder() {
		Td td = new Td().colspan(2).headers("#").rowspan(2);
		assertEquals("<td colspan=\"2\" headers=\"#\" rowspan=\"2\"></td>", td.toHtml());
	}

	@Test
	public void textWith2RowsAnd3Columns() {
		Td td = new Td().append("text").rowspan(2).colspan(3);
		assertEquals("<td colspan=\"3\" rowspan=\"2\">text</td>", td.toHtml());
	}

	@Test
	public void withSpan() {
		Td td = new Td().append(new Span());
		assertEquals("<td><span></span></td>", td.toHtml());
	}
}
