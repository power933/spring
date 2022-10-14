package com.company.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.item.domain.ItemDTO;
import com.company.item.service.ItemService;

@RestController
public class ItemRestController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="list.json", method = RequestMethod.GET)
	public Map<String,Object> getAll() {
		Map<String,Object> map = new HashMap<String, Object>();
		
		List<ItemDTO> list = itemService.getAll();
		map.put("result", true);
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("{itemid}/item.json")
	public Map<String,Object> getItem(
			@PathVariable("itemid") Integer itemid) {
		Map<String,Object> map = new HashMap<String, Object>();
		ItemDTO dto = itemService.getItem(itemid);
		map.put("result", true);
		map.put("data", dto);
		
		
		return map;
	}
	
}
