/**
 * 
 */
window.onload = function(){
	$('details').each(function(){
		$(this).removeAttr("open");
	})
	$('.order').attr("open","open");
    $(".order").removeClass("detail");
    $(".order").addClass("subdetail");
    $(".order").click(function(){
        $(this).removeClass("subdetail");
        $(this).addClass("detail");
    })
}