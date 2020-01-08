package com.arbelkilani.clock.global;

import java.util.TreeMap;

public class ClockUtils {

    private final static TreeMap<Integer, String> romanMap = new TreeMap<Integer, String>();
    private final static TreeMap<Integer, String> arabicMap = new TreeMap<Integer, String>();

    static {

        romanMap.put(12, "XII");
        romanMap.put(11, "XI");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");

        romanMap.put(8, "VIII");
        romanMap.put(7, "VII");
        romanMap.put(6, "VI");
        romanMap.put(5, "V");

        romanMap.put(4, "IV");
        romanMap.put(3, "III");
        romanMap.put(2, "II");
        romanMap.put(1, "I");

    }

    static {

        arabicMap.put(12, "١٢");
        arabicMap.put(11, "١١");
        arabicMap.put(10, "١٠\t");
        arabicMap.put(9, "٩");

        arabicMap.put(8, "٨");
        arabicMap.put(7, "٧");
        arabicMap.put(6, "٦");
        arabicMap.put(5, "٥");

        arabicMap.put(4, "٤");
        arabicMap.put(3, "٣");
        arabicMap.put(2, "٢");
        arabicMap.put(1, "١");

    }

    public final static String toRoman(int number) {
        int l =  romanMap.floorKey(number);
        if ( number == l ) {
            return romanMap.get(number);
        }
        return romanMap.get(l) + toRoman(number-l);
    }

    public final static String toArabic(int number) {
        int l =  arabicMap.floorKey(number);
        if ( number == l ) {
            return arabicMap.get(number);
        }
        return arabicMap.get(l) + toArabic(number-l);
    }
}
