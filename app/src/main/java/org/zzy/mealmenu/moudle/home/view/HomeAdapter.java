package org.zzy.mealmenu.moudle.home.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.zzy.mealmenu.R;
import org.zzy.mealmenu.moudle.home.HomeContract;
import org.zzy.mealmenu.moudle.home.model.Desk;

import java.util.List;


/**
 * Created by zhaoziying on 2017/8/14.
 */

public class HomeAdapter extends BaseQuickAdapter<Desk, BaseViewHolder> {

    private List<Desk> dataList;
    private View.OnClickListener onClickListener;
    public HomeAdapter(int layoutResId, List data,View.OnClickListener onClickListener) {
        super(layoutResId, data);
        this.onClickListener = onClickListener;
    }

    @Override
    protected void convert(BaseViewHolder helper, Desk desk) {
        helper.setText(R.id.tvName,desk.getName());
        helper.setVisible(R.id.ivUsed,desk.getStatus().equals("使用中"));

        helper.getView(R.id.ivBg).setOnClickListener(onClickListener);
    }



}
