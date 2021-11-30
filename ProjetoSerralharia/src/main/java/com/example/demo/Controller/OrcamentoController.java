package com.example.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Orcamento;
import com.example.demo.services.OrcamentoService;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {

    @Autowired
	private OrcamentoService orcamentoService;
		
   	
  
        @PostMapping
       public  ResponseEntity<Orcamento> SalvarOrcamentos(@Valid @RequestParam double precoAluminio, 
		@RequestParam double altura, 
		@RequestParam double largura,
		@RequestParam int tipomaterial) {
	Orcamento orc = orcamentoService.salvarOrcamento(precoAluminio, altura, largura, tipomaterial) ;
	return ResponseEntity.ok().body(orc);
}
	    
		@GetMapping
		public Iterable<Orcamento> ConsultarOrcamento(){
			return orcamentoService.consultarOrcamento();
		}
		
		@GetMapping(path = "/{id_orcamento}")
		public ResponseEntity<Orcamento> ConsultarOrcamentoporId(@PathVariable Integer id_orcamento){
			Orcamento orc = orcamentoService.findById(id_orcamento);
			return ResponseEntity.ok().body(orc);
		}
		@DeleteMapping(path = "/{id_orcamento}")
		public void ExcluirOrcamentoporId(@PathVariable Integer id_orcamento) {
			orcamentoService.excluirOrcamentoporId(id_orcamento);
		}
		
		@PutMapping(path = "/update/{id_orcamento}")
        public Orcamento test (@PathVariable("id_orcamento") int id_orcamento, @RequestBody Orcamento newOrcamento  ) {
            
            return this.orcamentoService.test(id_orcamento, newOrcamento);

        }
		
		//PUT QUE DEU ERRO, MAS PODE SERVIR PRA ALGO
		/*
		@PutMapping(path = "/update/{id_orcamento}")
		public Orcamento tet(@PathVariable Integer id_orcamento, @RequestBody Orcamento orc){
			
			return orcamentoService.teste(id_orcamento, orc);
		}*/
		
		
	
}
