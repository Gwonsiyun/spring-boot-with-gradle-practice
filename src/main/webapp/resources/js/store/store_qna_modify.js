function submitFn(){
	var result = true;


	value = document.getElementById("reviewContents").value;
	info = document.getElementById("contentInfo");
	if(value == ""){
		result = false;
		info.style.visibility = "visible";
	}else{
		info.style.visibility = "hidden";
	}
	
	
	if(result){
		
		var content =$("#reviewContents").val();
		content = content.trim();
		if(content==""){
			swal({
		         text: "내용을 입력하여주세요.",
		         button: "확인",
		         closeOnClickOutside : false
		      }).then(function(){
		         $(".reply_content_input_text").focus();
		      });
		}else{
			content = content.replace(/(\n|\r\n)/g,'<br>');
			
			$.ajax({
				type : "POST",
				url : "store_qna_modify.do",
				data : "content="+content+"&sqidx="+sqidx,
				success : function(res) {
					
					console.log(res);
					if(res>0){
						swal({
					         text: "상품문의가 수정되었습니다.",
					         button: "확인",
					         closeOnClickOutside : false
					      }).then(function(){
					         location.href="store_view.do?spidx="+spidx;
					      });
					}else{
						alert("실행오류");
					}
				}
			});
		}
	}
	
	
}

function resize(obj) {
    obj.style.height = '1px';
    obj.style.height = (12 + obj.scrollHeight) + 'px';
}
function cancelFn(){
	swal({
	      text: "이 페이지를 나가면 수정된 사항이 모두 유실됩니다!\n그래도 나가시겠어요?",
	      icon: "warning",
	      buttons: [" 취소 ", " 확인 "],
	      dangerMode: false,
	   })
	   .then((willDelete) => {
		      if (willDelete) {
		          location.href = "store_view.do?spidx="+spidx;
		   } else {
		      
		   }
		});
}
/* 이미지 업로드 */

function adjustHeight() {
	var textEle = $(".note-editable");
	textEle[0].style.height = 'auto';
	var textEleHeight = textEle.prop('scrollHeight');
	textEle.css('height', textEleHeight);
	textEle.css('overflow', 'hidden');
};

var textEle = $(".note-editable");
textEle.on('keyup', function() {
	adjustHeight();
});


function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function (e) {
			$("#imgArea").css("background-color", "none");
			$("#coverImg").attr("src", e.target.result);
			$("#coverImg").show();
			$("#imgArea img").css("width", "100%");
			$("#imgArea img").css("height", "100%");
			$("#imgText").css("display", "none");
			$("#imgButton").css("display", "none");
		}
		reader.readAsDataURL(input.files[0]);
	}
}

$(function() {
	$("#imgUpload").on("change", function(){
	readURL(this);
	});
});



$(document).ready(function() {
	
	
	$("#reviewContents").val(content);
	
	
});