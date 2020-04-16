package io.github.thang86.weathers.activity.search;

import java.util.List;

import io.github.thang86.weathers.base.BaseView;

public interface SearchView extends BaseView {

    void close();

    void showSuggestions(List<Object> list);

    public void clearSuggestions();

    void showEmpty();

    void showError();
}
