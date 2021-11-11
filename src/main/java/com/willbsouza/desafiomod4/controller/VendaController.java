package com.willbsouza.desafiomod4.controller;

import com.willbsouza.desafiomod4.dto.VendaDTO;
import com.willbsouza.desafiomod4.entity.Venda;
import com.willbsouza.desafiomod4.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/vendas")
    public ResponseEntity<List<VendaDTO>> findAll(){
        List<VendaDTO> vendas = vendaService.findAll();
        return new ResponseEntity<List<VendaDTO>>(vendas, HttpStatus.OK);
    }

    @GetMapping("/venda/{id}")
    public ResponseEntity<VendaDTO> findById(@PathVariable Long id){
        VendaDTO vendaDTO = vendaService.findById(id);
        return new ResponseEntity<VendaDTO>(vendaDTO, HttpStatus.OK);
    }

    @PostMapping("/vendas")
    @ResponseBody
    public ResponseEntity<VendaDTO> save(@RequestBody VendaDTO vendaDTO){
        return new ResponseEntity<VendaDTO>(vendaService.save(vendaService.fromDTO(vendaDTO)), HttpStatus.CREATED);
    }

    @PutMapping("/venda/{id}")
    @ResponseBody
    public ResponseEntity<VendaDTO> updateById(@PathVariable Long id, @RequestBody VendaDTO vendaDTO){
        Venda entidade = vendaService.fromDTO(vendaDTO);
        vendaService.updateById(id, entidade);
        return new ResponseEntity<VendaDTO>(vendaDTO, HttpStatus.OK);
    }

    @DeleteMapping("/venda/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        vendaService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
