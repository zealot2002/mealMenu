package org.zzy.mealmenu.moudle.home.presenter;


import android.support.annotation.NonNull;

import org.zzy.aframwork.network.util.HttpConstant;
import org.zzy.aframwork.network.util.HttpInterface;
import org.zzy.aframwork.util.CommonUtil;
import org.zzy.mealmenu.R;
import org.zzy.mealmenu.moudle.application.MyApplication;
import org.zzy.mealmenu.moudle.home.HomeContract;
import org.zzy.mealmenu.moudle.home.model.DataProvider;
import org.zzy.mealmenu.moudle.home.model.Desk;
import org.zzy.mealmenu.moudle.home.model.Ent;
import org.zzy.mealmenu.moudle.home.model.HomeDataVo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.R.attr.data;
import static org.zzy.mealmenu.moudle.application.MyApplication.context;


/**
 * Created by admin on 16/11/7.
 */
public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;

    private HomeDataVo vo;
    /*****************************************************************************************************/

    public HomePresenter(@NonNull HomeContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        vo = new HomeDataVo();
    }

    @Override
    public void start() {

    }

    @Override
    public void getDeskList() {
        if (!CommonUtil.isNetWorkConnected(context)) {
            view.showDisconnect(context.getString(R.string.pls_check_your_network));
            return;
        }
        view.showLoading();
        DataProvider.getDeskList(new HttpInterface.DataCallback() {
            @Override
            public void requestCallback(int result, final Object data, Object tagData) {
                if (result == HttpConstant.SUCCESS) {
                    vo.setDeskList((List<Desk>) data);
                    getEntList();
                } else {
                    view.closeLoading();
                    view.showError(data.toString());
                }
            }
        });
    }

    @Override
    public void getEntList() {
        DataProvider.getEntList(new HttpInterface.DataCallback() {
            @Override
            public void requestCallback(int result, final Object data, Object tagData) {
                view.closeLoading();
                if (result == HttpConstant.SUCCESS) {
                    vo.setEntList((List<Ent>) data);
                    view.updateUI(vo);
                } else {
                    view.showError(data.toString());
                }
            }
        });
    }


}
