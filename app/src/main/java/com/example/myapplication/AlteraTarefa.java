package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AlteraTarefa extends Activity {

    // Declaração dos componentes da tela
    EditText titulo;
    EditText autor;
    EditText editora;
    Button alterar;
    Button deletar;

    // Declaração do banco de dados
    Cursor cursor;
    BancoController crud;

    // Declaração das variáveis auxiliares
    String codigo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_tarefa);

        // Inicialização dos componentes da tela
        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());
        titulo = (EditText)findViewById(R.id.etTitulo);
        alterar = (Button)findViewById(R.id.btAlterar);
        deletar = (Button)findViewById(R.id.btDeletar);

        // Busca os dados do cliente pelo id e preenche os campos da tela
        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        titulo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TITULO)));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.AUTOR)));
        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.EDITORA)));

        // Evento de clique no botão de alterar
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Captura os valores digitados nos campos da tela
                String tituloString = titulo.getText().toString();
                String autorString = autor.getText().toString();
                String editoraString = editora.getText().toString();

                // Chama o método do banco de dados para alterar os dados na tabela
                crud.alteraRegistro(Integer.parseInt(codigo), tituloString, autorString, editoraString);

                // Cria uma intenção para abrir a tela de listagem de clientes
                Intent intent = new Intent(AlteraTarefa.this, ListaTarefas.class);

                // Inicia a nova atividade
                startActivity(intent);

                // Finaliza a atividade atual
                finish();
            }
        });

        // Evento de clique no botão de deletar
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chama o método do banco de dados para deletar o dado na tabela pelo id
                crud.deletaRegistro(Integer.parseInt(codigo));

                // Cria uma intenção para abrir a tela de listagem de clientes
                Intent intent = new Intent(AlteraTarefa.this, ListaTarefas.class);

                // Inicia a nova atividade
                startActivity(intent);

                // Finaliza a atividade atual
                finish();
            }
        });
    }
}
