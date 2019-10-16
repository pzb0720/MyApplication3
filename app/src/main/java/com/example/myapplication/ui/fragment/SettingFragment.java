package com.example.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.util.CacheDataManager;


public class SettingFragment extends PreferenceFragmentCompat {
    Preference cleanCache;
    Preference exit;
    CheckBoxPreference showTopArticle;

    public static SettingFragment newInstance() {
        Bundle args = new Bundle();
        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) super.onCreateView(inflater, container, savedInstanceState);

//        for (int i = 0; i < view.getChildCount(); i++) {
//            View view1 = view.getChildAt(i);
//            view1.setPadding(0, 0, 0, 0);
//
//        }
        if (view != null) {
            Log.i("哇哈哈", "view" + view.getChildCount());
            View listView = view.findViewById(android.R.id.list);

            for (int i = 0; i < view.getChildCount(); i++) {
                View view1 = view.getChildAt(i);
                view1.setPadding(0, view1.getPaddingTop(), 0, view1.getPaddingBottom());
            }

            if (listView != null) {
                Log.i("哇哈哈", "viewlist");
                listView.setPadding(0, listView.getPaddingTop(), 0, listView.getPaddingBottom());
            }
        }

        return view;
    }

    private void initView() {


        cleanCache = getPreferenceManager().findPreference("key_clean_cache");
        cleanCache.setSummary(CacheDataManager.getCacheSize(getActivity()));
        cleanCache.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Log.i("哇哈哈", "cleanCache 点击事件");
                return true;
            }
        });

        exit = getPreferenceManager().findPreference(getString(R.string.key_exit));
        exit.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Log.i("哇哈哈", " exit 点击事件");
                return true;
            }
        });

        showTopArticle = (CheckBoxPreference) getPreferenceManager().findPreference("key_show_top_article");
        showTopArticle.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Log.i("哇哈哈", " showTopArticle 点击事件");
                return true;
            }
        });
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preference_setting);
        initView();
    }
}
