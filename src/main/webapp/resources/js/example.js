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

    var okButton = $("#ex3 .btn-okay");
    var toggleButton = $("#ex3 .btn-toggle");
    var img = $("#ex3 img");
    var textBox = $("#ex3 input[type=text]");
    
    okButton.click(function(){
    //    img.attr("src", "images/han.png");
    // 	// var imgName = textBox.val();
    //     // img.attr("src", "images/" + imgName);
    	
    //     img.css("width", "300px");
    //     img.css("height", "100px");
    //     img.css("box-shadow", "#979797 3px 3px 3px");
        
        // var imgStyle = {
        // 		width: "300px",
        // 		height:"100px",
        // 		boxShadow: "#979797 3px 3px 3px"
        // };
        
        // img.css(imgStyle);

        //5. 정적인 스타일은 CSS(.zoom-in)로 준비하기
        img.addClass("zoom-in");
        
    });
    
    toggleButton.click(function(){
    if(!(img.hasClass("zoom-in")))
        img.addClass("zoom-in");
    else
        img.removeClass("zoom-in");
    });
});


/*example 3 - 속성과 스타일 수정하기*/
$(function(){

    var okButton = $("#ex4 .btn-okay");
    var cssButton = $("#ex4 .btn-css");
    var img1 = $("#ex4 img:nth-child(1)");
    var img2 = $("#ex4 img:nth-child(2)");
    //1. css변화에 duration을 추가
    okButton.click(function(){
    	
        // var imgStyle = {
        // 		width: "300px",
        // 		height:"100px",
        // 		"box-shadow": "#979797 3px 3px 3px"
        //     };
        
        // img.animate(imgStyle, 3000);

         //2. css의 변화에 순서를 주고 싶을 때
        /*img1
        .animate({
            width: "300px"
        })
        .animate({
            height:"100px"
        });
        
        img2
        .animate({
            width: "300px",
            height:"100px"
        });*/
    	
    	 //3. 두 애니메이션의 동기화 (1)delay, (2) callback function
    	img1
        .animate({
            width: "300px"
        }, function(){
        	img2
            .animate({
                width: "300px",
                height:"100px"
            })
        	
        })
        .animate({
            height:"100px"
        },2000);
    });
    
    //4. css로 변경하기
    cssButton.click(function(){
        // img1
        // .css({
        //     width: "300px"
        // })
        // .css({
        //     height:"100px"
        // });

       /* if(!(img2.hasClass("animate")))
            img2.addClass("animate");
       else
            img2.removeClass("animate");*/
    	
    	/*img2.removeClass("animate");
    		setTimeout(function(){
    			img2.addClass("animate");	
			}, 100);*/
    	
    	img2.on("animationend", function(){
    		alert("애니메이션 종료");	
    	});
    	img2.addClass("animate");
    });
});
/*example 5 - 화면전환 예제*/
$(function(){
    var okButton = $("#ex5 .btn-ok");

    okButton.click(function(){

    });
});

/*example 6 - 화면전환 예제*/
$(function(){
    var addButton = $("#ex6 .btn-add");
    var removeButton = $("#ex6 .btn-remove");
    var box = $("#ex6>div:nth-child(2)");/*2번째 차일드가 div가 맞니? 느낌 */
    
    addButton.click(function(){
    /*//1.text 노드 추가하자
    
        var text = "HEllo";
        box.append(text);
  
    */
    //2.img 노드 추가하기
    /*
     * $(img); -> Wrapping
     * $("img"); -> Selecting
     * $("<img />"); -> Creating
     * */
    
    //1) 노드추가방식
    /*var img = $("<img/>").attr("src", "images/han.png");
    box.append(img);*/
    
    //2) JQuery스럽게 추가하는 방식
    	$("<img/>")
    	.attr("src", "images/han.png")
        .appendTo(box);
    });
    
    removeButton.click(function(){
        //방법1
        /*box
    	.children()//Box의 DOM 자식들을 담는 캐리어(jQuery) 객체 하나
    	.first()//->Box에 담겨진 element 중에서 첫번째 객체
        .remove();*/
        
        //방법2
        // box
        // .children(":first-child")
        // .remove();

        //방법3
        // box
        // .find(":first-child")   //->Box의 자손들 중에 첫번째 : 
        //                         //주의) 중첩된 구조일 경우 여러 객체가
        //                         //선택될 수도 있다!
        // .remove();

        box.empty();
    });
});