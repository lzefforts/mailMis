$(function () {
	
	jQuery.support.placeholder = false;
	test = document.createElement('input');
	if('placeholder' in test) jQuery.support.placeholder = true;
	if (!$.support.placeholder) {
		$('.field').find ('label').show ();
	}

	//提交订单
	$('#submitBtn').click(function(){
		if(!checkIsValide()){
			return;
		}
		var d = {};
		//var t = $('#formDiv').serializeArray();
		//$.each(t, function() {
		//	d[this.name] = this.value;
		//});
		$("#formDiv input[type='text']").each(function(){
			d[this.name] = $(this).val();
		});
		
		


	});



	
});

//验证是否符合规范
function checkIsValide(){
	if($('#kUserName').val() == ""){
		alert("韩国/收件人,不能为空!");
		return false;
	}
	if($('#kPhone').val() == ""){
		alert("韩国/电话,不能为空!");
		return false;
	}
	if($('#kAddress').val() == ""){
		alert("韩国/地址,不能为空!");
		return false;
	}
	if($('#city').val() == ""){
		alert("目的城市名,不能为空!");
		return false;
	}
	if($('#mailNoCn').val() == ""){
		alert("中国/快递单号,不能为空!");
		return false;
	}
	if($('#detail').val() == ""){
		alert("物品明细,不能为空!");
		return false;
	}
	if($('#weichatNo').val() == ""){
		alert("微信昵称,不能为空!");
		return false;
	}
	return true;
}