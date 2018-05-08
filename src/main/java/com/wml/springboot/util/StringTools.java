package com.wml.springboot.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * <pre>
 * <b>Title：</b>StringTools.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/5/8 - 17:22<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class StringTools {

    public static boolean isEmptyString(String value)
    {
        return (value == null) || ("".equals(value.trim()));
    }

    public static boolean isNotEmptyString(String value)
    {
        return (value != null) && (!"".equals(value.trim()));
    }

    public static String addZeroForNum(String str, int strLength)
    {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength)
            {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }

    public static String null2Str(String str)
    {
        if (null == str) {
            return "";
        }
        return str;
    }

    private static Pattern pattern = Pattern.compile("([\\p{Punct}&&[^\\$\\\\]])");

    public static String escapeRegex(String original)
    {
        Matcher matcher = pattern.matcher(escapeDollarBackslash(original));
        StringBuffer buffer = new StringBuffer();
        while (matcher.find())
        {
            String group = matcher.group();
            matcher.appendReplacement(buffer, "\\\\" + group);
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    public static String escapeDollarBackslash(String original)
    {
        if (null == original) {
            return "";
        }
        StringBuffer buffer = new StringBuffer(original.length());
        for (int i = 0; i < original.length(); i++)
        {
            char c = original.charAt(i);
            if ((c == '\\') || (c == '$')) {
                buffer.append("\\").append(c);
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    public static String legalString(String illegalChar, String str)
    {
        for (int i = 0; i < illegalChar.length(); i++) {
            if (str.indexOf(illegalChar.charAt(i)) != -1) {
                str = str.replace(String.valueOf(illegalChar.charAt(i)), "");
            }
        }
        return str;
    }

    public static String legalFileName(String fileName)
    {
        String illegalChar = "\\/:*?<>|\"";
        return legalString(illegalChar, fileName);
    }

}
