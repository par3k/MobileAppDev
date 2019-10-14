package com.example.login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateRequest extends StringRequest { //아이디 중복확인 할 수 있는 기능. DB에서 userID를 불러들여서 중복인지 확인
    final static private String URL = "https://bakhoijae.cafe24.com/UserValidate.php";
    private Map<String,String> parameters;

    public ValidateRequest(String userID, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);
        parameters = new HashMap<>();
        parameters.put("userID",userID);


    }

    @Override
    public Map<String,String> getParams(){
        return parameters;
    }
}
