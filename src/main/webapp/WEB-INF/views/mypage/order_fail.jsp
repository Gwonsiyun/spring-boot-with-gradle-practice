<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 부트스트랩 -->
	<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Bootstrap icon CSS-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css" />
    <!-- kakao SDK -->
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <!-- naver SDK -->
    <script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
    <!-- facebook SDK -->
    <script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></script>
	<script>var contextPath = "${pageContext.request.contextPath}"</script>
    
	<title>주문실패 - 홈프렌즈</title>
	
		
	<link href="/resources/css/header.css" rel="stylesheet">
	<link href="/resources/css/nav.css" rel="stylesheet">
	<link href="/resources/css/mypage/order_success.css" rel="stylesheet">
	<link href="/resources/css/footer.css" rel="stylesheet">
	
	<script src="/resources/js/jquery-3.6.0.min.js"></script>
	<script src="/resources/js/header.js"></script>
	<script src="/resources/js/nav.js"></script>
	<script src="/resources/js/footer.js"></script>
	
	
</head>
<body>
	<%@ include file="../header.jsp" %>
	<%@ include file="../nav.jsp" %> 
	
	<!-- 본문 영역 -->	
	<section>
	<div class="container">
			<div class="row">
				<div class="col-12 coll-pull-12 coll-md-12 col-lg-12 col-xl-12 odrWrap">
					<form>
						<div class="order_title">
							 주문실패
						</div>
						<div class="odr orderBox">
							<div id="iconDIV">
								<i class="bi bi-emoji-frown"></i>
								<i class="bi bi-cart-x"></i>
							</div>
							<div class="odrDiv">
								<p class="okTitle">죄송합니다.</p>
								<p class="odrdetail">주문이 정상적으로 처리되지 않았습니다.</p>
								<p class="odrdetail">실패 사유 : ${payInfovo.errorMsg}</p>
								<p class="odrdetail">다시 시도해주세요.</p>
							</div>
							<!--  <div class="inlineDiv">
								<p class="odrTitle">주문번호</p>
								<p>DFWE2321321</p>
							</div>		
							<div  class="inlineDiv">
								<p class="odrTitle">주문금액</p>
								<p>382000원</p>
							</div>-->
						</div>
					</form>
				</div>
			</div>
			<div id="returnArea">
				<input type="button" id="return" value="장바구니로 돌아가기" onclick="location.href='${pageContext.request.contextPath}/mypage/basket.do'">
			</div>
		</div>
	</section>

	<%@ include file="../footer.jsp" %>
	<!-- 부트스트랩 -->	

	<!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	-->
	


</body>
</html>