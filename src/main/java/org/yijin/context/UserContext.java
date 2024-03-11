package org.yijin.context;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yijin.entity.User;

/**
 * @author YiJin840
 * @program inspiration
 * @description
 * @since 2024-03-11 12:11
 **/
public class UserContext {

    private static final ThreadLocal<User> USER_THREAD_LOCAL = new ThreadLocal<>();

    public static User get() {
        return USER_THREAD_LOCAL.get();
    }

    public static void set(User user) {
        USER_THREAD_LOCAL.set(user);
    }

    public static void remove() {
        USER_THREAD_LOCAL.remove();
    }

}
