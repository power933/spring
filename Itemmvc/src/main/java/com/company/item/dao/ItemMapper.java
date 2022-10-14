package com.company.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.company.item.domain.ItemDTO;

@Repository
public interface ItemMapper {
	@Select("select * from ITEM")
	public List<ItemDTO>getAll();
	
	@Select("select * from ITEM where itemid = #{itemid}")
	public ItemDTO getItem(Integer itemid);
	
}
