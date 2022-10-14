package com.company.item.service;

import java.util.List;

import com.company.item.domain.ItemDTO;

public interface ItemService {
	
	List<ItemDTO> getAll();
	
	ItemDTO getItem(Integer a);
	
}
