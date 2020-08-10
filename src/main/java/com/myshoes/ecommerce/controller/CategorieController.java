package com.myshoes.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMethod;

import com.myshoes.ecommerce.model.Categorie;
import com.myshoes.ecommerce.service.interfaces.CategorieService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class CategorieController {

	@Autowired
	CategorieService _categorieService;
	
	// GET
	@RequestMapping(value="/categorie", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Categorie>> getCategories() {
		List<Categorie> categorie = new ArrayList<>();
		categorie = this._categorieService.findAllCategories();
		
		if (categorie.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Categorie>>(categorie, HttpStatus.OK);
	}
}
