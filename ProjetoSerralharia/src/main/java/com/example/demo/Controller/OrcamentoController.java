package com.example.demo.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.FormaPagamento;
import com.example.demo.model.entities.Orcamento;
import com.example.demo.model.repositories.FormaPagamentoRepository;
import com.example.demo.model.repositories.OrcamentoRepository;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {

	 @Autowired
	 private OrcamentoRepository orcamentoRepository;
		
	    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT} )
		public  @ResponseBody Orcamento SalvarOrcamento(@Valid @RequestParam double precoAluminio, @RequestParam double altura,
				@RequestParam double largura,
				@RequestParam  double metrosqd,
				@RequestParam int tipomaterial) {
	    	
	    Orcamento orc = new Orcamento(precoAluminio,altura, largura, metrosqd, tipomaterial, 0);
	    	orcamentoRepository.save(orc);
			 return orc;
		}
	    
		@GetMapping
		public Iterable<Orcamento> ConsultarOrcamento(){
			return orcamentoRepository.findAll();
		}
		
		@GetMapping(path = "/{id_orcamento}")
		public Optional<Orcamento> ConsultarOrcamentoporId(@PathVariable Integer id_orcamento){
			return orcamentoRepository.findById(id_orcamento);
			
		}
		@DeleteMapping(path = "/{id_orcamento}")
		public void ExcluirOrcamentoporId(@PathVariable Integer id_orcamento) {
			orcamentoRepository.deleteById(id_orcamento);
		}
	
}
