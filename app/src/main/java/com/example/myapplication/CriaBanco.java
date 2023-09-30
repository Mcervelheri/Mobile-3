package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    // Nome do banco de dados
    private static final String NOME_BANCO = "banco.db";
    // Nome da tabela
    public static final String TABELA = "livros";
    // Colunas da tabela
    public static final String ID = "_id";
    public static final String TITULO = "titulo";
    public static final String AUTOR = "autor";
    public static final String EDITORA = "editora";
    // Versão do banco de dados
    private static final int VERSAO = 1;

    // Construtor da classe
    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    // Método que cria o banco de dados
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Comando SQL para criar a tabela livros
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + TITULO + " text,"
                + AUTOR + " text,"
                + EDITORA + " text"
                +")";
        // Executa o comando SQL no banco de dados
        db.execSQL(sql);
    }

    // Método que atualiza o banco de dados
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Comando SQL para apagar a tabela livros
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        // Executa o comando SQL no banco de dados
        db.execSQL(sql);
        // Chama o método que cria o banco de dados novamente
        onCreate(db);
    }
}
