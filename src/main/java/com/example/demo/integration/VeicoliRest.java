package com.example.demo.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Auto;
import com.example.demo.model.Moto;
import com.example.demo.repos.AutoDAO;
import com.example.demo.repos.MotoDAO;

@RestController
@RequestMapping("api")
public class VeicoliRest {
	@Autowired
	private MotoDAO dao;//oggetto che interagisce con il database 
	
	@Autowired
	private AutoDAO autoDAO;
	
	@GetMapping("moto")
	public List <Moto> getAllMoto(){
		return dao.findAll();
	}
	
	@PostMapping("moto")
	public Moto addMoto(@RequestBody Moto m) {
		dao.save(m);
		return m;
	}
	@GetMapping("deleteAll")
	public void deleteAll(){
		dao.deleteAll();
	}
	@PostMapping("auto")
	public Auto addAuto(@RequestBody Auto a ) {
		autoDAO.save(a);
		return a;
	}
	@GetMapping("auto")
		public List<Auto>getAllAuto(){
		return autoDAO.findAll();
			
		}

}
