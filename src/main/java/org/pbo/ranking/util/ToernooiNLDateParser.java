package org.pbo.ranking.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToernooiNLDateParser {

    /**
        Eg input: 23 december 2017
     */
    public static Date ParseLongDescriptionDate(String input) throws ParseException {
        Pattern p = Pattern.compile("[a-z]* (\\d+ [a-z]+ \\d+)");
        Matcher m = p.matcher(input);
        m.find();
        String trimmedInput = m.group(1);
        Locale locale = new Locale("nl_NL");
        DateFormat df = SimpleDateFormat.getInstance();
        df = new SimpleDateFormat("dd MMMM yyyy", locale);
        return df.parse(trimmedInput);
    }
}
