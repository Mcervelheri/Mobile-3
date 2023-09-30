package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declaração dos componentes da tela
    Button botaoCadastrar;
    Button botaoListar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialização dos componentes da tela
        botaoCadastrar = (Button)findViewById(R.id.btnCadastroTarefas);
        botaoListar = (Button)findViewById(R.id.btnListaTarefas);

        // Evento de clique no botão de cadastrar
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma intenção para abrir a tela de cadastro de clientes
                Intent intent = new Intent(MainActivity.this, CadastrarTarefa.class);

                // Inicia a nova atividade
                startActivity(intent);
            }
        });

        // Evento de clique no botão de listar
        botaoListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cria uma intenção para abrir a tela de listagem de clientes
                Intent intent = new Intent(MainActivity.this, ListaTarefas.class);

                // Inicia a nova atividade
                startActivity(intent);
            }
        });
    }
}
