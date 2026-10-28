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

public class LoginActivity extends Activity {
    private EditText emailInput, passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.etLoginEmail);
        passwordInput = findViewById(R.id.etLoginPassword);
        Button loginButton = findViewById(R.id.btnLogin);
        TextView registerLink = findViewById(R.id.tvOpenRegister);
        TextView forgotLink = findViewById(R.id.tvOpenForgot);

        loginButton.setOnClickListener(v -> login());
        registerLink.setOnClickListener(v ->
                startActivity(new Intent(this, RegisterActivity.class)));
        forgotLink.setOnClickListener(v ->
                startActivity(new Intent(this, ForgotPasswordActivity.class)));
    }

    private void login() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString();

        if (email.isEmpty()) {
            emailInput.setError(getString(R.string.error_email_required));
            emailInput.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError(getString(R.string.error_email_invalid));
            emailInput.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            passwordInput.setError(getString(R.string.error_password_required));
            passwordInput.requestFocus();
            return;
        }

        SharedPreferences prefs = getSharedPreferences("fitness_app", MODE_PRIVATE);
        String savedEmail = prefs.getString("email", "");
        String savedPassword = prefs.getString("password", "");

        String demoPassword = prefs.getString("demo_password", "123456");
        boolean demoLogin = email.equalsIgnoreCase("demo@example.com") && password.equals(demoPassword);
        boolean registeredLogin = email.equalsIgnoreCase(savedEmail) && password.equals(savedPassword);

        if (demoLogin || registeredLogin) {
            String name = demoLogin ? "Demo User" : prefs.getString("name", "Fitness User");
            prefs.edit().putString("logged_in_name", name)
                    .putString("logged_in_email", email).apply();
            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, R.string.login_failed, Toast.LENGTH_LONG).show();
        }
    }
}
