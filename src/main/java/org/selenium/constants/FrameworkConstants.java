package org.selenium.constants;

public final class FrameworkConstants {

    private FrameworkConstants() {}

    private static final long EXPLICIT_WAIT = 30;

    public static long getExplicitWait() {
        return EXPLICIT_WAIT;
    }
}
