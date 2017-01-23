package br.com.rcmoutinho.javatohtml.core;

import java.util.List;

import br.com.rcmoutinho.javatohtml.core.Element;
import br.com.rcmoutinho.javatohtml.core.exception.UnsupportedTagException;

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
	 * Counts the {@link UnsupportedTagException} to append on {@link Element}
	 * according to the list.
	 * 
	 * @param element
	 *            element to test
	 * @param classList
	 *            all unsupported classes
	 * @return
	 */
	protected int countUnsupportedTagExceptionToAppend(Element<?> element,
			List<Class<? extends Element<?>>> classList) {

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
	protected int countUnsupportedTagExceptionToPrepend(Element<?> element,
			List<Class<? extends Element<?>>> classList) {

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
				if (ElementMethod.APPEND == elementMethod) {
					element.append(clazz.newInstance());

				} else if (ElementMethod.PREPEND == elementMethod) {
					element.prepend(clazz.newInstance());

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
