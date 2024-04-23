/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaswing.dao;

import com.javaswing.dao.Conexao;
import com.javaswing.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JULIANO AMBRÓSIO | LEONARDO SOUZA
 */
public class UsuarioDao {
    
    // Link para fazer download do driver do mysql
    // https://downloads.mysql.com/archives/c-j/
           
    public boolean cadastrar(Usuario usuario) throws SQLException {
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectar();
                
        String query = "INSERT INTO Usuario (Nome,Telefone,Cidade) values (" +
                "'" +   usuario.getNome()  + "'," +
                "'" +   usuario.getTelefone()   + "'," +
                "'" +   usuario.getCidade() + "')";
        
        //INSERT INTO Livro (Titulo,Autor,Editora,quantidade) values ('O Rei','João','Caminho das letras',2)
        //INSERT INTO Livro (Titulo,Autor,Editora,quantidade) values (O Rei,João,Caminho das letras,2)
        
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            conexao.desconectar(connection);
            return true;
        }catch (SQLException ex) {
            System.out.print(ex.initCause(ex));
            return false;
        } 
    }
    
    
    public ArrayList<Usuario> consultar(Usuario usuario) throws SQLException {
    ArrayList<Usuario> listUsuario = new ArrayList<Usuario>();

    Conexao conexao = new Conexao();
    Connection connection = conexao.conectar();
    String query = "SELECT * FROM usuario where nome like '" + usuario.getNome() + "%'";
    Statement statement = connection.createStatement();
    ResultSet retorno = statement.executeQuery(query);

    while (retorno.next()) {
        Usuario usuarioRetorno = new Usuario();
        usuarioRetorno.setCodigo(retorno.getInt("codigo"));
        usuarioRetorno.setNome(retorno.getString("nome"));
        usuarioRetorno.setTelefone(retorno.getString("telefone"));
        usuarioRetorno.setCidade(retorno.getString("cidade"));
        listUsuario.add(usuarioRetorno);
    }

    return listUsuario;
}
    
    
}