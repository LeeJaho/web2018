/*example 0 - 초기화 블록*/
//기능을 숨기고 jQuery로 window기능들을 사용하겠다.

//DOM준비되면 실행된다
$(function(){
    // alert("hello");
});


/*example 1 - 노드선택*/
$(function(){
    //var okButton = document.querySelector("ex1 .btn-default");
    //var jButton = $(okButton);
    var okButton = $("#ex1 .btn-default");
    okButton.val("호호호");
});

/*example 2 - 이벤트 처리하기*/
$(function(){

    var okButton = $("#ex2 .btn-default");
    // okButton.onclick=?;
    // okButton.addEventListener("click",?);

    // okButton.on("click", function(){
    //     alert("호호호호호호호");
    // });

    okButton.click(function(){
        alert("흐하흐하");
    });

});

/*example 3 - 속성과 스타일 수정하기*/
$(function(){

    var okButton = $("#ex3 .btn-default");
    var img = $("#ex3 img");
    var textBox = $("#ex3 input[type=text]");
    okButton.click(function(){
       /*img.attr("src", "images/han.png");*/
    	// var imgName = textBox.val();
        // img.attr("src", "images/" + imgName);
    	
        /*img.css("width", "300px");
        img.css("height", "100px");
        img.css("box-shadow", "#979797 3px 3px 3px");*/
        
        var imgStyle = {
        		width: "300px",
        		height:"100px",
        		boxShadow: "#979797 3px 3px 3px"
        };
        
        img.css(imgStyle);
        
    });

});