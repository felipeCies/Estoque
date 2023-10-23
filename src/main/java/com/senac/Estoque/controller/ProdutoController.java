package com.senac.Estoque.controller;


import com.senac.Estoque.model.Produto;
import com.senac.Estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produto")
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @PostMapping("/")
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtoService.adicionarProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        if (produtoService.buscarPorId(id) != null) {
            produto.setId(id);
            return produtoService.atualizarProduto(produto);
        } else {

            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable ("id") Long id) {
         produtoService.deletarProduto(id);

    }


}
