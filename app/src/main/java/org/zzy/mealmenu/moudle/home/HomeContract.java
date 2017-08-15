package org.zzy.mealmenu.moudle.home;


import org.zzy.aframwork.base.BaseLoadingView;
import org.zzy.aframwork.base.BasePresenter;

/**
 * Created by admin on 16/11/7.
 */
public class HomeContract {

    public interface View extends BaseLoadingView<Presenter> {

    }

    public interface Presenter extends BasePresenter {
        void getDeskList();
        void getEntList();
    }
}
