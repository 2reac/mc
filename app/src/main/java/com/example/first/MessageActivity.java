package com.example.first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MessageActivity extends AppCompatActivity {

    Button notif;
    RequestQueue mRQ;
    String URL = "https://fcm.googleapis.com/fcm/send";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        notif = findViewById(R.id.sendBtn);
        mRQ = Volley.newRequestQueue(this);
        FirebaseMessaging.getInstance().subscribeToTopic("2reac");

        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }

    private void sendNotification() {
        JSONObject mainObj = new JSONObject();
        try {
            mainObj.put("to", "/topics/" + "2reac");

            JSONObject notifObj = new JSONObject();
            notifObj.put("title", "First Message");
            notifObj.put("body", "1st demo");

            mainObj.put("notification", notifObj);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL, mainObj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
            ){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> header = new HashMap<>();
                    header.put("content-type", "application/json");
                    header.put("authorization", "key=AAAAusAqHmI:APA91bHXFJZcCj-EHzLsI3wN73vsO5nhS8wivEvU2w2gl__PZRAfUeoabPb22nl5TyyBg969_QxyQ4QxoWTf199y_cp0NGbjut-jJPDiwJppldp6eL2OXsiHrFDrXLAelQHgKNOsWJd0");
                    return header;
                }
            };

            mRQ.add(request);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
