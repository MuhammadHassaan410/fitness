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

public class RegisterActivity extends Activity {
    private EditText nameInput, emailInput, passwordInput, confirmInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameInput = findViewById(R.id.etRegisterName);
        emailInput = findViewById(R.id.etRegisterEmail);
        passwordInput = findViewById(R.id.etRegisterPassword);
        confirmInput = findViewById(R.id.etRegisterConfirm);
        Button registerButton = findViewById(R.id.btnRegister);
        TextView loginLink = findViewById(R.id.tvBackToLogin);

        registerButton.setOnClickListener(v -> register());
        loginLink.setOnClickListener(v ->
                startActivity(new Intent(this, LoginActivity.class)));
    }

    private void register() {
        String name = nameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString();
        String confirm = confirmInput.getText().toString();

        if (name.isEmpty()) {
            nameInput.setError(getString(R.string.error_name_required));
            nameInput.requestFocus();
            return;
        }
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError(getString(R.string.error_email_invalid));
            emailInput.requestFocus();
            return;
        }
        if (password.length() < 6) {
            passwordInput.setError(getString(R.string.error_password_length));
            passwordInput.requestFocus();
            return;
        }
        if (!password.equals(confirm)) {
            confirmInput.setError(getString(R.string.error_password_mismatch));
            confirmInput.requestFocus();
            return;
        }

        SharedPreferences prefs = getSharedPreferences("fitness_app", MODE_PRIVATE);
        prefs.edit().putString("name", name)
                .putString("email", email)
                .putString("password", password)
                .apply();

        Toast.makeText(this, R.string.registration_success, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("email", email);
        startActivity(intent);
        finish();
    }
}
