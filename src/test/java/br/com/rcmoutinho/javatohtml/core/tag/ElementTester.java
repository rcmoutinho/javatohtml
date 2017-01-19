package br.com.rcmoutinho.javatohtml.core.tag;

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
		int unsupportedTagCount = 0;

		for (Class<? extends Element<?>> clazz : classList) {
			try {

				if (Tag.class.equals(clazz))
					element.append(new Tag("myTag"));
				else
					element.append(clazz.newInstance());

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
		int unsupportedTagCount = 0;

		for (Class<? extends Element<?>> clazz : classList) {
			try {

				if (Tag.class.equals(clazz))
					element.prepend(new Tag("myTag"));
				else
					element.prepend(clazz.newInstance());

				throw new RuntimeException("This tag should be supported: " + clazz);
				
			} catch (UnsupportedTagException e) {
				unsupportedTagCount++;

			} catch (Exception e) {
				throw new RuntimeException("Unexpected problem", e);
			}
		}

		return unsupportedTagCount;
	}
}
