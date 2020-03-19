package com.cucu.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetCommon {
    public String getdomain(String url) {
        String pattern = "[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)" ;
        Pattern p = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        matcher.find();
        return matcher.group();
    }
    
    public String getDate() {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	Date t = new Date();
    	String date = df.format(t);
    	return date;
    }
}
