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

public class Tela7 extends AppCompatActivity {

    private RadioGroup rdgOpcoes5;
    private RadioButton rdb17, rdb18, rdb19, rdb20;
    private Button btnConfirmar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rdgOpcoes5 = findViewById(R.id.rdgOpcoes5);
        rdb17 = findViewById(R.id.rdb17);
        rdb18 = findViewById(R.id.rdb18);
        rdb19 = findViewById(R.id.rdb19);
        rdb20 = findViewById(R.id.rdb20);
        btnConfirmar5 = findViewById(R.id.btnConfirmar5);
    }

    public void confirmar5(View view){
        String nome = getIntent().getStringExtra("nome_usuario");
        int acertos = getIntent().getIntExtra("acertos", 0);

        if (rdb20.isChecked()) {
            acertos++;
            Toast.makeText(getApplicationContext(), "Acertoooou!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(getApplicationContext(), Tela6.class);
            it.putExtra("nome_usuario", nome);
            it.putExtra("acertos", acertos);
            startActivity(it);
        } else if (rdgOpcoes5.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Errooooou!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(getApplicationContext(), Tela6.class);
            it.putExtra("nome_usuario", nome);
            it.putExtra("acertos", acertos);
            startActivity(it);
        }

    }

}