package com.example.bkpm;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Regitsrter extends AppCompatActivity {
    private EditText etFullName, etUsername, etEmail, txtTgl, etPassword, etConfirmPassword;
    private Spinner spinnerGender;
    private Button button;
    private ImageView togglePasswordVisibility2;
    private boolean isConfirmPasswordVisible = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_regitsrter);

        etFullName = findViewById(R.id.editTextText);
        etUsername = findViewById(R.id.editTextText1);
        etEmail = findViewById(R.id.editTextText2);
        etPassword = findViewById(R.id.editTextTextPassword);
        etConfirmPassword = findViewById(R.id.editTextTextPassword2);
        spinnerGender = findViewById(R.id.spinner);
        txtTgl = findViewById(R.id.txt_tgl);
        button = findViewById(R.id.btnregister);
        togglePasswordVisibility2 = findViewById(R.id.togglePasswordVisibility2);

        // tombol register
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        // date picker
        txtTgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        // hiden ikon
        togglePasswordVisibility2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ubah visibilitas password
                if (isConfirmPasswordVisible) {
                    etConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    togglePasswordVisibility2.setImageResource(R.drawable.imgtooglepassword); // Set ikon mata tertutup
                } else {
                    etConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                    togglePasswordVisibility2.setImageResource(R.drawable.eye_24); // Set ikon mata terbuka
                }
                isConfirmPasswordVisible = !isConfirmPasswordVisible;


                etConfirmPassword.setSelection(etConfirmPassword.getText().length());
            }
        });
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, month1, dayOfMonth) -> {
                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(year1, month1, dayOfMonth);

                    DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
                    String date = dateFormat.format(selectedDate.getTime());

                    txtTgl.setText(date);
                }, year, month, day);
        datePickerDialog.show();
    }

    private void registerUser() {
        // Retrieve input data
        String fullName = etFullName.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();
        String gender = spinnerGender.getSelectedItem().toString();
        String dateOfBirth = txtTgl.getText().toString();

        // Validasi input
        if (fullName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || dateOfBirth.isEmpty()) {
            Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validasi password dan konfirmasi password
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Password dan Konfirmasi Password tidak sama!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lanjutkan proses registrasi
        String message = "Halo, nama saya " + fullName + ", dengan email " + email + ", dan tanggal lahir " + dateOfBirth;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        //  impor Login
        Intent intent = new Intent(Regitsrter.this, Login.class);
        intent.putExtra("email", email);  // Kirim email ke Login
        intent.putExtra("password", password);  // Kirim password yang diinputkan ke Login
        Log.d("Regitsrter", "Navigating to Login activity with email: " + email + " and password: " + password);
        startActivity(intent);
        finish();

    }
}
