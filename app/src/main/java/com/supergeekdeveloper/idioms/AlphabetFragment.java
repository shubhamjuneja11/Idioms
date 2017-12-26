package com.supergeekdeveloper.idioms;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.supergeekdeveloper.idioms.model.AlphabetModel;

import java.util.ArrayList;

public class AlphabetFragment extends Fragment implements AlphaInter {
    AlphabetAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<AlphabetModel> al;
    public AlphabetFragment(){
        al=new ArrayList<>();
        Log.e("abc","new");
        adapter=new AlphabetAdapter(getContext(),al);

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.e("abc","rr");
        View view=inflater.inflate(R.layout.activity_alphabet_fragment,container,false);
        recyclerView=view.findViewById(R.id.recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        Log.e("abc","12");
        return view;
    }

    @Override
    public void clear() {
        Log.e("abc","clear");
        if(al!=null)
        al.clear();
    }

    @Override
    public void addData(AlphabetModel model) {
        Log.e("abc","add");
      al.add(model);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void notifyme() {
        Log.e("abc","notify");
        adapter.notifyDataSetChanged();
    }
}
