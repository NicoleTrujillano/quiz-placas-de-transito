package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela2 extends AppCompatActivity {

    private RadioGroup rdgOpcoes1;
    private RadioButton rdb1, rdb2, rdb3, rdb4;
    private Button btnConfirmar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rdgOpcoes1 = findViewById(R.id.rdgOpcoes1);
        rdb1 = findViewById(R.id.rdb1);
        rdb2 = findViewById(R.id.rdb2);
        rdb3 = findViewById(R.id.rdb3);
        rdb4 = findViewById(R.id.rdb4);
        btnConfirmar1 = findViewById(R.id.btnConfirmar1);


    }
    public void confirmar(View view) {

        String nome = getIntent().getStringExtra("nome_usuario");
        int acertos = 0;

        if (rdb2.isChecked()) {
            acertos++;
            Toast.makeText(getApplicationContext(), "Acertoooou!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(getApplicationContext(), Tela3.class);
            it.putExtra("nome_usuario", nome);
            it.putExtra("acertos", acertos);
            startActivity(it);
        } else if (rdgOpcoes1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Errooooou!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(getApplicationContext(), Tela3.class);
            it.putExtra("nome_usuario", nome);
            it.putExtra("acertos", acertos);
            startActivity(it);
        }


    }
}