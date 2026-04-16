package com.example.demo.model;

import lombok.Data;

@Data // Jika pakai Lombok
public class User {
    private String nama; // Harus kecil semua
    private String nim;  // Harus kecil semua
    private String jenisKelamin; // Perhatikan huruf 'K' besar (CamelCase)
}