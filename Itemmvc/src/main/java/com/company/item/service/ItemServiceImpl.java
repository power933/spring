package com.company.item.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.item.dao.ItemMapper;
import com.company.item.dao.ItemRepository;
import com.company.item.domain.ItemDTO;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
//	private ItemRepository itemRepository;
	private ItemMapper itemRepository;
	
	@Override
	public List<ItemDTO> getAll() {

		return itemRepository.getAll();
	}
	
	@Override
	public ItemDTO getItem(Integer a) {
		// TODO Auto-generated method stub
		return itemRepository.getItem(a);
	}
	
}
