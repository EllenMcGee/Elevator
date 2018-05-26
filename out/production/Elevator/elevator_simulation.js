var arr = [1,2,3,4,5,6];

$(document).ready(function(){

$('.Button').click(function() {
    $(this).toggleClass("active");
});

	//$("#move").animate({left: '+=100px'}, "slow");
$.each(arr, function(i, val){
	$("#floor" + val).click(function(){

		var movement = $("#box").animate({top: '+' + (6-val)*(550/6)}, 1000);

		$.when(movement).done(function(){
			var fade = $("#movable").fadeOut("slow");

			$.when(fade).done(function(){
				$("#movable").attr("src", "elevator_open.jpg" );
				$("#movable").fadeIn("slow");
				var fade2 = $("#movable").fadeOut("slow");

				$.when(fade2).done(function(){
					$("#movable").fadeOut("slow");
					$("#movable").attr("src", "elevator_closed.jpg" );
					$("#movable").fadeIn("slow");
				});
			});
		});

            console.log("hi")
			$.get( "http://0.0.0.0:4567/hello?floorNum=" + val, function( data ) {
//  		$( ".result" ).html( data );
console.log(data)
	$("#time").html(data);

//  		alert( "Load was performed." );

	});

//	$("#time").html(val);
	});



	});


});