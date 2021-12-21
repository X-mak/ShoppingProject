/**
 * 
 */
window.onload = function(){
	$('details').each(function(){
		$(this).removeAttr("open");
	})
	$('.me').attr("open","open");
    $(".me").removeClass("detail");
    $(".me").addClass("subdetail");
    $(".me").click(function(){
        $(this).removeClass("subdetail");
        $(this).addClass("detail");
    })
}