<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" enctype="multipart/form-data">
	<p>
		<input type='text' name='p1' value='AAAA'>
	</p>
	<p>
		<input type='file' name='file'>
	</p>
	<p>
		<button>Save</button>
	</p>
</form>
<hr/>
<hr/>
<hr/>

<style>
.fileDrop{width: 400px; height:300px; background-color: gray;}
</style>

<div class='fileDrop'>
</div>
	
	<div >
		<ul class='uploadedList'>

		</ul>
	</div>

<script
 src="https://code.jquery.com/jquery-3.2.1.min.js"
 integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
 crossorigin="anonymous"></script>

<script>

$(document).ready(function() {

	$(".fileDrop").on("dragenter dragover", function(event) {
		event.preventDefault();
		
	})
	
	$(".fileDrop").on("drop", function(event) {
		event.preventDefault();
		console.log("droped.....")
		/*순수한 이벤트 처리  (배열)*/
		var files = event.originalEvent.dataTransfer.files;
		
		console.log(files);
		
		var file = files[0]
	
		var formData = new FormData();
		
		formData.append("file", file);
		
		$.ajax({
			url:"/web/upload1",
			data:formData,  //file[]로 들어감
			processData:false, 
			contentType:false,
			type:'post',
			success:function(result){
				console.log("upload complete!!!!!!!!!!!");
				/* alert(result); */ //result가 json배열.
				
				var str="<li><img src='display?fileName="+result+"'></li><button id='del'>삭제</button>";
				$(".uploadedList").append(str);
			}
		
			
		}); // end ajax
		
		$(".uploadedList").on("click", function(event){
		$(".uploadedList li button").on("click", function(event){
			event.preventDefault();
			$(this).parent().remove();
			
		})
		}) // end uploaded list	
		
	})
})


</script>


</body>
</html>