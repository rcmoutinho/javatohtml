package br.com.javatohtml.core.exception;

/**
 * Exception thrown when a tag is not supported from another. For example, if
 * you try to put a &lt;div&gt; inside a &lt;tr&gt;.
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 14 de jan de 2017
 * @email rcm1989@gmail.com
 */
public class UnsupportedTagException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a UnsupportedTagException.
	 * 
	 * @param message
	 *            description of the exception
	 */
	public UnsupportedTagException(final String message) {
		super(message);
	}

	/**
	 * Constructs a UnsupportedTagException.
	 * 
	 * @param cause
	 *            cause of the exception
	 * @since upcoming
	 */
	public UnsupportedTagException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a UnsupportedTagException.
	 * 
	 * @param message
	 *            description of the exception
	 * @param cause
	 *            cause of the exception
	 * @since upcoming
	 */
	public UnsupportedTagException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
