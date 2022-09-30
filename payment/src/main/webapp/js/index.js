
//입력값 유효성 검사
export function gopage(){
	if(frm.product_name.value=="") alert("상품명을 입력하세요");
	else if(frm.product_price.value=="") alert("상품가격을 입력하세요");
	else if(frm.product_ea.value=="") alert("상품수량을 입력하세요");
	else{
		if(frm.product_price.value<1000) alert('천원이상');
		else{
			frm.method="get";
			frm.action="index2.jsp";
			frm.submit();
			}
	}
}

//기본적립금
export function gopayment(a){
	
	var ori_m = frm.price.value;	//전체 상품금액
	var point = frm.point.value;
	if(point == ""){
		point = 0;
	}
	var new_m = ori_m-point;
	frm.price.value = ori_m - point;
	frm.total.value = frm.price.value;
	var ok = true;
	
	if(ok){
		frm.method = "POST";
		frm.action = "./index3.jsp";
		frm.submit();
	
	}
	
}

