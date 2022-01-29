package com.example.collegefinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView topCollege;
    RecyclerView topNit;
    ArrayList<College> colleges;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topCollege = findViewById(R.id.top_college_rv);
        topNit = findViewById(R.id.top_nit_rv);
        JSONArray jsonColleges = get_json();
        jsonToArraylist(jsonColleges);

        topCollege.setLayoutManager(new LinearLayoutManager(this, topCollege.HORIZONTAL, false));
        TopCollegeAdapterRV adapter = new TopCollegeAdapterRV(colleges);
        topCollege.setAdapter(adapter);

        topNit.setLayoutManager(new LinearLayoutManager(this, topNit.HORIZONTAL, false));
        TopNitAdapterRV adapterNit = new TopNitAdapterRV(colleges);
        topNit.setAdapter(adapter);
    }

    public JSONArray get_json(){
        String json;
        JSONArray jsonArray = null;
        try{
            InputStream is = getAssets().open("colleges.json");
            int size = is.available();
            byte buffer[] = new byte[size];
            is.read();
            is.close();
            json = new String(buffer,"UTF-8");
            JSONArray temp= new JSONArray(json);
            jsonArray = temp;

        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }

        return jsonArray;
    }

    public void jsonToArraylist(JSONArray array){
        for(int i=0; i<30; i++){
            JSONObject object = null;
            try {
                object= array.getJSONObject(i);
                College college = new College(object.getString("name"), object.getString("img"), object.getString("info"), object.getString("website"), object.getString("hostel"), object.getString("city"), object.getString("state"), object.getLong("lattitude"), object.getLong("longitude"), object.getInt("nirf"), object.getInt("fees"), object.getInt("seats"), object.getDouble("placementpercent"), object.getJSONArray("courses"));
                colleges.add(college);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}