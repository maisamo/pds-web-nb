/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maisamo.smartalerta.modelo.entidade;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author wagner
 */
public class Pagina {

    private Long id;
    private StringBuffer url, params;
    private LocalDateTime datahora_expira;
    private final Alerta alerta;
    private final Usuario usuario;
    private final Contato contato;

    public Pagina(Alerta alerta, Usuario usuario, Contato contato) {
        this.alerta = alerta;
        this.usuario = usuario;
        this.contato = contato;
        datahora_expira = LocalDateTime.now().plusHours(24);
    }

    public String getUrl() {
        url.append("localhost:8080/maisamo/AcessarPagina?");
        url.append(getParams());
        return url.toString();
    }

    private String getParams() {
        params.append("from=" + usuario.getNome());
        params.append("&to=" + contato.getNome());
        params.append("&categoria=" + alerta.getTitulo());
        params.append("&titulo=" + alerta.getCategoria());
        return params.toString();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataExpira() {
        return datahora_expira.toLocalDate();
    }

    public LocalTime getHoraExpira() {
        return datahora_expira.toLocalTime();
    }

    public void setDataHoraExpira(LocalDateTime datahora_expira) {
        this.datahora_expira = datahora_expira;
    }

    public boolean expirou() {
        return LocalDateTime.now().compareTo(datahora_expira) > 0;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Contato getContato() {
        return contato;
    }
}
