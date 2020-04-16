package io.github.thang86.weathers.base;

/**
 * ThangTX2
 */
public class ViewNotAttachedException extends RuntimeException {

    ViewNotAttachedException() {
        super("Please call attachView() before proceeding!");
    }
}
