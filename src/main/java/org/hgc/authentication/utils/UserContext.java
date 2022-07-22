package org.hgc.authentication.utils;

public class UserContext {

    private static final ThreadLocal<Long> userId = new ThreadLocal<>();

    public static void add (long id) {
        userId.set(id);
    }

    public static void remove () {
        userId.remove();
    }

    public static long getCurrentUserId() {
        return userId.get();
    }
}
