package com.qpan.helper.tools.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.qpan.helper.tools.R;

/**
 * Created by aspsine on 15/9/8.
 */
public class BaseToolbarFragment extends BaseFragment {

    public interface ToggleDrawerCallBack {
        void openDrawer();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);  // If true, the fragment has menu items to contribute.
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            final ActionBar actionbar = getSupportActionBar();
//            actionbar.setHomeAsUpIndicator(R.mipmap.ic_menu);
            actionbar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ((ToggleDrawerCallBack) getActivity()).openDrawer();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public ActionBar getSupportActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    protected void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }
}
