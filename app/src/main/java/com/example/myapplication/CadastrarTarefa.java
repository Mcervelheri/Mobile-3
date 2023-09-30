package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarTarefa extends Activity {

    // Declaração dos componentes da tela
    EditText titulo;
    EditText descricao;
    Button botao;

    // Declaração do banco de dados
    BancoController crud;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_tarefa);

        // Inicialização dos componentes da tela
        titulo = (EditText)findViewById(R.id.etTitulo);
        descricao = (EditText)findViewById(R.id.etDescricao);
        botao = (Button)findViewById(R.id.btSalvar);

        // Inicialização do banco de dados
        crud = new BancoController(getBaseContext());

        // Evento de clique no botão de salvar
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Captura os valores digitados nos campos da tela
                String tituloString = titulo.getText().toString();
                String descricaoString = descricao.getText().toString();

                // Chama o método do banco de dados para inserir os dados na tabela
                String resultado = crud.insereDado(tituloString, descricaoString);

                // Mostra uma mensagem com o resultado da operação
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                // Cria uma intenção para abrir a tela de listagem de clientes
                Intent intent = new Intent(CadastrarTarefa.this, ListaTarefas.class);

                // Inicia a nova atividade
                startActivity(intent);

                // Finaliza a atividade atual
                finish();
            }
        });
    }
}
