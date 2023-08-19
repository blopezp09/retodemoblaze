package co.com.sofka.utils;

import java.util.Locale;

public class OsUtils {
    public static String getOperatingSystemType() {
        String os = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        if (os.contains("win")) {
            return "windows";
        } else if (os.contains("nux")) {
            return "linux";
        } else {
            return "unknown";
        }
    }

    private OsUtils() {
        throw new IllegalStateException("Utility class");
    }
}
