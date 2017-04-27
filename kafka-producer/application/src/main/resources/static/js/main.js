function send(color, x, y) {
	$.ajax({
	    type: "POST",
	    url: "/send",
	    data: JSON.stringify({ "color": color, "x":  x, "y":  y}),
	    contentType: "application/json; charset=utf-8",
	    dataType: "json"
	});
}

$(function() {
	$( ".c1" ).click(function(e) {
		send("red", e.pageX, e.pageY);
	});
	$( ".c2" ).click(function(e) {
		send("green", e.pageX, e.pageY);	
	});
	$( ".c3" ).click(function(e) {
		send("blue", e.pageX, e.pageY);
	});
	$( ".c4" ).click(function(e) {
		send("yellow", e.pageX, e.pageY);
	});
});