package com.qpan.helper.tools.adapter;

import android.support.v4.app.Fragment;

import com.aspsine.fragmentnavigator.FragmentNavigatorAdapter;
import com.qpan.helper.tools.fragment.NavToolLocalFragment;
import com.qpan.helper.tools.fragment.TestNavFragment;
import com.qpan.helper.tools.util.Constant;

/**
 * Created by aspsine on 16/4/28.
 */
public class MainFragmentAdapter implements FragmentNavigatorAdapter {

    @Override
    public Fragment onCreateFragment(int position) {
        switch (position) {
            case 0:
                return NavToolLocalFragment.newInstance();

            case 1:
                return TestNavFragment.newInstance();

            case 2:
                return NavToolLocalFragment.newInstance();

            case 3:
                return TestNavFragment.newInstance();

            case 4:
                return NavToolLocalFragment.newInstance();
        }
        return null;
    }

    @Override
    public String getTag(int position) {
        return String.valueOf(position);
    }

    @Override
    public int getCount() {
        return Constant.FRAGMENTS_IDS.size();
    }
}