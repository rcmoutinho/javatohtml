package br.com.rcmoutinho.javatohtml.core.tag;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.rcmoutinho.javatohtml.core.Element;

/**
 * The implementation of &lt;table&gt;. <br>
 * <br>
 * Ref.: http://www.w3schools.com/tags/tag_table.asp
 * 
 * @rcmoutinho
 * @author rodrigo.moutinho
 * @date 4 de out de 2016
 * @email rcm1989@gmail.com
 */
public class Table extends Element<Table> {

	@Override
	protected String getName() {
		return "table";
	}

	@Override
	protected Map<String, String> getSpecificAttributesMap() {
		return new LinkedHashMap<String, String>();
	}

	@Override
	protected List<Class<? extends Element<?>>> getSupportedElements() {
		return Arrays.asList(Thead.class, Tbody.class, Tfoot.class, Tr.class);
	}
	
	@Override
	protected Table getType() {
		return this;
	}
	
	@Override
	protected boolean isStringValuesSupported() {
		return false;
	}
}
