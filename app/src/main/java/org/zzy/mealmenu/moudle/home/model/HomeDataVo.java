package org.zzy.mealmenu.moudle.home.model;

import java.util.List;

/**
 * Created by zhaoziying on 2017/8/11.
 */

public class HomeDataVo {
    List<Ent> entList;
    List<Desk> deskList;

    public List<Ent> getEntList() {
        return entList;
    }

    public void setEntList(List<Ent> entList) {
        this.entList = entList;
    }

    public List<Desk> getDeskList() {
        return deskList;
    }

    public void setDeskList(List<Desk> deskList) {
        this.deskList = deskList;
    }
}
