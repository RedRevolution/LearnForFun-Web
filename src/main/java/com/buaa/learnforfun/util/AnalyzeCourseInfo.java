package com.buaa.learnforfun.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyzeCourseInfo {

    public static String courseNameAnalyze(String courseName) {
        int len = courseName.length();
        String temp = courseName;
        if (courseName.substring(len - 5).equals("(全汉语)")) {
            temp = courseName.substring(0, len - 5);
        }
        return temp;
    }

    public static String teacherNameAnalyze(String info) {
        String[] courseInfo = info.split("◇");
        String temp = courseInfo[0].trim();
        int index = 0;
        if (temp.charAt(index) == '[') {
            while (temp.charAt(index) != ']') index++;
            index++;
        }
        temp = temp.substring(index);
        if (temp.length() > 15) {
            int index2 = 0;
            while (temp.charAt(index2) != ',') index2++;
            temp = temp.substring(0, index2 + 1) + "等";
        }
        return temp;
    }

    public static String classTimeAndLocationAnalyze(String info, String area) {
        List<List<String>> courseList = new ArrayList<>();
        String[] courseInfo = info.split("◇");
        boolean hasLocation = false;
        boolean hasTime = false;
        for (String i : courseInfo) {
            Pattern p = Pattern.compile("(\\S+)\\,\\[(\\S+)\\周\\]\\星\\期(\\S)\\第(\\S+)\\节");
            Matcher m = p.matcher(i);
            if (m.find()) {
                List<String> tmp = new ArrayList<>();
                tmp.add(m.group(2));
                tmp.add(m.group(3));
                tmp.add(m.group(4));
                tmp.add(m.group(1));
                hasLocation = true;
                hasTime = true;
                courseList.add(tmp);
                continue;
            }
            p = Pattern.compile("\\[(\\S+)\\周\\]\\星\\期(\\S)\\第(\\S+)\\节");
            m = p.matcher(i);
            if (m.find()) {
                List<String> tmp = new ArrayList<>();
                tmp.add(m.group(1));
                tmp.add(m.group(2));
                tmp.add(m.group(3));
                tmp.add("");
                hasTime = true;
                courseList.add(tmp);
                continue;
            }
        }
        int len = courseInfo.length;
        String location = courseInfo[len - 1];
        if (info.charAt(info.length()-1) == '◇') location = "";
        if (hasTime == false) return null;
        String ans = "";
        for (List<String> i : courseList) {
            ans += "[";
            ans += i.get(0);
            ans += "/";
            ans += i.get(1);
            ans += "/";
            ans += i.get(2);
            ans += "/";
            String loc = hasLocation ? i.get(3) : location;
            loc = area + loc;
            ans += loc;
            ans += "]";
        }
        return ans;
    }

}
