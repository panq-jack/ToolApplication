package com.qpan.helper.tools.util;

import com.qpan.helper.tools.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by panqian on 2016/8/3.
 */
public class Constant {
    //fragment的id  手动维护
    private static final Integer ID_ARRAY[] = {
            R.id.nav_home,
            R.id.nav_gallery,
            R.id.nav_slideshow,
            R.id.nav_manage
    };

    public static final List<Integer> FRAGMENTS_IDS = Arrays.asList(ID_ARRAY);
}
