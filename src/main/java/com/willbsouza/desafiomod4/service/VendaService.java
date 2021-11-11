package com.willbsouza.desafiomod4.service;

import com.willbsouza.desafiomod4.dto.VendaDTO;
import com.willbsouza.desafiomod4.entity.Venda;
import com.willbsouza.desafiomod4.entity.Vendedor;
import com.willbsouza.desafiomod4.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<VendaDTO> findAll(){
       List<Venda> vendas = vendaRepository.findAll();
       return vendas.stream().map(v -> new VendaDTO(v)).collect(Collectors.toList());
    }

    public VendaDTO findById(Long id){
        Venda venda = vendaRepository.findById(id).get();
        return new VendaDTO(venda);
    }

    public VendaDTO save(Venda venda){
        return new VendaDTO (vendaRepository.save(venda));
    }

    public VendaDTO updateById(Long id, Venda venda){
        Venda vendaToUpdate = vendaRepository.findById(id).get();
        vendaToUpdate.setDataVenda(venda.getDataVenda());
        vendaToUpdate.setValorVenda(venda.getValorVenda());
        vendaToUpdate.setVendedor(venda.getVendedor());
        vendaRepository.save(vendaToUpdate);
        return new VendaDTO(vendaToUpdate);
    }

    public void deleteById(Long id){
        vendaRepository.deleteById(id);
    }

    public Venda fromDTO(VendaDTO vendaDTO){
        return new Venda(vendaDTO.getId(), vendaDTO.getValorVenda(), vendaDTO.getDataVenda(), new Vendedor(vendaDTO.getVendedor().getId(), null));
    }
}
