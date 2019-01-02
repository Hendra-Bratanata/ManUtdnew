package com.iamjue.manchesterunited;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.iamjue.manchesterunited.OnclickLibrary.ItemClickSupport;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    ListViewAdapter adapter;
    private ArrayList<PlayerItem> playerItemList;
    String TAG = "TEST";

    private static String URL = "https://www.thesportsdb.com/api/v1/json/1/searchplayers.php?t=Man%United";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new ListViewAdapter(this);
        playerItemList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Load();
    }




       private void Load(){

            StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject object = new JSONObject(response);
                        JSONArray playerArray = object.getJSONArray("player");
                        for (int i = 0; i < playerArray.length(); i++) {
                            JSONObject playerObject = playerArray.getJSONObject(i);
                            PlayerItem playerItem = new PlayerItem(playerObject.getString("strPlayer"),
                                    playerObject.getString("dateBorn"),
                                    playerObject.getString("dateSigned"),
                                    playerObject.getString("strPosition"),
                                    playerObject.getString("strThumb"),
                                    playerObject.getString("strNationality"),
                                    playerObject.getString("strBirthLocation"),
                                    playerObject.getString("strDescriptionEN"),
                                    playerObject.getString("strHeight"),
                                    playerObject.getString("strWeight"),
                                    playerObject.getString("strTwitter"),
                                    playerObject.getString("strInstagram"));
                            Log.d("text", "onResponse: "+playerItem.getStrPlayer());
                            playerItemList.add(playerItem);
                        }

                        adapter.setPlayerItemList(playerItemList);
                        adapter.notifyDataSetChanged();
                        recyclerView.setAdapter(adapter);
                        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                            @Override
                            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                              showClick(playerItemList.get(position));
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            requestQueue.add(stringRequest);


    }
    public void  showClick(PlayerItem item){
        Toast.makeText(this,"Anda mengclik"+item.getStrPlayer(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Detail.class);
        intent.putExtra("player",item);
        startActivity(intent);
    }
}

