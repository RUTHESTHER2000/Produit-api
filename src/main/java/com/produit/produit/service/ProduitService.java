package com.produit.produit.service;

import com.produit.produit.model.Produit;
import org.springframework.stereotype.Service;

import com.produit.produit.repository.ProduitRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

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

    public Produit getProduitById(Long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isEmpty()){
            throw new RuntimeException("Produit not found");
        }
        return optionalProduit.get();
    }

    public String deleteProduitById(long idProduit) {
        Optional<Produit> optionalProduit = produitRepository.findById(idProduit);
        if (optionalProduit.isEmpty()){
            throw new RuntimeException("Produit not found");
        }
        produitRepository.deleteById(idProduit);

        return "Produit deleted";
    }

    public Produit editProduit(long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isEmpty()){
            throw new RuntimeException("Produit not found");
        }
        Produit produitAModif = optionalProduit.get();
        produitAModif.setName(produit.getName());
        produitAModif.setPrice(produit.getPrice());
        return produitRepository.save(produitAModif);

    }
}
