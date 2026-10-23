package com.adda247.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** Reads config.properties; JVM system properties (-Dbrowser=firefox) take precedence. */
public final class ConfigReader {

    private static final Properties PROPS = new Properties();

    static {
        try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) {
                throw new IllegalStateException("config.properties not found on classpath");
            }
            PROPS.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load config.properties", e);
        }
    }

    private ConfigReader() {
    }

    public static String get(String key) {
        String override = System.getProperty(key);
        return (override != null && !override.isBlank() && !override.startsWith("${")) ? override : PROPS.getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key).trim());
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key).trim());
    }
}
