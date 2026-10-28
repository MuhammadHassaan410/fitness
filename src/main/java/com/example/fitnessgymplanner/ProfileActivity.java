package com.example.fitnessgymplanner;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences prefs = getSharedPreferences("fitness_app", MODE_PRIVATE);
        String name = prefs.getString("logged_in_name", "Fitness User");
        String email = prefs.getString("logged_in_email", "Not available");

        ((TextView) findViewById(R.id.tvProfileName)).setText(name);
        ((TextView) findViewById(R.id.tvProfileEmail)).setText(email);

        Button logoutButton = findViewById(R.id.btnLogout);
        Button backButton = findViewById(R.id.btnProfileBack);

        logoutButton.setOnClickListener(v -> {
            prefs.edit().remove("logged_in_name").remove("logged_in_email").apply();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        backButton.setOnClickListener(v -> finish());
    }
}
