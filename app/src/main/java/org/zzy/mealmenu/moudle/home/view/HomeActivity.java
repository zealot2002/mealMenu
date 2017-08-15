package org.zzy.mealmenu.moudle.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import org.zzy.mealmenu.R;
import org.zzy.mealmenu.moudle.BaseActivity;
import org.zzy.mealmenu.moudle.home.HomeContract;
import org.zzy.mealmenu.moudle.home.model.Ent;
import org.zzy.mealmenu.moudle.home.model.HomeDataVo;
import org.zzy.mealmenu.moudle.home.presenter.HomePresenter;
import org.zzy.mealmenu.widget.MyRecyclerView;

import java.util.List;

import static org.zzy.mealmenu.R.id.rvSection;

public class HomeActivity extends BaseActivity implements HomeContract.View,View.OnClickListener {
    private HomeDataVo vo;
    private HomeContract.Presenter presenter;
    private RecyclerView rvDesk;
    private HomeAdapter adapter;
    /*******************************************************************************************************/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {

            presenter = new HomePresenter(this);
            presenter.getDeskList();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,"Exception:" + e.toString(),Toast.LENGTH_SHORT).show();
        }
    }


    public void findViews() {
        setContentView(R.layout.activity_home);
        rvDesk = (RecyclerView) findViewById(R.id.rvDesk);

        rvDesk.setLayoutManager(new GridLayoutManager(this,4));
        adapter = new HomeAdapter(R.layout.desk_item,vo.getDeskList(),this);
        rvDesk.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }





    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void closeLoading() {

    }

    @Override
    public void showDisconnect(String s) {
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void updateUI(Object o) {
        try {
            vo = (HomeDataVo) o;
//            setBackground(vo.getBackground());
//
//            for (int i = 0; i < vo.getSectionList().size(); i++) {
//                ChannelDataVo.SectionBean sectionBean = vo.getSectionList().get(i);
//                SectionUtil.sortContentList(sectionBean.getTemplateId(), sectionBean.getContentList());
//            }

            findViews();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,"Exception:" + e.toString(),Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void setPresenter(Object o) {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (AppInstallReceiver.getInstance().isRegister()) {
//            unregisterReceiver(AppInstallReceiver.getInstance());
//        }
//        freeAll();
    }



    @Override
    public void onClick(View v) {
        Log.e("zzy","onItemChildClick");
    }
}
