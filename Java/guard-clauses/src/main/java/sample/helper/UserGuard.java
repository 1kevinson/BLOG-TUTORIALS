package sample.helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.exception.ContextedException;

import java.util.Objects;

import static java.lang.Boolean.TRUE;

@Slf4j
public class UserGuard {

    private UserGuard() {
        log.info("Utility class {} should not be instantiate", this.getClass().getName());
    }

    public static void againstInvalidUser(Object username) throws ContextedException {
        if (againstNull(username) && againstEmpty(username)) {
            throw new ContextedException("User name is required.")
                    .addContextValue("Username", username);
        }
    }

    public static void againstInvalidPassword(Object password) throws ContextedException {
        if (againstNull(password) && againstEmpty(password)) {
            throw new ContextedException("Password is required.")
                    .addContextValue("Password", password);
        }
    }

    public static void againstInvalidEmail(Object email) throws ContextedException {
        if (TRUE.equals(againstNull(email)) && email.toString().contains("@")) {
            throw new ContextedException("Should should be a valid email.")
                    .addContextValue("Email", email);
        }
    }

    public static Boolean againstNull(Object object) {
        return Objects.isNull(object);
    }

    public static Boolean againstEmpty(Object object) {
        return ObjectUtils.isEmpty(object);
    }
}
