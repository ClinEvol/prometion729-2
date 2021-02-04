function createPages(page) {
    $(".pageList").html("");
    $(".pageList").append("<span>共有"+page.pages+"页,当前是第"+page.pageNum+"页</span>");
    $(".pageList").append("<a data-pagenum='1' href='javascript:void(0)'>首页</a>");
    if(!page.isFirstPage){//不是第一页
        $(".pageList").append("<a data-pagenum='"+page.prePage+"' href='javascript:void(0)'>上一页</a>");
    }
    //循环页码
    for(i=1;i<=page.pages;i++){
        var $a="<a data-pagenum='"+i+"' href='javascript:void(0)'>"+i+"</a>";

        if(page.pageNum==i){
            $a="<a class='active' data-pagenum='"+i+"' href='javascript:void(0)'>"+i+"</a>";
        }

        var condition=page.pageNum-2<=i && page.pageNum+2>=i;
        if(page.pageNum<3){
            condition=page.pageNum-2<=i && page.pageNum+2+(3-page.pageNum)>=i;
        }else if(page.pageNum>page.pages-3){
            condition=page.pageNum-2-(2-(page.pages-page.pageNum))<=i && page.pageNum+2>=i;
        }
        if(condition){
            $(".pageList").append($a);
        }
    }

    if(!page.isLastPage){//不是最后一页
        $(".pageList").append("<a data-pagenum='"+page.nextPage+"' href='javascript:void(0)'>下一页</a>");
    }
    $(".pageList").append("<a data-pagenum='"+page.pages+"' href='javascript:void(0)'>尾页</a>");
}








