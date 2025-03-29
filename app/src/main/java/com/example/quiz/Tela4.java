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

public class Tela4 extends AppCompatActivity {

    private RadioGroup rdgOpcoes3;
    private RadioButton rdb9, rdb10, rdb11, rdb12;
    private Button btnConfirmar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rdgOpcoes3 = findViewById(R.id.rdgOpcoes3);
        rdb9 = findViewById(R.id.rdb9);
        rdb10 = findViewById(R.id.rdb10);
        rdb11 = findViewById(R.id.rdb11);
        rdb12 = findViewById(R.id.rdb12);
        btnConfirmar3 = findViewById(R.id.btnConfirmar3);
    }

    public void confirmar3(View view){
        String nome = getIntent().getStringExtra("nome_usuario");
        int acertos = getIntent().getIntExtra("acertos", 0);

        if (rdb11.isChecked()) {
            acertos++;
            Toast.makeText(getApplicationContext(), "Acertoooou!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(getApplicationContext(), Tela5.class);
            it.putExtra("nome_usuario", nome);
            it.putExtra("acertos", acertos);
            startActivity(it);
        } else if (rdgOpcoes3.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Errooooou!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(getApplicationContext(), Tela5.class);
            it.putExtra("nome_usuario", nome);
            it.putExtra("acertos", acertos);
            startActivity(it);
        }

    }
}