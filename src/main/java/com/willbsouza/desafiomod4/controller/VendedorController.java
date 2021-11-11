package com.willbsouza.desafiomod4.controller;

import com.willbsouza.desafiomod4.dto.VendedorDTO;
import com.willbsouza.desafiomod4.entity.Vendedor;
import com.willbsouza.desafiomod4.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping("/vendedores")
    public ResponseEntity<List<VendedorDTO>> findAll(){
        List<VendedorDTO> vendedores = vendedorService.findAll();
        return new ResponseEntity<List<VendedorDTO>>(vendedores, HttpStatus.OK);
    }

    @GetMapping("/vendedor/{id}")
    public ResponseEntity<VendedorDTO> findById(@PathVariable Long id){
        VendedorDTO vendedorDTO = vendedorService.findById(id);
        return new ResponseEntity<VendedorDTO>(vendedorDTO, HttpStatus.OK);
    }

    @PostMapping("/vendedores")
    @ResponseBody
    public ResponseEntity<VendedorDTO> save(@RequestBody VendedorDTO vendedorDTO){
        vendedorService.save(vendedorService.fromDTO(vendedorDTO));
        return new ResponseEntity<VendedorDTO>(vendedorDTO, HttpStatus.CREATED);
    }

    @PutMapping("vendedor/{id}")
    @ResponseBody
    public ResponseEntity<VendedorDTO> updateById(@PathVariable Long id, @RequestBody VendedorDTO vendedorDTO){
        Vendedor entidade = vendedorService.fromDTO(vendedorDTO);
        vendedorService.updateById(id, entidade);
        return new ResponseEntity<VendedorDTO>(vendedorDTO, HttpStatus.OK);
    }

    @DeleteMapping("/vendedor/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        vendedorService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
