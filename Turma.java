package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private int numeroAlunos;
    // getters e setters
	public Turma(Long id, String nome, int numeroAlunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.numeroAlunos = numeroAlunos;
	}
	public Turma() {
		super();
	}
	
	public Turma(String nome, int numeroAlunos) {
		super();
		this.nome = nome;
		this.numeroAlunos = numeroAlunos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroAlunos() {
		return numeroAlunos;
	}
	public void setNumeroAlunos(int numeroAlunos) {
		this.numeroAlunos = numeroAlunos;
	}
    
    
}