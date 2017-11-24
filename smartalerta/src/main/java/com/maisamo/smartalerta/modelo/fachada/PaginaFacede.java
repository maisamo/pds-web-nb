/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maisamo.smartalerta.modelo.fachada;

import java.util.List;

import com.maisamo.smartalerta.modelo.dao.PaginaDAO;
import com.maisamo.smartalerta.modelo.entidade.Pagina;

/**
 *
 * @author wagner
 */
public class PaginaFacede {

    private final PaginaDAO pdao = new PaginaDAO();

    public boolean inserir(Pagina pagina) {
        return pdao.inserir(pagina);
    }

    public boolean exluir(Pagina pagina) {
        return pdao.excluir(pagina);
    }

    public List<Pagina> listar() {
        return pdao.listar();
    }
}
