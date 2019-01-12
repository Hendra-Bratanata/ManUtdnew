package com.iamjue.manchesterunited.ApiRepository;

import android.util.Log;

import com.iamjue.manchesterunited.BuildConfig;

public class ApiRepository {

    public String getTeam(String string){
        String teamUrl = "searchplayers.php?t=";
        String url = BuildConfig.BASE_URL+teamUrl+string;
        Log.d("TAG", "getTeam: "+url);
        return url;
    }
}
