package com.example.quiz;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela6 extends AppCompatActivity {

    private TextView edtPontos, edtPont;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String nome = getIntent().getStringExtra("nome_usuario");
        int acertos = getIntent().getIntExtra("acertos", 0);

        edtPontos = findViewById(R.id.edtPontos);
        edtPont = findViewById(R.id.edtPont);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        edtPont.setText(nome + ", sua pontuação total foi:");
        edtPontos.setText(acertos + "/5");

        btnFinalizar.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Quiz Finalizado")
                    .setMessage("Deseja sair do aplicativo?")
                    .setPositiveButton("Sim", (dialog, which) -> finishAffinity())
                    .setNegativeButton("Não", null)
                    .show();
        });

    }



}