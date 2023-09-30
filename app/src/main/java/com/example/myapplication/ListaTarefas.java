package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListaTarefas extends Activity {

    // Declaração dos componentes da tela
    private ListView lista;

    // Declaração do banco de dados
    BancoController crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tarefa);

        // Inicialização dos componentes da tela
        crud = new BancoController(getBaseContext());
        lista = (ListView)findViewById(R.id.listView);

        // Busca os dados dos clientes na tabela e cria um cursor com os dados
        Cursor cursor = crud.carregaDados();

        // Define os campos que serão mostrados na lista
        String[] nomeCampos = new String[] {CriaBanco.ID, CriaBanco.TITULO};

        // Define os ids dos elementos de layout que serão preenchidos com os dados
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro};

        // Cria um adaptador simples de cursor para conectar os dados ao layout da lista
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.lista_tarefas,cursor,nomeCampos,idViews, 0);
        lista.setAdapter(adaptador);

        // Evento de clique em um item da lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtém o cursor na posição clicada
                Cursor cursor = (Cursor) lista.getItemAtPosition(position);

                // Obtém o id do cliente na coluna _id
                int codigo = cursor.getInt(cursor.getColumnIndexOrThrow(CriaBanco.ID));

                // Cria uma intenção para abrir a tela de alteração de clientes
                Intent intent = new Intent(ListaTarefas.this, AlteraTarefa.class);

                // Passa o id do cliente como um extra para a intenção
                intent.putExtra("codigo", String.valueOf(codigo));

                // Inicia a nova atividade
                startActivity(intent);

                // Finaliza a atividade atual
                finish();
            }
        });
    }
}
