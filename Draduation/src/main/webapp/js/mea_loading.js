 $(function(){
	var name = window.localStorage.getItem('name')
	var auth = window.localStorage.getItem('auth')
    if(auth ==1){
    	var auth = '管理者'
    	var html=name+'-'+auth
    	$('.nav_right .name').html(html)
    }else if(auth ==2){
    	$(".nav_select:nth-of-type(3)").css('display','none');
    	var auth = '操作者'
    	var html=name+'-'+auth
    	$('.nav_right .name').html(html)
    }
	
	//退出
	$('.quit').on('click', function() {
		$('.return').css('display', 'block')
	})
	$('.return_select span:first-of-type').on('click', function() {
		$('.return').css('display', 'none')
		$.ajax({
			url : "http://localhost:8080/zkxy/users/LoginOut",
			type : "DELETE",
			dataType : "json",
			data : {},
			success : function(res) {
				// delCookie("username");
			}
		})
		window.location.href = "login.html"
	})
	//退出取消
	$('.return_select span:last-of-type').on('click', function() {
		$('.return').css('display', 'none')
	})
	


	//设置密码
	$('.fit').on('click',function(){
		$('.setUp_password').show()
	})
	
	$('.two_password').focus(function(){
		$('.hide_pass').css('visibility','hidden')
	})
	
	$('.pass_addtrue').on('click',function(){
		var text1 = $('.one_password').val()
		var text2 = $('.two_password').val()
		if(!(text1 == '') || !(text2 == '')){
			if(text1 == text2){
				$.ajax({
					url : "http://localhost:8080/zkxy/users/updateUserPass",
					type : "PUT",
					dataType : "json",
					data : {
						'password':text1
					},
					success : function(res) {
						//console.log(res)
						if(res.status == 200){
							$('.setUp_password').hide()
							popUp('密码修改成功')
						}
					}
				})
			}else{
				$('.hide_pass').css('visibility','visible')
			}
		}else{
			$('.hide_pass').css('visibility','hidden')
		}
	})
	
	$('.pass_cancel').on('click',function(){
		$('.setUp_password').hide()
	})


	var timer = null;
	var isMove  = true;
	window.onmousemove = function(){
		if(isMove){
			clearTimeout(timer);
			timer = setTimeout(function(){
				isMove  = false;
			},600000);
		}else{
			isMove  = true;
			$('.exception').show()
		}
    }
	
	$('.exception button').on('click',function () {
		window.location.href = "login.html"
	})

})