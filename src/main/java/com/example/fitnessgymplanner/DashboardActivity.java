package com.example.fitnessgymplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView welcome = findViewById(R.id.tvDashboardWelcome);
        TextView profileCard = findViewById(R.id.cardProfile);
        TextView scheduleCard = findViewById(R.id.cardSchedule);
        TextView exerciseCard = findViewById(R.id.cardExercises);
        TextView historyCard = findViewById(R.id.cardHistory);
        TextView waterCard = findViewById(R.id.cardWater);
        TextView foodCard = findViewById(R.id.cardFood);

        String name = getSharedPreferences("fitness_app", MODE_PRIVATE)
                .getString("logged_in_name", "Fitness User");
        welcome.setText(getString(R.string.dashboard_welcome, name));

        profileCard.setOnClickListener(v ->
                startActivity(new Intent(this, ProfileActivity.class)));
        scheduleCard.setOnClickListener(v -> showModule(getString(R.string.module_schedule)));
        exerciseCard.setOnClickListener(v -> showModule(getString(R.string.module_exercises)));
        historyCard.setOnClickListener(v -> showModule(getString(R.string.module_history)));
        waterCard.setOnClickListener(v -> showModule(getString(R.string.module_water)));
        foodCard.setOnClickListener(v -> showModule(getString(R.string.module_food)));
    }

    private void showModule(String module) {
        Toast.makeText(this, module + " " + getString(R.string.module_demo_message), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        // Prevent returning to login with the Android back button.
        moveTaskToBack(true);
    }
}
