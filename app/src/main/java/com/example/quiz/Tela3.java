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

public class Tela3 extends AppCompatActivity {

    private RadioGroup rdgOpcoes2;
    private RadioButton rdb5, rdb6, rdb7, rdb8;
    private Button btnConfirmar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rdgOpcoes2 = findViewById(R.id.rdgOpcoes2);
        rdb5 = findViewById(R.id.rdb5);
        rdb6 = findViewById(R.id.rdb6);
        rdb7 = findViewById(R.id.rdb7);
        rdb8 = findViewById(R.id.rdb8);
        btnConfirmar2 = findViewById(R.id.btnConfirmar2);

    }


    public void confirmar2(View view){
        String nome = getIntent().getStringExtra("nome_usuario");
        int acertos = getIntent().getIntExtra("acertos", 0);

        if (rdb8.isChecked()) {
            acertos++;
            Toast.makeText(getApplicationContext(), "Acertoooou!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(getApplicationContext(), Tela4.class);
            it.putExtra("nome_usuario", nome);
            it.putExtra("acertos", acertos);
            startActivity(it);
        } else if (rdgOpcoes2.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Nenhuma opção selecionada!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Errooooou!", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(getApplicationContext(), Tela4.class);
            it.putExtra("nome_usuario", nome);
            it.putExtra("acertos", acertos);
            startActivity(it);
        }


    }
}