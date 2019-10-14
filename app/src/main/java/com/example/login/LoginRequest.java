package com.example.login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest { //로그인 데이터를 DB에서 구현
    final static private String URL = "https://bakhoijae.cafe24.com/UserLogin.php";
    private Map<String,String> parameters;

    public LoginRequest(String userID, String userPassword, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);
        parameters = new HashMap<>();
        parameters.put("userID",userID);
        parameters.put("userPassword",userPassword);


    }

    @Override
    public Map<String,String> getParams(){
        return parameters;
    }
}
