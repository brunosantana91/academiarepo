package br.com.academia.beans.util.formatters;

import java.util.regex.Pattern;

import br.com.caelum.stella.format.BaseFormatter;
import br.com.caelum.stella.format.Formatter;

public class RGFormatter implements Formatter{

	private final BaseFormatter base;
	public static final Pattern FORMATED = Pattern.compile("(\\d{2})[.](\\d{3})[.](\\d{3})-(\\d{1})");
	public static final Pattern UNFORMATED = Pattern.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{1})");
	
    public RGFormatter() {
        this.base = new BaseFormatter(FORMATED, "$1.$2.$3-$4", UNFORMATED, "$1$2$3$4");
    }
	
	public String format(String value) throws IllegalArgumentException {
		return base.format(value);
	}

	public String unformat(String value) throws IllegalArgumentException {
		return base.unformat(value);
	}

	public boolean isFormatted(String value) {
		return base.isFormatted(value);
	}

	public boolean canBeFormatted(String value) {
		return base.canBeFormatted(value);
	}

}
