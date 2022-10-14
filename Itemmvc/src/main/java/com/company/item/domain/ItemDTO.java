package com.company.item.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDTO {
	private int itemid;
	private String itemname;
	private String price;
	private String description;
	private String pictureurl;
}
