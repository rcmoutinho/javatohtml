package com.javatohtml.core.tag;

import static com.javatohtml.core.ElementTestUtil.countSupportedTagToAppend;
import static com.javatohtml.core.ElementTestUtil.countSupportedTagToPrepend;
import static com.javatohtml.core.ElementTestUtil.countUnsupportedTagExceptionToAppend;
import static com.javatohtml.core.ElementTestUtil.countUnsupportedTagExceptionToPrepend;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.javatohtml.core.Element;
import com.javatohtml.core.ElementUtils;
import com.javatohtml.core.exception.UnsupportedTagException;
import com.javatohtml.core.tag.Table;

/**
 * Unit test for {@link Table}.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 10 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class TableTest {

	private Class<? extends Element<?>> implClass;
	private List<Class<? extends Element<?>>> supportedElements;
	private List<Class<? extends Element<?>>> notSupportedElements;

	@Before
	public void beforeTesting() {
		this.implClass = Table.class;
		this.supportedElements = new Table().getSupportedElements();

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
		new Table().append("text");
	}

	@Test(expected = UnsupportedTagException.class)
	public void checkUnsupportedStringToPrepend() {
		new Table().prepend("text");
	}
}
