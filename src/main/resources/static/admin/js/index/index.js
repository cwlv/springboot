/**
 * 菜单
 */
$(function(){
    layui.use('element', function(){
        var element = layui.element;
        // 左侧导航区域（可配合layui已有的垂直导航）
        $.post("/admin/perm/getPermUser",function(data){
            if(data.code == '200'){
                var permList = data.data.permList;       //权限列表
                renderMenu(permList);
                element.render('nav');
            }else{  //没有权限
                layer.alert(data.message,function () {
                    //退出
                    window.location.href="/logout";
                });
            }
        });
    });
})



function renderMenu(menu) {
    var ul = $("<ul id=\"nav\"></ul>");
    for(var i=0;i < menu.length;i++){
        var node = menu[i];   //菜单节点
        if(node.menu_type == '10'){     //目录菜单
            var li = $("<li></li>");
            var a = $("<a href=\"javascript:;\">" +
                "<i class=\"layui-icon\">" + node.icon + "</i>" +
                "<cite>"+ node.menu_name +"</cite>" +
                "<i class=\"iconfont nav_right\">&#xe697;</i></a>");
            li.append(a);
            if(node.childPermission.length > 0){
                li.append(childMenu(node.childPermission));
            }
            ul.append(li);
        }
    }
    $("#nav").append(ul);
}


function childMenu(child){
    var ul = $("<ul class=\"sub-menu\">");
    for(var i=0;i<child.length;i++){
        if(child[i].menu_type == '30'){  //按钮不显示
            continue;
        }
        var li = $("<li date-refresh=\"1\">");
        var a = $("<a _href=" + child[i].menu_url + "> " +
            "<i class=\"layui-icon\">"+ child[i].icon + "</i>" +
            "<cite>" + child[i].menu_name +"</cite>" +
            "<i class=\"iconfont nav_right\">&#xe697;</i>");
        li.append(a);
        ul.append(li)
    }
    return ul;
}