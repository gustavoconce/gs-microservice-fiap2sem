package com.fiap.gsmicroservice.dtos;

public class EletronicoRequestUptadeDto {

	private int consumo;
	private String modelo;
	private String nome;
	private int quantidade;


    public int getConsumo() {
        return consumo;
    }
    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


}
