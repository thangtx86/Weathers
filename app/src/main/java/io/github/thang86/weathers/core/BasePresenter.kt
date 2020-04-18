package io.github.thang86.weathers.core

open class BasePresenter<T : BaseView> : MvpPresenter<T> {

    private var mView: T? = null

    override fun attachView(view: T) {
        this.mView = view
    }

    override fun detachView() {
        mView = null
    }

    open fun getMView(): T? {
        return this.mView
    }

    fun isViewAttached(): Boolean {
        return this.mView != null
    }

    fun checkViewAttached() {
        if (!isViewAttached()) throw ViewNotAttachedException()
    }
}