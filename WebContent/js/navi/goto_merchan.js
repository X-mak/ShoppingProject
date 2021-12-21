window.onload = function(){
	$('details').each(function(){
		$(this).removeAttr("open");
	})
	$('.merchan').attr("open","open");
    $(".merchan").removeClass("detail");
    $(".merchan").addClass("subdetail");
    $(".merchan").click(function(){
        $(this).removeClass("subdetail");
        $(this).addClass("detail");
    })
}