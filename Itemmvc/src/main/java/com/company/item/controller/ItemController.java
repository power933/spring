package com.company.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.item.domain.ItemDTO;
import com.company.item.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="getall", method=RequestMethod.GET)
	public String getAll(Model model) {
		List<ItemDTO> list = itemService.getAll();
		model.addAttribute("list",list);
		return "item/list";
	}
	
	@RequestMapping(value="getitem/{itemid}")
	public String getitem(Model model, @PathVariable Integer itemid) {
		
		ItemDTO dto = itemService.getItem(itemid);
		model.addAttribute("item",dto);
		return "item/getitem";
	}
}








