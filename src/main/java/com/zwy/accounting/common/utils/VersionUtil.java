package com.zwy.accounting.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Afauria on 2019/4/1.
 */
public class VersionUtil {
    private VersionUtil() {

    }

    public static void main(String args[]) {
        System.out.println(nextRCVersion("1.0.1.rc-1"));
    }

    public static String nextRCVersion(String curVersion) {
        if (curVersion == null) {
            return "";
        }
        Pattern pattern = Pattern.compile("rc-(\\d+)");
        Matcher matcher = pattern.matcher(curVersion);
        if (matcher.find()) {
            Integer num = Integer.parseInt(matcher.group(1)) + 1;
            String nextVersion = curVersion.replace(matcher.group(0), "rc-" + num);
            return nextVersion;
        } else {
            return "";
        }
    }

    public static String nextReleaseVersion(String curVersion) {
        if (curVersion == null) {
            return "";
        }
        if (curVersion.contains("rc-")) {
            return curVersion.replaceAll("\\.rc-\\d+", "");
        } else {
            return "";
        }
    }
}
