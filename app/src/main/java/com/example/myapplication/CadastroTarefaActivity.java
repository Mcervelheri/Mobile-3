package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroTarefaActivity extends AppCompatActivity {

    private EditText etData, etTitulo, etDescricao;
    private CheckBox cbConcluido;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_tarefa);

        etData = findViewById(R.id.etData);
        etTitulo = findViewById(R.id.etTitulo);
        etDescricao = findViewById(R.id.etDescricao);
        cbConcluido = findViewById(R.id.cbConcluido);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarTarefa();
            }
        });
    }

    private void salvarTarefa() {
        String data = etData.getText().toString();
        String titulo = etTitulo.getText().toString();
        String descricao = etDescricao.getText().toString();
        boolean concluido = cbConcluido.isChecked();

        // Aqui você pode adicionar a lógica para salvar a tarefa em algum lugar (por exemplo, em um banco de dados)

        Toast.makeText(this, "Tarefa salva com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
