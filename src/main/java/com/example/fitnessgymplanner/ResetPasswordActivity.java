package com.example.fitnessgymplanner;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPasswordActivity extends Activity {
    private EditText newPasswordInput, confirmPasswordInput;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        email = getIntent().getStringExtra("email");
        if (email == null) email = "";

        newPasswordInput = findViewById(R.id.etNewPassword);
        confirmPasswordInput = findViewById(R.id.etConfirmNewPassword);
        Button resetButton = findViewById(R.id.btnResetPassword);
        TextView backLink = findViewById(R.id.tvResetBackToLogin);

        resetButton.setOnClickListener(v -> resetPassword());
        backLink.setOnClickListener(v ->
                startActivity(new Intent(this, LoginActivity.class)));
    }

    private void resetPassword() {
        String newPassword = newPasswordInput.getText().toString();
        String confirmPassword = confirmPasswordInput.getText().toString();

        if (newPassword.length() < 6) {
            newPasswordInput.setError(getString(R.string.error_password_length));
            newPasswordInput.requestFocus();
            return;
        }
        if (!newPassword.equals(confirmPassword)) {
            confirmPasswordInput.setError(getString(R.string.error_password_mismatch));
            confirmPasswordInput.requestFocus();
            return;
        }

        SharedPreferences prefs = getSharedPreferences("fitness_app", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        if (email.equalsIgnoreCase("demo@example.com")) {
            // Demo account password can be reset locally too.
            editor.putString("demo_password", newPassword);
        } else {
            editor.putString("password", newPassword);
        }
        editor.apply();

        Toast.makeText(this, R.string.password_reset_success, Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
