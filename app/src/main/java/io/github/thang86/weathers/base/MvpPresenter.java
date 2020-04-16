package io.github.thang86.weathers.base;

/**
 * ThangTX2
 */
public interface MvpPresenter<V extends BaseView> {

    /**
     * attcht the view
     *
     * @param view
     */
    void attachView(V view);

    /**
     * detach the view
     */
    void detachView();
}
