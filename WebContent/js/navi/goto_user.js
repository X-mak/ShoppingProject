/**
 * 
 */
window.onload = function(){
	$('details').each(function(){
		$(this).removeAttr("open");
	})
	$('.user').attr("open","open");
    $(".user").removeClass("detail");
    $(".user").addClass("subdetail");
    $(".user").click(function(){
        $(this).removeClass("subdetail");
        $(this).addClass("detail");
    })
}