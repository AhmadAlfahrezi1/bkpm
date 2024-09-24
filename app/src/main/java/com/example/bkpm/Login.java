package com.example.bkpm;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    private EditText emailEditText, passwordEditText;
    private ImageView togglePasswordVisibility;
    private boolean isPasswordVisible = false;
    private Button button;
    private String registeredPassword;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password_toggle);
        togglePasswordVisibility = findViewById(R.id.imageView3);
        button = findViewById(R.id.btnLogin);

        // intent expor
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        registeredPassword = intent.getStringExtra("password");

        Log.d("Login", "Email: " + email + " Password: " + registeredPassword);

        // Set
        if (email != null) {
            emailEditText.setText(email);
        }

        //  tombol Login
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = emailEditText.getText().toString().trim();
                String passwordInput = passwordEditText.getText().toString().trim();

                // Validasi input
                if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                    showAlert("Error", "Email dan Password harus diisi", null);
                    return;
                }

                // Validasi  password
                if (passwordInput.equals(registeredPassword)) {
                    // Jika password benar, arahkan ke Recycler
                    showAlert("Login Berhasil", "Login berhasil!", new Runnable() {
                        @Override
                        public void run() {
                            navigateToRecycler(emailInput);
                        }
                    });
                } else {
                    //  password salah,
                    showAlert("Error", "Password salah!", new Runnable() {
                        @Override
                        public void run() {
                            navigateToListMhs(emailInput);
                        }
                    });
                }
            }
        });

        // ikon mata password
        togglePasswordVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    togglePasswordVisibility.setImageResource(R.drawable.imgtooglepassword); // Ganti dengan drawable mata tertutup
                } else {
                    passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    togglePasswordVisibility.setImageResource(R.drawable.eye_24); // Ganti dengan drawable mata terbuka
                }
                passwordEditText.setSelection(passwordEditText.length());
                isPasswordVisible = !isPasswordVisible;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // AlertDialog konfirmasi login
    private void showLoginConfirmationDialog(String email) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Konfirmasi Login");
        builder.setMessage("Apakah Anda yakin ingin login?");

        // pndah Recycler
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                navigateToRecycler(email);
            }
        });

        // batal login
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        //  dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // AlertDialog
    private void showAlert(String title, String message, Runnable onDismiss) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (onDismiss != null) {
                    onDismiss.run();
                }
            }
        });

        // dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    //  ke Listmhs
    private void navigateToListMhs(String email) {
        Intent intent = new Intent(Login.this, Listmhs.class);
        intent.putExtra("email", email);
        startActivity(intent);
        finish();
    }

    // salah pindah ke recycler
    private void navigateToRecycler(String email) {
        Intent intent = new Intent(Login.this, Recycler.class);
        intent.putExtra("email", email);
        startActivity(intent);
        finish();
    }
}
