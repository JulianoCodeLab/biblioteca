/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaswing.service;
import com.javaswing.dao.UsuarioDao;
import com.javaswing.modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javaswing.modelo.Usuario;

/**
 *
 * @author JULIANO AMBRÓSIO | LEONARDO SOUZA
 */
public class UsuarioService {
    
    public boolean cadastrar(Usuario usuario) throws SQLException{
        UsuarioDao usuarioDao = new UsuarioDao();
        return usuarioDao.cadastrar(usuario);
    }
    
    public ArrayList<Usuario> consultar(Usuario usuario) throws SQLException{
        UsuarioDao usuarioDao = new UsuarioDao();
        return usuarioDao.consultar(usuario);
    }

}