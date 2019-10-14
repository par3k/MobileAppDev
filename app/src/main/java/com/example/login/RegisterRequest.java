package com.example.login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest { // 회원가입 등록시 DB에서 데이터를 불러옴
    final static private String URL = "https://bakhoijae.cafe24.com/UserRegister.php";
    private Map<String,String> parameters;

    public RegisterRequest(String userID, String userPassword, String userGender, String userEmail, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);
        parameters = new HashMap<>();
        parameters.put("userID",userID);
        parameters.put("userPassword",userPassword);
        parameters.put("userGender",userGender);
        parameters.put("userEmail",userEmail);

    }

    @Override
    public Map<String,String> getParams(){
        return parameters;
    }
}
