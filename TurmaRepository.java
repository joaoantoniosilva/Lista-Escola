package com.example.demo.repositpry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Turma;



public interface TurmaRepository extends JpaRepository<Turma, Long> {
    // Aqui você pode definir consultas personalizadas, se necessário
}
