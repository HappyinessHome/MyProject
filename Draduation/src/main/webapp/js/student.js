$(function(){
	var sto = localStorage.getItem('name');
	var json=JSON.stringify({sto:sto});
	$('.file_name').val(sto)
	$.ajax({
		url:"./user/getOne",
		type:"post",
		contentType:"application/json",
		dataType:"json",
		data:json,
		success:function(res){
			console.log(res)
			if(res.note == null){
				$('.name').text(sto)
				$('.check_state>p:nth-of-type(1)').html(res.sto)
				$('.check_state>p:nth-of-type(2)').html(res.name)
				$('.check_state>p:nth-of-type(3)').html(res.age)
				$('.check_state>p:nth-of-type(4)').html(res.sex)
				$('.check_state>p:nth-of-type(5)').html(res.college)
				$('.check_state>p:nth-of-type(6)').html(res.grade)
				$('.check_state>p:nth-of-type(7)').html(res.major)
				$('.input1').val(res.name)
				$('.input2').val(res.age)
				$('.input3').val(res.sex)
				$('.input4').val(res.college)
				$('.input5').val(res.grade)
				$('.input6').val(res.major)
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

		var json=JSON.stringify({tid:sto});
		$.ajax({
			url:"./match/getByTid",
			type:"post",
			contentType:"application/json",
			dataType:"json",
			data:json,
			success:function(res){
				var data = res
				console.log(data)
				for(var i = 0;i<data.length;i++){
					if(data[i].mark == 1){
						var text = '未申请'
					}else if(data[i].mark == 2){
						var text = '已申请'
						var html = ''
						html+="<tr>";
						html+=  "<td>"+data[i].type+"</td>";
						html+=  "<td>"+data[i].toTime+"</td>";
						html+=  "<td>"+data[i].name+"</td>";
						html+=  "<td>"+text+"</td>";
						html+=  "<td class='operation'> <a href='javascript:void(0);'class='apply' data-id='"+data[i].id+"'>撤回</a></td>";
						html+="</tr>";
						$('.tab3>table>tbody').append(html)
					}else if(data[i].mark == 3){
						var text = '审核中'
						var html = ''
						html+="<tr>";
						html+=  "<td>"+data[i].type+"</td>";
						html+=  "<td>"+data[i].toTime+"</td>";
						html+=  "<td>"+data[i].name+"</td>";
						html+=  "<td>"+text+"</td>";
						html+=  "<td class='operation'>等待结果</td>";
						html+="</tr>";
						$('.tab3>table>tbody').append(html)
					}else if(data[i].mark == 0){
						var text = '已拒绝'
						var html = ''
						html+="<tr>";
						html+=  "<td>"+data[i].type+"</td>";
						html+=  "<td>"+data[i].toTime+"</td>";
						html+=  "<td>"+data[i].name+"</td>";
						html+=  "<td>"+text+"</td>";
						html+=  "<td class='operation'> <a href='javascript:void(0);'class='detete' data-id='"+data[i].id+"'>删除</a></td>";
						html+="</tr>";
						$('.tab3>table>tbody').append(html)
					}else if(data[i].mark == 4){
						var text = '同意'
						var html = ''
						html+="<tr>";
						html+=  "<td>"+data[i].type+"</td>";
						html+=  "<td>"+data[i].toTime+"</td>";
						html+=  "<td>"+data[i].name+"</td>";
						html+=  "<td>"+text+"</td>";
						html+=  "<td class='operation'> </td>";
						html+="</tr>";
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
	$('.modify_information .determine').on('click',function(){
		// $('.modify_information').hide()
		var name = $('.input1').val()
		var age = $('.input2').val()
		var sex = $('.input3').val()
		var college = $('.input4').val()
		var grade = $('.input5').val()
		var major = $('.input6').val()
		var data = {
			sto:sto,
			name:name,
			age:age,
			sex:sex,
			college:college,
			grade:grade,
			major:major
		}
		var json=JSON.stringify(data);
		$.ajax({
			url:"./user/update",
			type:"post",
			contentType:"application/json",
			dataType:"json",
			data:json,
			success:function(res){
				location.reload()
			}
		})
	})


	//tab2申请比赛
	$('.application .match_apply').on('click',function(){
		var match_type = $('.match_type').val()
		var match_name = $('.match_name').val()
		var match_time = $('.match_time').val()
		var text = {
			tid:sto,
			type:match_type,
			name:match_name,
			time:match_time,
			mark:2
		}
		var json=JSON.stringify(text);
		$.ajax({
			url:"./match/add",
			type:"post",
			contentType:"application/json",
			dataType:"json",
			data:json,
			success:function(res){
				location.reload()
			}
		})
	})

	//tab3申请记录
	$('.tab3 table').on('click','.apply',function(){
		var id = $(this).attr('data-id')
		var text = {
			id:id
		}
		var json=JSON.stringify(text);
		$.ajax({
			url:"./match/delete",
			type:"post",
			contentType:"application/json",
			dataType:"json",
			data:json,
			success:function(res){
				location.reload()
			}
		})
	})
	$('.tab3 table').on('click','.detete',function(){
		var id = $(this).attr('data-id')
		var text = {
			id:id
		}
		var json=JSON.stringify(text);
		$.ajax({
			url:"./match/delete",
			type:"post",
			contentType:"application/json",
			dataType:"json",
			data:json,
			success:function(res){
				location.reload()
			}
		})
	})

	//tab4上传资料
	// $('.submit').on('click',function () {
	// 	var data = new FormData;
	// 	data.append("testfile",document.getElementById("upload").files[0]);
	// 	data.append("token",1111);
	// 	// console.log(document.getElementById("upload").files[0])
	// 	console.log(data)
	// 	// $.ajax({
	// 	// 	url:'http://www.baidu.com/',
	// 	// 	type:'post',
	// 	// 	data: data,
	// 	// 	contentType: false,
	// 	// 	processData: false,
	// 	// 	success:function(res){
	// 	// 		console.log(res.data);
	// 	// 		if(res.data["code"]=="succ"){
	// 	// 			alert('成功');
	// 	// 		}else if(res.data["code"]=="err"){
	// 	// 			alert('失败');
	// 	// 		}else{
	// 	// 			console.log(res);
	// 	// 		}
	// 	// 	}
	// 	// })
	// })
})