window.addEventListener('load',function(){
    var rotation = document.querySelector('.rotation');
    var arrow_l = document.querySelector('.prev');
    var arrow_r = document.querySelector('.next');
    var rotation_width = rotation.offsetWidth;
    

    var num = 0;
    var circle = 0;
    var flag = true;

    rotation.addEventListener('mouseenter',function(){
        arrow_l.style.display = "block";
        arrow_r.style.display = "block";

        clearInterval(timer);
        timer = null;
    })
    rotation.addEventListener('mouseleave',function(){
        arrow_l.style.display = "none";
        arrow_r.style.display = "none";

        timer = setInterval(function(){
            arrow_r.click();
        },3000)
    })


    //动态生成小圆圈 
    var ul = rotation.querySelector('ul');
    var ol = rotation.querySelector('ol');
    for(var i = 0;i < ul.children.length;i++){
        var li = document.createElement('li');
        li.setAttribute('index',i);//记录小圆圈的索引号
        li.addEventListener('click',function(){
            for(var i = 0;i < ol.children.length;i++){
                ol.children[i].className = '';
                this.className = 'current';

                // 点击小圆圈移动图片
                var index = this.getAttribute('index');
                num = index;
                circle = index;
                // console.log(picswidth);
                console.log(index);
                animate(ul,-index*rotation_width);//picswidth是为图片宽
            }
        })
        ol.appendChild(li);
        // 对小圆圈的操作
    }

    ol.children[0].className = 'current';
    var first = ul.children[0].cloneNode(true);
    ul.appendChild(first);

    arrow_r.addEventListener('click',function(){
        //无缝滚动
        if(flag){
            flag=false;//关闭节流阀
            if(num == ul.children.length-1){
                ul.style.left = 0;
                num = 0;
            }
            num++;
            animate(ul,-num*rotation_width,function(){
                flag = true;
            });
    
            
            if(circle == ol.children.length-1){
                circle = -1;
            }
            circle++;
            for(var i = 0;i < ol.children.length;i++){
                ol.children[i].className = '';
            }
            // console.log(circle);
            ol.children[circle].className = 'current';
        }
    });

    arrow_l.addEventListener('click',function(){
        //无缝滚动
        if(flag){
            flag = false;
            if(num == 0){
                num = ul.children.length-1;
                ul.style.left = -num*rotation_width+'px';
                // console.log(ul.offsetLeft);
               
            }
            
            num--;
            animate(ul,-num*rotation_width,function(){
                flag = true;
            });
            // console.log(num);
            circle--;
            if(circle < 0){
                circle = ol.children.length-1;
            }
            
            for(var i = 0;i < ol.children.length;i++){
                ol.children[i].className = '';
            }
            ol.children[circle].className = 'current';
        }

    });

    var timer = setInterval(function(){
        // 手动调用点击事件
        arrow_r.click();
    },3000)
    
})