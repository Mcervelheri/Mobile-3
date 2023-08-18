package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ListaTarefasActivity extends AppCompatActivity {

    private ListView listViewTarefas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tarefas);

        listViewTarefas = findViewById(R.id.listViewTarefas);

        // Aqui você pode obter a lista de tarefas de algum lugar (por exemplo, de um banco de dados)
        String[] tarefas = {"Tarefa 1", "Tarefa 2", "Tarefa 3"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tarefas);
        listViewTarefas.setAdapter(adapter);
    }
}