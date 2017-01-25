package br.com.rcmoutinho.javatohtml.core;

import java.util.List;

import br.com.rcmoutinho.javatohtml.core.exception.UnsupportedTagException;
import br.com.rcmoutinho.javatohtml.core.tag.Tag;

/**
 * Helper methods to facilitate {@link Element} unit test.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 17 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class ElementTester {

	/**
	 * Tests the {@link Element} to append a {@link String} and generate an
	 * error if something went wrong.
	 * 
	 * @param elementName
	 *            implementation name
	 * @param elementClass
	 *            implementation class
	 */
	public void testStringToAppend(String elementName, Class<? extends Element<?>> elementClass) {
		testString(elementName, elementClass, ElementMethod.APPEND);
	}

	/**
	 * Tests the {@link Element} to prepend a {@link String} and generate an
	 * error if something went wrong.
	 * 
	 * @param elementName
	 *            implementation name
	 * @param elementClass
	 *            implementation class
	 */
	public void testStringToPrepend(String elementName, Class<? extends Element<?>> elementClass) {
		testString(elementName, elementClass, ElementMethod.PREPEND);
	}

	/**
	 * Tests the {@link Element}, according to {@link ElementMethod}, to add a
	 * {@link String} and generate an error if something went wrong.
	 * 
	 * @param elementName
	 *            implementation name
	 * @param elementClass
	 *            implementation class
	 */
	private void testString(String elementName, Class<? extends Element<?>> elementClass, ElementMethod elementMethod) {

		try {
			String value = "text";
			Element<?> element = newInstance(elementClass);

			if (ElementMethod.APPEND == elementMethod) {
				element.append(value);

			} else if (ElementMethod.PREPEND == elementMethod) {
				element.prepend(value);

			} else {
				throw new RuntimeException("Test to element's method not supported: " + elementMethod);
			}

			String expected;
			if (element.hasEndTag()) {
				expected = "<" + elementName + " />";

			} else {
				expected = "<" + elementName + ">" + value + "</" + elementName + ">";
			}

			String actual = element.toHtml();
			if (!expected.equals(actual))
				throw new RuntimeException(
						"HTML not matching. Expected is [" + expected + "] different from actual [" + actual + "].");

		} catch (Exception e) {
			throw new RuntimeException("Unexpected problem", e);
		}
	}

	/**
	 * Counts the {@link UnsupportedTagException} to append on {@link Element}
	 * according to the list.
	 * 
	 * @param element
	 *            element to test
	 * @param classList
	 *            all unsupported classes
	 * @return
	 */
	public int countUnsupportedTagExceptionToAppend(Element<?> element, List<Class<? extends Element<?>>> classList) {

		return this.countUnsupportedTagException(element, classList, ElementMethod.APPEND);
	}

	/**
	 * Counts the {@link UnsupportedTagException} to prepend on {@link Element}
	 * according to the list.
	 * 
	 * @param element
	 *            element to test
	 * @param classList
	 *            all unsupported classes
	 * @return
	 */
	public int countUnsupportedTagExceptionToPrepend(Element<?> element, List<Class<? extends Element<?>>> classList) {

		return this.countUnsupportedTagException(element, classList, ElementMethod.PREPEND);
	}

	/**
	 * Counts the {@link UnsupportedTagException} to {@link ElementMethod} on
	 * {@link Element} according to the list.
	 * 
	 * @param element
	 *            element to test
	 * @param classList
	 *            all unsupported classes
	 * @return
	 */
	private int countUnsupportedTagException(Element<?> element, List<Class<? extends Element<?>>> classList,
			ElementMethod elementMethod) {

		int unsupportedTagCount = 0;

		for (Class<? extends Element<?>> clazz : classList) {

			try {
				Element<?> newInstance = newInstance(clazz);
				
				if (ElementMethod.APPEND == elementMethod) {
					element.append(newInstance);

				} else if (ElementMethod.PREPEND == elementMethod) {
					element.prepend(newInstance);

				} else {
					throw new RuntimeException("Test to element's method not supported: " + elementMethod);
				}

				throw new RuntimeException("This tag should be supported: " + clazz);

			} catch (UnsupportedTagException e) {
				unsupportedTagCount++;

			} catch (Exception e) {
				throw new RuntimeException("Unexpected problem", e);
			}
		}

		return unsupportedTagCount;
	}

	/**
	 * Handles how to instantiate an {@link Element} implementation.
	 * 
	 * @param elementClass
	 *            element implementation
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private Element<?> newInstance(Class<? extends Element<?>> elementClass)
			throws InstantiationException, IllegalAccessException {

		Element<?> element;

		if (Tag.class.equals(elementClass)) {
			element = new Tag("tag"); // no default constructor available

		} else {
			element = elementClass.newInstance();
		}

		return element;
	}

	/**
	 * Element's methods to be tested.
	 * 
	 * @rcmoutinho
	 * @author rodrigo.moutinho
	 * @date 20 de jan de 2017
	 * @email rcm1989@gmail.com
	 */
	private enum ElementMethod {
		APPEND, PREPEND;
	}
}
