package com.produit.produit.service;

import com.produit.produit.model.Produit;
import org.springframework.stereotype.Service;

import com.produit.produit.repository.ProduitRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitService {
    private final ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }
}
