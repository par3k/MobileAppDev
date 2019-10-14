package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity { //회원가입창 구성


    private String userID;
    private String userPassword;
    private String userGender;
    private String userEmail;
    private AlertDialog dialog;
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final EditText emailText = (EditText) findViewById(R.id.emailText);

        RadioGroup genderGroup = (RadioGroup) findViewById(R.id.genderGroup);
        int genderGroupID = genderGroup.getCheckedRadioButtonId();
        userGender = ((RadioButton) findViewById(genderGroupID)).getText().toString();

        genderGroup.setOnCheckedChangeListener((new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                 RadioButton genderButton = (RadioButton) findViewById(i);
                 userGender = genderButton.getText().toString();
            }
        }));

        final Button validateButton = (Button) findViewById(R.id.validateButton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = idText.getText().toString();
                if(validate){
                    return;
                }
                if(userID.equals("")){
                     AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                     dialog = builder.setMessage("Check your ID again")
                             .setPositiveButton("OK",null)
                             .create();
                     dialog.show();
                     return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog = builder.setMessage("You can use this ID")
                                        .setPositiveButton("OK",null)
                                        .create();
                                dialog.show();
                                idText.setEnabled(false);
                                validate = true;
                                idText.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                validateButton.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog = builder.setMessage("You can't use this ID")
                                        .setNegativeButton("OK",null)
                                        .create();
                                dialog.show();
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };
               ValidateRequest validateRequest = new ValidateRequest(userID,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(validateRequest);
            }
        });

        Button registerButton = (Button) findViewById(R.id.registerButton);
         registerButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String userID = idText.getText().toString();
                 String userPassword = passwordText.getText().toString();
                 String userEmail = emailText.getText().toString();

                 if(!validate){
                     AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                     dialog = builder.setMessage("Check your form")
                             .setNegativeButton("OK",null)
                             .create();
                     dialog.show();
                     return;
                 }
                 if(userID.equals("")||userPassword.equals("")||userEmail.equals("")||userGender.equals("")){
                     AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                     dialog = builder.setMessage("Check your form")
                             .setNegativeButton("OK",null)
                             .create();
                     dialog.show();
                     return;
                 }
                 Response.Listener<String> responseListener = new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {
                         try{
                             JSONObject jsonResponse = new JSONObject(response);
                             boolean success = jsonResponse.getBoolean("success");
                             if(success){
                                 AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                 dialog = builder.setMessage("Sign up Success")
                                         .setPositiveButton("OK",null)
                                         .create();
                                 dialog.show();
                                 finish();
                             }
                             else{
                                 AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                 dialog = builder.setMessage("Sign up Failed")
                                         .setNegativeButton("OK",null)
                                         .create();
                                 dialog.show();
                             }
                         }catch(Exception e){
                             e.printStackTrace();
                         }
                     }
                 };
                 RegisterRequest registerRequest = new RegisterRequest(userID,userPassword,userEmail,userGender,responseListener);
                 RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                 queue.add(registerRequest);
             }
         });
    }
    @Override
    protected void onStop(){
        super.onStop();
        if(dialog != null){
             dialog.dismiss();
             dialog = null;
        }
    }
}
