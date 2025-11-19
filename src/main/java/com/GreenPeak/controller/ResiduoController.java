package com.GreenPeak.controller;

import com.GreenPeak.model.Residuo;
import com.GreenPeak.service.Residuo.ResiduoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/residuos")
public class ResiduoController {

    private final ResiduoService service;

    public ResiduoController(ResiduoService service) {
        this.service = service;
    }

    @GetMapping
    public String listarTodos(Model model) {
        model.addAttribute("residuos", service.listarTodos());
        return "residuos";
    }

    @GetMapping("/novo")
    public String mostrarFormularioDeNovoResiduo(Model model) {
        model.addAttribute("residuo", new Residuo());
        return "residuo-form";
    }

    @PostMapping
    public String criar(@ModelAttribute Residuo residuo) {
        service.salvar(residuo);
        return "redirect:/residuos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicao(@PathVariable Long id, Model model) {
        Residuo residuo = service.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de resíduo inválido:" + id));
        model.addAttribute("residuo", residuo);
        return "residuo-form";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/residuos";
    }
}