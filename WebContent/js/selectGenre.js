function changeGenre(){
	var school = document.form.firstgenre.value;
	var genreList = new Array();
	genreList["生活用品"]=['枕头','床被','蚊帐','台灯','床垫','床','床头柜','衣服','裤子'];
	genreList["体育用品"]=['篮球','足球','网球','乒乓球'];
	genreList["学习用品"]=['笔','纸','橡皮擦','读物','纸张','修正带','量角器'];
	genreList["食品"]=['水果','主食','零食','饮料'];
	
	document.form.secondgenre.options.length = 0;
	var pIndex = document.form.firstgenre.value;
	var newOption;
	document.form.secondgenre.options.length = 0;
	for (var j in genreList[pIndex]){
		newOption = new Option(genreList[pIndex][j],genreList[pIndex][j]);
		document.form.secondgenre.options.add(newOption);
	}
}