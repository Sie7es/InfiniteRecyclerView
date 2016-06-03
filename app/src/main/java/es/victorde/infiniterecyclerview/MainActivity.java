package es.victorde.infiniterecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    private RecyclerView myRecyclerView;
    private List<Item> mItemList;
    private AdapterRecyclerView myRecylerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.my_recyclerview);

        createItemList();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        final android.support.v7.widget.LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        myRecyclerView.setLayoutManager(mLayoutManager);
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());

        myRecylerViewAdapter = new AdapterRecyclerView(this, mItemList);
        myRecyclerView.setAdapter(myRecylerViewAdapter);

        mLayoutManager.scrollToPosition(Integer.MAX_VALUE / 2);
    }

    private void createItemList() {
        mItemList = new ArrayList<>();

        for (int cont = 0; cont < 60; cont++) {
            mItemList.add(new Item("Nombre: " + String.valueOf(cont)));
        }
    }
}
