package org.zzy.mealmenu.constant;

/**
 * Created by zhaoziying on 2017/8/11.
 */

public class HttpConstant {
    public static final int TIMER_OUT = 120;
    public static final int ERROR_NO_ERROR = 200;
    public static final int PAGE_SIZE = 20;
    public static final String HTTP_ERROR = "code";
    public static final String HTTP_MESSAGE = "message";
    public static final String DATA = "data";
    public static final String MENU_TYPE_CHILDREN = "Children";
    public static final String MENU_TYPE_GAME = "Game";

    public static final String SERVER_URL = "http://192.168.160.126:8004";

    public static final String IMAGE_SERVER_URL = SERVER_URL + "/upload-file";

//    public static final String SERVER_URL = "http://192.168.175.219:3000";
//

    public static final String ENT_LIST = SERVER_URL + "/ent/all";
    public static final String DESK_LIST = SERVER_URL + "/desk/all";

}
