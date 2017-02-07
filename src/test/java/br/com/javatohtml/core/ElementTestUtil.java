package br.com.javatohtml.core;

import java.util.List;

import br.com.javatohtml.core.exception.UnsupportedTagException;
import br.com.javatohtml.core.tag.Tag;

/**
 * Helper methods to facilitate {@link Element} unit test.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 17 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class ElementTestUtil {

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

	/**
	 * Counts the supported {@link Element} to append according to the
	 * {@link Element} list. If something went wrong, generate a clarifying
	 * error.
	 * 
	 * @param elementClass
	 *            implementation to test
	 * @param classList
	 *            all supported classes
	 * @return
	 */
	public static int countSupportedTagToAppend(Class<? extends Element<?>> elementClass,
			List<Class<? extends Element<?>>> classList) {

		return countSupportedTag(elementClass, classList, ElementMethod.APPEND);
	}

	/**
	 * Counts the supported {@link Element} to prepend according to the
	 * {@link Element} list. If something went wrong, generate a clarifying
	 * error.
	 * 
	 * @param elementClass
	 *            implementation to test
	 * @param classList
	 *            all supported classes
	 * @return
	 */
	public static int countSupportedTagToPrepend(Class<? extends Element<?>> elementClass,
			List<Class<? extends Element<?>>> classList) {

		return countSupportedTag(elementClass, classList, ElementMethod.PREPEND);
	}

	/**
	 * Counts the {@link UnsupportedTagException} to append on {@link Element}
	 * according to the list.
	 * 
	 * @param elementClass
	 *            implementation class
	 * @param classList
	 *            all unsupported classes
	 * @return
	 */
	public static int countUnsupportedTagExceptionToAppend(Class<? extends Element<?>> elementClass,
			List<Class<? extends Element<?>>> classList) {

		return countUnsupportedTagException(elementClass, classList, ElementMethod.APPEND);
	}

	/**
	 * Counts the {@link UnsupportedTagException} to prepend on {@link Element}
	 * according to the list.
	 * 
	 * @param elementClass
	 *            implementation class
	 * @param classList
	 *            all unsupported classes
	 * @return
	 */
	public static int countUnsupportedTagExceptionToPrepend(Class<? extends Element<?>> elementClass,
			List<Class<? extends Element<?>>> classList) {

		return countUnsupportedTagException(elementClass, classList, ElementMethod.PREPEND);
	}

	/**
	 * Tests the {@link Element} to append a {@link String} and generate an
	 * error if something went wrong.
	 * 
	 * @param elementClass
	 *            implementation class
	 */
	public static void testStringToAppend(Class<? extends Element<?>> elementClass) {
		testString(elementClass, ElementMethod.APPEND);
	}

	/**
	 * Tests the {@link Element} to prepend a {@link String} and generate an
	 * error if something went wrong.
	 * 
	 * @param elementClass
	 *            implementation class
	 */
	public static void testStringToPrepend(Class<? extends Element<?>> elementClass) {
		testString(elementClass, ElementMethod.PREPEND);
	}

	/**
	 * Counts the supported {@link Element} to {@link ElementMethod} according
	 * to the {@link Element} list. If something went wrong, generate a
	 * clarifying error.
	 * 
	 * @param elementClass
	 *            implementation to test
	 * @param classList
	 *            all supported classes
	 * @param elementMethod
	 *            method to test
	 * @return
	 */
	private static int countSupportedTag(Class<? extends Element<?>> elementClass,
			List<Class<? extends Element<?>>> classList, ElementMethod elementMethod) {

		int supportedTagCount = 0;

		for (Class<? extends Element<?>> clazz : classList) {

			Element<?> element = newInstance(elementClass);
			Element<?> newInstance = newInstance(clazz);

			if (ElementMethod.APPEND == elementMethod) {
				element.append(newInstance);

			} else if (ElementMethod.PREPEND == elementMethod) {
				element.prepend(newInstance);

			} else {
				throw new RuntimeException("Test to element's method not supported: " + elementMethod);
			}

			String expected = "<" + element.getName() + ">" + newInstance.toHtml() + "</" + element.getName() + ">";
			String actual = element.toHtml();

			if (!expected.equals(actual))
				throw new RuntimeException(
						"HTML not matching. Expected is [" + expected + "] different from actual [" + actual + "].");

			supportedTagCount++;
		}

		return supportedTagCount;
	}

	/**
	 * Counts the {@link UnsupportedTagException} to {@link ElementMethod} on
	 * {@link Element} according to the list.
	 * 
	 * @param elementClass
	 *            element implementation
	 * @param classList
	 *            all unsupported classes
	 * @return
	 */
	private static int countUnsupportedTagException(Class<? extends Element<?>> elementClass,
			List<Class<? extends Element<?>>> classList, ElementMethod elementMethod) {

		int unsupportedTagCount = 0;
		Element<?> element = newInstance(elementClass);

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
	 */
	private static Element<?> newInstance(Class<? extends Element<?>> elementClass) {

		Element<?> element;

		try {
			if (Tag.class.equals(elementClass)) {
				element = new Tag("tag"); // no default constructor available

			} else {
				element = elementClass.newInstance();
			}

		} catch (Exception e) {
			throw new RuntimeException("Unexpected problem", e);
		}

		return element;
	}

	/**
	 * Tests the {@link Element}, according to {@link ElementMethod}, to add a
	 * {@link String} and generate an error if something went wrong.
	 * 
	 * @param elementClass
	 *            implementation class
	 */
	private static void testString(Class<? extends Element<?>> elementClass, ElementMethod elementMethod) {

		String value = "text";
		Element<?> element = newInstance(elementClass);

		if (ElementMethod.APPEND == elementMethod) {
			element.append(value);

		} else if (ElementMethod.PREPEND == elementMethod) {
			element.prepend(value);

		} else {
			throw new RuntimeException("Test to element's method not supported: " + elementMethod);
		}

		String expected = "<" + element.getName() + ">" + value + "</" + element.getName() + ">";
		String actual = element.toHtml();

		if (!expected.equals(actual))
			throw new RuntimeException(
					"HTML not matching. Expected is [" + expected + "] different from actual [" + actual + "].");
	}

	private ElementTestUtil() {
	}
}
