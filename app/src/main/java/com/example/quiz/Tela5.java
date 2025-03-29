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

public class Tela5 extends AppCompatActivity {

    private RadioGroup rdgOpcoes4;
    private RadioButton rdb13, rdb14, rdb15, rdb16;
    private Button btnConfirmar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rdgOpcoes4 = findViewById(R.id.rdgOpcoes4);
        rdb13 = findViewById(R.id.rdb13);
        rdb14 = findViewById(R.id.rdb14);
        rdb15 = findViewById(R.id.rdb15);
        rdb16 = findViewById(R.id.rdb16);
        btnConfirmar4 = findViewById(R.id.btnConfirmar4);
    }

    public void confirmar4(View view){
        String nome = getIntent().getStringExtra("nome_usuario");
        int acertos = getIntent().getIntExtra("acertos", 0);

        if (rdb13.isChecked()) {
            acertos++;
            Toast.makeText(getApplicationContext(), "Acertoooou!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(getApplicationContext(), Tela7.class);
            it.putExtra("nome_usuario", nome);
            it.putExtra("acertos", acertos);
            startActivity(it);
        } else if (rdgOpcoes4.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Errooooou!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(getApplicationContext(), Tela7.class);
            it.putExtra("nome_usuario", nome);
            it.putExtra("acertos", acertos);
            startActivity(it);
        }

    }
}