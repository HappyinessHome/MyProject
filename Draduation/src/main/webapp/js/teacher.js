$(function(){
	var jobnumber = localStorage.getItem('teacher_name');
	var json=JSON.stringify({jobnumber:jobnumber});
	// $('.file_name').val(jobnumer)
	$.ajax({
		url:"./edu/getOne",
		type:"post",
		contentType:"application/json",
		dataType:"json",
		data:json,
		success:function(res){
			console.log(res)
			if(res.note == null){
				$('.name').text(jobnumber)
				$('.check_state>p:nth-of-type(1)').html(res.jobnumber)
				$('.check_state>p:nth-of-type(2)').html(res.name)
				$('.check_state>p:nth-of-type(3)').html(res.age)
				$('.check_state>p:nth-of-type(4)').html(res.sex)
				$('.check_state>p:nth-of-type(5)').html(res.college)
				$('.input1').val(res.name)
				$('.input2').val(res.age)
				$('.input3').val(res.sex)
				$('.input4').val(res.college)
			}else {
			}
		}
	})

	function popUp(msg){
		$('.popup>div>p').html(msg)
		$('.popup').show()
		setTimeout(function(){
			$('.popup').hide()
		},2000)
	}

	$('.information').on('click',function () {
		$('.tab1').show()
		$('.tab2').hide()
		$('.tab3').hide()
		$('.tab4').hide()
		$(this).addClass('bg_color').siblings().removeClass('bg_color')
	})
	$('.match').on('click',function () {
		$('.tab1').hide()
		$('.tab2').show()
		$('.tab3').hide()
		$('.tab4').hide()
		$(this).addClass('bg_color').siblings().removeClass('bg_color')
	})
	$('.record').on('click',function () {
		$('.tab1').hide()
		$('.tab2').hide()
		$('.tab3').show()
		$('.tab4').hide()
		$(this).addClass('bg_color').siblings().removeClass('bg_color')

		$('.tab3>table>tbody').html('')

		$.ajax({
			url:"./match/getMark",
			type:"post",
			contentType:"application/json",
			dataType:"json",
			success:function(res){
				var data = res
				console.log(data)
				for(var i = 0;i<data.length;i++){
					var name = data[i].name
					var matches = data[i].matches
					for(var j = 0; j<matches.length;j++){
						var html = ''
						html+="<tr>";
						html+=  "<td>"+matches[j].name+"</td>";
						html+=  "<td>"+matches[j].toTime+"</td>";
						html+=  "<td>"+name+"</td>";
						html+=  "<td class='operation'> <a href='javascript:void(0);'class='apply' data-id='"+matches[i].id+"'>同意</a>&nbsp;<a href='javascript:void(0);'class='delte' data-id='"+matches[i].id+"'>拒绝</a>" +
							"</td>";
						html+="</tr>";
						$('.tab3>table>tbody').append(html)
					}
				}
			}
		})

	})
	$('.summary').on('click',function () {
		$('.tab1').hide()
		$('.tab2').hide()
		$('.tab3').hide()
		$('.tab4').show()
		$(this).addClass('bg_color').siblings().removeClass('bg_color')

		$('.tab3>table>tbody').html('')
		$.ajax({
			url:"./user/stringfiles",
			type:"post",
			contentType:"application/json",
			dataType:"json",
			success:function(res){
				var data = res.files
				console.log(data)
				for(var i = 0;i<data.length;i++){
					var name = data[i].name
					var files = data[i].files
					console.log(files)
					for(var j = 0; j<files.length;j++){
						var  file = files[j].substr(32)
						var html = ''
						html+="<tr>";
						html+=  "<td>"+name+"</td>";
						html+=  "<td>"+file+"</td>";
						html+=  "<td class='operation'> <a href='javascript:void(0);'class='apply' data-id='"+files[j]+"'>下载</a>" +
							"</td>";
						html+="</tr>";
						$('.tab4>table>tbody').append(html)
					}
				}
			}
		})

	})


	// tab1个人信息
	var sex;
	$('.man').on('click',function(){
		sex = '男'
	})
	$('.woman').on('click',function(){
		sex = '女'
	})
	$('.tab1 .modify').on('click',function(){
		$('.modify_information').show()
	})
	$('.modify_information .cancel').on('click',function(){
		$('.modify_information').hide()
		var sex = ''
	})
	$('.modify_information .determine').on('click',function() {
		var name = $('.input1').val()
		var age = $('.input2').val()
		var sex = $('.input3').val()
		var college = $('.input4').val()
		var data = {
			jobnumber: jobnumber,
			name: name,
			age: age,
			sex: sex,
			college: college
		}
		var json = JSON.stringify(data);
		$.ajax({
			url: "./edu/update",
			type: "post",
			contentType: "application/json",
			dataType: "json",
			data: json,
			success: function (res) {
				location.reload()
			}
		})
	})

	//tab3申请记录
	$('.tab3 table').on('click','.apply',function(){
		var id = $(this).attr('data-id')
		var text = {
			id:id,
			mark:4
		}
		var json=JSON.stringify(text);
		$.ajax({
			url:"./match/apply",
			type:"post",
			contentType:"application/json",
			dataType:"json",
			data:json,
			success:function(res){
				location.reload()
			}
		})
	})
	$('.tab3 table').on('click','.delte',function(){
		var id = $(this).attr('data-id')
		var text = {
			id:id,
			mark:0
		}
		var json=JSON.stringify(text);
		$.ajax({
			url:"./match/apply",
			type:"post",
			contentType:"application/json",
			dataType:"json",
			data:json,
			success:function(res){
				location.reload()
			}
		})
	})

	//tab4比赛总结资料
	$('.tab4 table').on('click','.apply',function(){
		var filename = $(this).attr('data-id')
		// var text = {
		// 		// 	filename:filename
		// 		// }
		// 		// var json=JSON.stringify(text);
		window.location.href='./user/download?filename='+filename
		// $.ajax({
		// 	url:"./match/apply",
		// 	type:"post",
		// 	contentType:"application/json",
		// 	dataType:"json",
		// 	data:json,
		// 	success:function(res){
		// 		location.reload()
		// 	}
		// })
	})

})