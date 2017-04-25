<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Modal Example</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" id='modalBtn'>Open Modal</button>

  <!-- Modal!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
  
			   <style>
			.fileDrop{width: 400px; height:300px; background-color: gray;}
			</style>     
        
        
         <!--  <form id="f1" action="upload2" method="post" enctype="multipart/form-data">
	          <p>Some text in the modal.
	        		  <input type='file' name='file[]'> param[]를 줌 그다음 홈컨트롤러
	          </p>
	          <p>Some text in the modal.
	        		  <input type='file' name='file[]'>
	          </p>
	        		  <p>Some text in the modal.
	          <input type='file' name='file[]'>
	          </p>
          </form> -->
          <div class='fileDrop'></div>
        </div> <!-- end modal-body -->
        
        <div class="modal-footer">
        	<button type="button" class="btn btn-danger saveBtn">Save</button> <!-- danger쓰면 빨간박스 -->
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>  <!--end modal!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  -->
  
</div>
<script>

$(document).ready(function(){

	$(".saveBtn").click(function(e){
		$("#f1").submit();
	}); //end savaBtn
	
	$("#modalBtn").click(function(){
		$("#myModal").modal("toggle");
		
	})
	
	$(".fileDrop").on("dragenter dragover", function(event) {
		event.preventDefault();
		
	})
	
	$(".fileDrop").on("drop", function(event) {
		event.preventDefault();
		alert("드랍완료");
	
		$("#myModal").modal("hide")
		
	})//end fileDrop

})

</script>
</body>
</html>
