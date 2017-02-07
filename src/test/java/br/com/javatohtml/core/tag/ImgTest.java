package br.com.javatohtml.core.tag;

import static br.com.javatohtml.core.ElementTestUtil.countSupportedTagToAppend;
import static br.com.javatohtml.core.ElementTestUtil.countSupportedTagToPrepend;
import static br.com.javatohtml.core.ElementTestUtil.countUnsupportedTagExceptionToAppend;
import static br.com.javatohtml.core.ElementTestUtil.countUnsupportedTagExceptionToPrepend;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.javatohtml.core.Element;
import br.com.javatohtml.core.ElementUtils;
import br.com.javatohtml.core.exception.UnsupportedTagException;

/**
 * Unit test for {@link Img}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 26 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class ImgTest {

	private Class<? extends Element<?>> implClass;
	private List<Class<? extends Element<?>>> supportedElements;
	private List<Class<? extends Element<?>>> notSupportedElements;

	@Before
	public void beforeTesting() {
		this.implClass = Img.class;
		this.supportedElements = new Img().getSupportedElements();

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
	public void checkUnsupportedElementsToAppend() {
		int unsupportedTagCount = countUnsupportedTagExceptionToAppend(this.implClass, this.notSupportedElements);
		assertEquals(unsupportedTagCount, this.notSupportedElements.size());
	}

	@Test
	public void checkUnsupportedElementsToPrepend() {
		int unsupportedTagCount = countUnsupportedTagExceptionToPrepend(this.implClass, this.notSupportedElements);
		assertEquals(unsupportedTagCount, this.notSupportedElements.size());
	}

	@Test(expected = UnsupportedTagException.class)
	public void checkUnsupportedStringToAppend() {
		new Img().append("text");
	}

	@Test(expected = UnsupportedTagException.class)
	public void checkUnsupportedStringToPrepend() {
		new Img().prepend("text");
	}

	@Test
	public void emptyAttrsGenerateSimpleTag() {
		Img img = new Img().alt("").height("").src("").width("");
		assertEquals("<img />", img.toHtml());
	}

	@Test
	public void fullAttrsBuildedInOrder() {
		Img img = new Img().height("#").width("#").src("#").alt("#");
		assertEquals("<img alt=\"#\" height=\"#\" src=\"#\" width=\"#\" />", img.toHtml());
	}

	@Test
	public void img10x10() {
		Img img = new Img().height("10").width("10").src("hello.png");
		assertEquals("<img height=\"10\" src=\"hello.png\" width=\"10\" />", img.toHtml());
	}
}
