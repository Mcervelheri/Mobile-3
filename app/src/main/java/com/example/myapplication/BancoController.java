package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    // Declaração do banco de dados
    private SQLiteDatabase db;
    private CriaBanco banco;

    // Construtor da classe
    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    // Método para inserir dados na tabela
    public String insereDado(String titulo, String autor){
        ContentValues valores;
        long resultado;

        // Abre o banco de dados para escrita
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.TITULO, titulo);
        valores.put(CriaBanco.AUTOR, autor);

        // Insere os valores na tabela e retorna o id do registro ou -1 se ocorrer algum erro
        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    // Método para buscar dados na tabela
    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.TITULO};
        // Abre o banco de dados para leitura
        db = banco.getReadableDatabase();
        // Faz a consulta na tabela e obtém um cursor com os dados
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            // Move o cursor para o primeiro registro
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    // Método para buscar um dado na tabela pelo id
    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.TITULO,banco.AUTOR,banco.EDITORA};
        String where = CriaBanco.ID + "=" + id;
        // Abre o banco de dados para leitura
        db = banco.getReadableDatabase();
        // Faz a consulta na tabela com o critério where e obtém um cursor com o dado
        cursor = db.query(banco.TABELA,campos,where, null, null, null, null);

        if(cursor!=null){
            // Move o cursor para o primeiro registro
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    // Método para alterar um dado na tabela pelo id
    public void alteraRegistro(int id, String titulo, String autor, String editora){
        ContentValues valores;
        String where;

        where = CriaBanco.ID + "=" + id;

        // Abre o banco de dados para escrita
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put(CriaBanco.TITULO, titulo);
        valores.put(CriaBanco.AUTOR, autor);
        valores.put(CriaBanco.EDITORA, editora);

        // Faz a atualização na tabela com os valores e o critério where
        db.update(CriaBanco.TABELA,valores,where,null);
        db.close();
    }

    // Método para deletar um dado na tabela pelo id
    public void deletaRegistro(int id){
        String where = CriaBanco.ID + "=" + id;

        // Abre o banco de dados para escrita
        db = banco.getWritableDatabase();

        // Faz a deleção na tabela com o critério where
        db.delete(CriaBanco.TABELA,where,null);
        db.close();
    }
}
