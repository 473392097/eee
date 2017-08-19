//
$(function () {
    //alert("页面加载完成了")

    $.ajax({
        type:"post",
        url:'/first_findDepart',
        async:false,
        success:function (data) {
            var dep_str=data;
            var dep_obj=eval('('+dep_str+')')
            console.log(dep_str);
            console.log(dep_obj);

            for ( var i=0;i<dep_obj.length;i++){
                //alert(dep_obj[i].depName);
                $("#dep").append("<option value='" + dep_obj[i].depId + "'>" + dep_obj[i].depName + "</option>");

            }

            $("#dep").change(function(data){
                //含义
                var index=$(this).select().val();
                // alert(index)
                $("#post").empty()

                for (var i=0;i<(dep_obj[index-1]).postSet.length;i++){

                    $("#post").append('<option value="'+(dep_obj[index-1]).postSet[i].postId+'">'+(dep_obj[index-1]).postSet[i].postName+'</option>');
                }

            });

        }
    })
})