package io.github.thang86.weathers.base;

/**
 * ThangTX2
 */
public class BasePresenter<T extends BaseView> implements MvpPresenter<T> {
    private T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;

    }

    /**
     * Method geter get view
     *
     * @return
     */
    public T getMView() {
        return this.mView;
    }


    public boolean isViewAttached() {
        return this.mView != null;
    }

    /**
     * Method check view attached
     *
     * @return
     */
    public void checkViewAttached() {
        if (!isViewAttached()) throw new ViewNotAttachedException();
    }
}
