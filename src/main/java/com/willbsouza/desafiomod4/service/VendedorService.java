package com.willbsouza.desafiomod4.service;

import com.willbsouza.desafiomod4.dto.VendedorDTO;
import com.willbsouza.desafiomod4.entity.Vendedor;
import com.willbsouza.desafiomod4.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<VendedorDTO> findAll(){
        List<Vendedor> vendedores = vendedorRepository.findAll();
        return vendedores.stream().map(v -> new VendedorDTO(v)).collect(Collectors.toList());
    }

    public VendedorDTO findById(Long id){
        Vendedor vendedor = vendedorRepository.findById(id).get();
        return new VendedorDTO(vendedor);
    }

    public VendedorDTO save(Vendedor vendedor) {
        return new VendedorDTO(vendedorRepository.save(vendedor));
    }

    public VendedorDTO updateById(Long id, Vendedor vendedor){
        Vendedor vendedorToUpdate = vendedorRepository.findById(id).get();
        vendedorToUpdate.setNome(vendedor.getNome());
        vendedorRepository.save(vendedorToUpdate);
        return new VendedorDTO(vendedorToUpdate);
    }

    public void deleteById(Long id){
        vendedorRepository.deleteById(id);
    }

    public Vendedor fromDTO(VendedorDTO vendedorDTO){
        return new Vendedor(vendedorDTO.getId(), vendedorDTO.getNome());
    }

}
