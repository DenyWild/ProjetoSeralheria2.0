package com.example.demo.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.entities.Orcamento;
import com.example.demo.model.repositories.OrcamentoRepository;
import com.example.demo.services.exceptions.EntityNotFoundException;

@Service
public class OrcamentoService {

	
	 @Autowired
	 private OrcamentoRepository orcamentoRepository;
	 
	 
	 // METODO GET FIND BY ID
	 public Orcamento findById(Integer id_orcamento) {
		return  orcamentoRepository.findById(id_orcamento).orElseThrow(
				 () -> new EntityNotFoundException("Id not found "+ id_orcamento));
	 }
     //METODO POST 
		public @ResponseBody Orcamento salvarOrcamento(@Valid @RequestParam double precoAluminio,
				@RequestParam double altura,
				@RequestParam double largura,
			//	@RequestParam  double metrosqd,
				@RequestParam int tipomaterial) {
			  Orcamento orc = new Orcamento(precoAluminio, altura, largura, tipomaterial);
	   
	    	orcamentoRepository.save(orc);
			 return orc;
		}
	    
	 //METODO GET FIND ALL
		public Iterable<Orcamento> consultarOrcamento(){
			return orcamentoRepository.findAll();
		}
		
		
	 //METODO DELETE BY ID
		public void excluirOrcamentoporId(@PathVariable Integer id_orcamento) {
			orcamentoRepository.deleteById(id_orcamento);
		}
		
     //METODO PUT DIFERENTE APENAS PARA A CLASSE ORCAMENTO
		public Orcamento test (@PathVariable("id_orcamento") Integer id_orcamento, @RequestBody Orcamento newOrcamento  ) {
	            Optional<Orcamento> procurado = this.orcamentoRepository.findById(id_orcamento);
	            Orcamento result = null;


	            result = procurado.get();
	                result.setAltura(newOrcamento.getAltura());
	                result.setLargura(newOrcamento.getLargura());
	                result.setTipomaterial(newOrcamento.getTipomaterial());
	                result.setPrecoAluminio(newOrcamento.getPrecoAluminio());
	                result.setMetrosqd(result.getAltura(), result.getLargura());
	                result.setTotal(result.getTotal(result.getTipomaterial()));
	            return this.orcamentoRepository.save(result);

	        }
		  
		
		  //METODO PUT QUE DEU ERRO, MAS QUE TALVEZ SIRVA PRA ALGO
		/*
		public @ResponseBody Orcamento teste(@PathVariable Integer id_orcamento,@RequestBody Orcamento orcamento) {
			Orcamento orci = orcamentoRepository.findById(id_orcamento).get();
			BeanUtils.copyProperties(orcamento, orci, "id_orcamento");
			return orcamentoRepository.save(orci);
		}*/

}
