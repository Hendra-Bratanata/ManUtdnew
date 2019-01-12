package com.iamjue.manchesterunited;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.iamjue.manchesterunited.ADAPTER.ListViewAdapter;
import com.iamjue.manchesterunited.ApiRepository.ApiRepository;
import com.iamjue.manchesterunited.MODEL.PlayerItem;
import com.iamjue.manchesterunited.OnclickLibrary.ItemClickSupport;
import com.iamjue.manchesterunited.PRESENTER.Presenter;
import com.iamjue.manchesterunited.VIEW.MainView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Presenter presenter;
    ListViewAdapter adapter;
    ApiRepository apiRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new ListViewAdapter(this);
        apiRepository = new ApiRepository();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new Presenter(this,this,apiRepository);
        presenter.Load("Arsenal");

    }


    @Override
    public void showData(ArrayList<PlayerItem> player) {
        adapter.setPlayerItemList(player);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.arsenal:
               presenter.Load("Arsenal");
               break;
           case R.id.chelsea:
               presenter.Load("Chelsea");
               break;
       }
       return  true;
    }
}

