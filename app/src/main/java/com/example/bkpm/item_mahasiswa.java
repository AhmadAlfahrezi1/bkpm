package com.example.bkpm;

import java.util.List;

public class item_mahasiswa {
    private String nama;
    private String noTelp;
    private String email;
    private int foto;

    public item_mahasiswa(String nama, String noTelp, String email, int foto) {
        this.nama = nama;
        this.email = email;
        this.noTelp = noTelp;
        this.foto = foto;
    }

    public item_mahasiswa(List<item_mahasiswa> mahasiswaList) {
    }

    public String getNama() {return nama;}
    public String getNoTelp() {return noTelp;}
    public String getEmail() {return email;}
    public int getFoto() {return foto;}
}