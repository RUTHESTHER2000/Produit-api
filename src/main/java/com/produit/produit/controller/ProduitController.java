package com.produit.produit.controller;

import com.produit.produit.model.Produit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.produit.produit.service.ProduitService;
import com.produit.produit.model.Produit;
import org.springframework.web.bind.annotation.RequestBody;



import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/produits")
@RequiredArgsConstructor
public class ProduitController {
    private final ProduitService produitService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/all")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.createProduit(produit);
    }
}


