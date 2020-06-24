$(function () {

    $('.student').on('click',function () {
        $('.entrance').hide()
        $('.student_password').show()
        $('.return').show()
    })
    $('.teacher').on('click',function () {
        $('.entrance').hide()
        $('.teacher_password').show()
        $('.return').show()
    })
    $('.return').on('click',function () {
        $('.entrance').show()
        $('.teacher_password').hide()
        $('.student_password').hide()
        $('.return').hide()
        $('.pass_error').css('visibility','hidden')
    })

    $('.student_password>.land').on('click', function () {
        var name = $('#student_name').val();
        var password = $('#student_password').val();
        if(name == ''){
        	$('.student_password .pass_error').css('visibility','visible').html('用户名不能为空')
        	//alert('用戶名不能为空')
        }else if(password == ''){
        	$('.student_password .pass_error').css('visibility','visible').html('密码不能为空')
        }else{
            var student={sto:name,password:password};
            var json=JSON.stringify(student);
        	$.ajax({
                url:"./user/load",
                type:"post",
                dataType:"json",
                contentType:"application/json",
                data:json,
                success:function(res){
                	console.log(111)
                	if(res==null){
                	    localStorage.setItem("name",name);
                		window.location.href="student.jsp";
                	}else{
                		$('.student_password .pass_error').css('visibility','visible').html(res.note);
                	}
                }
            })
        }
    })

    $('.teacher_password>.land').on('click', function () {
        var name = $('#teacher_name').val();
        var password = $('#teacher_password').val();
        if(name == ''){
        	$('.teacher_password .pass_error').css('visibility','visible').html('用户名不能为空')
        	//alert('用戶名不能为空')
        }else if(password == ''){
        	$('.teacher_password .pass_error').css('visibility','visible').html('密码不能为空')
        }else{
            var tea={jobnumber:name,password:password};
            var json=JSON.stringify(tea);
        	$.ajax({
                url:"./edu/load",
                type:"post",
                contentType:"application/json",
                dataType:"json",

                data:json,
                success:function(res){
                	console.log(res)
                	if(res== null){
                        localStorage.setItem("teacher_name",name);
                		window.location.href="teacher.jsp"
                	}else {
                		$('.teacher_password .pass_error').css('visibility','visible').html(res.note)
                	}
                }
            })
        }
    })

    
    $('#name').focus(function(){
    	$('.pass_error').css('visibility','hidden')
    })
    $('#password').focus(function(){
    	$('.pass_error').css('visibility','hidden')
    })
})
