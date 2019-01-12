package com.iamjue.manchesterunited.PRESENTER;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.iamjue.manchesterunited.ApiRepository.ApiRepository;
import com.iamjue.manchesterunited.MODEL.PlayerItem;
import com.iamjue.manchesterunited.MainActivity;
import com.iamjue.manchesterunited.OnclickLibrary.ItemClickSupport;
import com.iamjue.manchesterunited.VIEW.MainView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Presenter {


    public MainView getView() {
        return view;
    }

    public void setView(MainView view) {
        this.view = view;
    }

    public StringRequest getStringRequest() {
        return stringRequest;
    }

    public void setStringRequest(StringRequest stringRequest) {
        this.stringRequest = stringRequest;
    }

    MainView view;
    StringRequest stringRequest;

    public ApiRepository getApiRepository() {
        return apiRepository;
    }

    public void setApiRepository(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    ApiRepository apiRepository;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    Context context;

    public Presenter(Context context, MainView view,ApiRepository apiRepository) {
        this.view = view;
        this.context = context;
        this.apiRepository = apiRepository;
    }


    public void Load(String string) {
        String URL = apiRepository.getTeam(string);
        Log.d("TAG", "Load: "+URL);
        final ArrayList<PlayerItem> playerItemList = new ArrayList<>();

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

                        playerItemList.add(playerItem);
                    }
                    view.showData(playerItemList);



                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);


    }
}
