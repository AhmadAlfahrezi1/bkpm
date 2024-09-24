package com.example.bkpm;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Mahasiswa adapter;
    private List<item_mahasiswa> mahasiswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mahasiswaList = new ArrayList<>();

        mahasiswaList.add(new item_mahasiswa("MUHAMMAD NOR KHOLIT", "081234567890", "kholit@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("AKBAR MAULIDI RISKIAWAN", "081234567891", "akbar@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("AHMAD ALFAHREZI", "081234567892", "ahmad@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("BUSTANUL ARIFIN", "081234567893", "bustanul@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("ILLHAM NUR ISNAINI BASKARA JAYA", "081234567894", "illham@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("SEPTIAN GALOH PRASETYO", "081234567895", "septian@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("FEBRI DWI KHOIRINA AZIS", "081234567896", "febri@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("ALEX ROHMATULLAH", "081234567897", "alex@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("REO ARYA YUDHA", "081234567898", "reo@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("MUHAMMAD SONU AFRIZA ZAKARIA", "081234567899", "sonu@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("ALFINO SHOFIYULLOH Z R", "081234567900", "alfino@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("RAIHAN RAIS ARRUM", "081234567901", "raihan@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("DHEDEN SANDIKA", "081234567902", "dheden@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("WAHYU ANANDA", "081234567903", "wahyu@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("RAFFI ARGANTA VIARI", "081234567904", "raffi@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("MOHAMMAD SOLLI", "081234567905", "solli@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("SAGITA PUTRI AGUSTINA", "081234567906", "sagita@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("MAFIRA AURELIA SALSABILA FIRDAUS", "081234567907", "mafira@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("MUHAMMAD HASAN KAMIL", "081234567908", "hasan@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("MUHAMMAD ABDUL WAFI", "081234567909", "wafi@gmail.com", R.drawable.baseline_contact_emergency_24));
        mahasiswaList.add(new item_mahasiswa("DENDI APRILIO SETIAWAN", "081234567910", "dendi@gmail.com", R.drawable.baseline_contact_emergency_24));

        // Set adapter
        adapter = new Mahasiswa(mahasiswaList);
        adapter = new Mahasiswa(mahasiswaList);
        recyclerView.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}