package com.supergeekdeveloper.idioms;


import android.app.Fragment;
import android.app.FragmentTransaction;

import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;


import com.supergeekdeveloper.idioms.adapters.TabsPagerAdapter;
import com.supergeekdeveloper.idioms.model.AlphabetModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AlphabetActivity extends FragmentActivity implements
        ActionBar.TabListener {
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    AlphabetAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<AlphabetModel> al;
    AlphaInter af;

    String c="a";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_alphabet);
        viewPager =  findViewById(R.id.pager);
        actionBar = getActionBar();
        /*mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        af=mAdapter.getAlphabetFragment();
        if(af==null)
            Log.e("abc","null");
        else Log.e("abc","no");

        viewPager.setAdapter(mAdapter);*/
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 0; i < 26; i++) {
            char ch=(char)(65+i);
            String s=ch+"";
            actionBar.addTab(actionBar.newTab().setText(s).setTabListener(this));

        }


        al=new ArrayList<>();

        adapter=new AlphabetAdapter(this,al);
        recyclerView=findViewById(R.id.recycler);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

        loaddata(c);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        String c=tab.getText()+"";
        c=c.toLowerCase();
        //af.clear();
        if(al!=null)
        loaddata(c);

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
    public void loaddata(String s){
        s=s+".json";
        Log.e("abc",s);
        try {  al.clear();
           // af.clear();
            JSONObject object=new JSONObject(loadJSONFromAsset(s));
            JSONArray array=object.getJSONArray("idiom");
            for (int i=0;i<array.length();i++){
                JSONObject idiom=array.getJSONObject(i);
                String name=idiom.getString("name");
                if(name.length()>=2)
                name=name.substring(0,1).toUpperCase()+name.substring(1);
                JSONArray meaningarray=idiom.getJSONArray("meaning");
                String meaning=meaningarray.getString(0);
                int id=idiom.getInt("id");
               al.add(new AlphabetModel(id,name,meaning));

            }
            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}
