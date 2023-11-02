package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Turma;
import com.example.demo.repositpry.TurmaRepository;



@Controller
@RequestMapping("/turma")
public class TurmaController {
	
@Autowired
private TurmaRepository turmaRepository;
	
   
    ModelAndView modelAndView = new ModelAndView("lista");

// listar -----------------
    @GetMapping("/lista")
    public ModelAndView listaTurma() {
        ModelAndView modelAndView = new ModelAndView("lista");
        List<Turma> turmas = turmaRepository.findAll();
        modelAndView.addObject("turmas", turmas);
        return modelAndView;
    }
// inserir ---------------
    @GetMapping
    public String mostraForm(Turma turma) {
        return "add-turma";
    }


    @PostMapping
    public ModelAndView addTurma(Turma turma) {   
        turmaRepository.save(turma);
        ModelAndView modelAndView = new ModelAndView("add-turma");
        modelAndView.addObject("mensagem", "Salvo com sucesso!");
        return modelAndView;
    }
    
    
    // editar-----------
    @GetMapping("/edit/{id}")
    public String editTurmaForm(@PathVariable("id") Long id, Model model) {
    	Turma turma = turmaRepository.findById(id).orElse(null);
        model.addAttribute("turma", turma);
        return "/edit";
    }

    @PostMapping("/edit/{id}")
    public String editTurma(@PathVariable("id") Long id, @ModelAttribute("turma") Turma turma) {
        turma.setId(id);
        turmaRepository.save(turma);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("mensagem", "Editado com sucesso!");
        return "redirect:/turma/lista";
    }
// remover -----------------
    @GetMapping("/delete/{id}")
    public String deleteTurma(@PathVariable("id") Long id) {
    	turmaRepository.deleteById(id);
        return "redirect:/turma/lista";
    }
    
    
    
    
    