package com.example.fitnessgymplanner;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPasswordActivity extends Activity {
    private EditText emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailInput = findViewById(R.id.etForgotEmail);
        Button recoverButton = findViewById(R.id.btnRecover);
        TextView backLink = findViewById(R.id.tvForgotBackToLogin);

        recoverButton.setOnClickListener(v -> recover());
        backLink.setOnClickListener(v ->
                startActivity(new Intent(this, LoginActivity.class)));
    }

    private void recover() {
        String email = emailInput.getText().toString().trim();
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError(getString(R.string.error_email_invalid));
            emailInput.requestFocus();
            return;
        }

        SharedPreferences prefs = getSharedPreferences("fitness_app", MODE_PRIVATE);
        String savedEmail = prefs.getString("email", "");
        boolean exists = email.equalsIgnoreCase(savedEmail)
                || email.equalsIgnoreCase("demo@example.com");

        if (!exists) {
            Toast.makeText(this, R.string.recovery_email_not_found, Toast.LENGTH_LONG).show();
            return;
        }

        Toast.makeText(this, R.string.recovery_simulated, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ResetPasswordActivity.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
}
