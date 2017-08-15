package org.zzy.mealmenu.moudle.home.model;


import android.graphics.Color;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.zzy.aframwork.network.HttpUtil;
import org.zzy.aframwork.network.util.HttpInterface;
import org.zzy.aframwork.network.util.RequestCtx;
import org.zzy.mealmenu.constant.HttpConstant;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.zzy.mealmenu.constant.HttpConstant.DESK_LIST;
import static org.zzy.mealmenu.constant.HttpConstant.ENT_LIST;

/**
 * Created by admin on 16/12/13.
 */

public class DataProvider {
    static HttpInterface.JsonParser getEntListJsonParser = new HttpInterface.JsonParser() {
        @Override
        public Object[] parse(String str) throws JSONException {
            List<Ent> entList = new ArrayList<>();
            JSONTokener jsonParser = new JSONTokener(str);
            JSONObject obj = (JSONObject) jsonParser.nextValue();
            int errorCode = obj.getInt(HttpConstant.HTTP_ERROR);
            if (errorCode == HttpConstant.ERROR_NO_ERROR) {
                JSONArray dataArray = obj.getJSONArray("data");
                for(int i=0;i<dataArray.length();i++){
                    JSONObject entObj = dataArray.getJSONObject(i);
                    Ent ent = new Ent();
                    ent.setId(entObj.getInt("id"));

                    ent.setPrice(entObj.getDouble("price"));
                    ent.setCreateTime(entObj.getString("createTime"));
                    ent.setStartTime(entObj.getString("startTime"));
                    ent.setEndTime(entObj.getString("endTime"));
                    ent.setChargedTime(entObj.getString("chargedTime"));
                    ent.setStatus(entObj.getString("status"));

                    //desk
                    JSONObject deskObj = entObj.getJSONObject("desk");
                    Desk desk = new Desk();
                    desk.setId(deskObj.getInt("id"));
                    desk.setName(deskObj.getString("name"));
                    desk.setStatus(deskObj.getString("status"));
                    ent.setDesk(desk);

                    //dish list
                    JSONArray dishArray = entObj.getJSONArray("dishList");
                    for(int j=0;j<dishArray.length();j++) {
                        JSONObject dishObj = dishArray.getJSONObject(j);
                        Dish dish = new Dish();
                        dish.setId(dishObj.getInt("id"));
                        dish.setName(dishObj.getString("name"));
                        dish.setCover(dishObj.getString("cover"));
                        dish.setPrice(dishObj.getDouble("price"));

                        ent.getDishList().add(dish);
                    }
                    entList.add(ent);
                }
            } else {
                String msg = obj.getString(HttpConstant.HTTP_MESSAGE);
                return new Object[]{org.zzy.aframwork.network.util.HttpConstant.FAIL, HttpUtil.getErrorMsg(msg, errorCode)};
            }
            return new Object[]{org.zzy.aframwork.network.util.HttpConstant.SUCCESS, entList};

        }
    };

    public static void getEntList(HttpInterface.DataCallback callback) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        String url = ENT_LIST;
        RequestCtx ctx = new RequestCtx.Builder(map)
                .methodAndUrl(org.zzy.aframwork.network.util.HttpConstant.HTTP_METHOD_GET, url)
                .callback(callback)
                .jsonParser(getEntListJsonParser)
                .timerout(HttpConstant.TIMER_OUT)
                .build();
        try {
            HttpUtil.getInstance().request(ctx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static HttpInterface.JsonParser getDeskListJsonParser = new HttpInterface.JsonParser() {
        @Override
        public Object[] parse(String str) throws JSONException {
            List<Desk> deskList = new ArrayList<>();
            JSONTokener jsonParser = new JSONTokener(str);
            JSONObject obj = (JSONObject) jsonParser.nextValue();
            int errorCode = obj.getInt(HttpConstant.HTTP_ERROR);
            if (errorCode == HttpConstant.ERROR_NO_ERROR) {
                JSONArray dataArray = obj.getJSONArray("data");
                for(int i=0;i<dataArray.length();i++){
                    JSONObject deskObj = dataArray.getJSONObject(i);
                    Desk desk = new Desk();
                    desk.setId(deskObj.getInt("id"));
                    desk.setName(deskObj.getString("name"));
                    desk.setStatus(deskObj.getString("status"));

                    deskList.add(desk);
                }
            } else {
                String msg = obj.getString(HttpConstant.HTTP_MESSAGE);
                return new Object[]{org.zzy.aframwork.network.util.HttpConstant.FAIL, HttpUtil.getErrorMsg(msg, errorCode)};
            }
            return new Object[]{org.zzy.aframwork.network.util.HttpConstant.SUCCESS, deskList};

        }
    };

    public static void getDeskList(HttpInterface.DataCallback callback) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        String url = DESK_LIST;
        RequestCtx ctx = new RequestCtx.Builder(map)
                .methodAndUrl(org.zzy.aframwork.network.util.HttpConstant.HTTP_METHOD_GET, url)
                .callback(callback)
                .jsonParser(getDeskListJsonParser)
                .timerout(HttpConstant.TIMER_OUT)
                .build();
        try {
            HttpUtil.getInstance().request(ctx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
