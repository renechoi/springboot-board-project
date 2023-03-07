<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JBlog</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>

<div id="container">

    <!-- 블로그 해더 -->
    <c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>


    <div id="wrapper">
        <div id="content" class="full-screen">
            <ul class="admin-menu">
                <li><a href="${pageContext.request.contextPath}/blog/${authUser.id}/admin/basic">기본설정</a></li>
                <li class="selected"><a href="${pageContext.request.contextPath}/blog/${authUser.id}/admin/category">카테고리</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/blog/${authUser.id}/admin/write">글작성</a></li>
            </ul>

            <table class="admin-cat">
                <thead>
                <tr>
                    <th>카테고리명</th>
                    <th>포스트 수</th>
                    <th>설명</th>
                    <th>삭제</th>
                </tr>
                </thead>
                <tbody id=cateList>

                </tbody>
            </table>

            <h4 class="n-c">새로운 카테고리 추가</h4>
            <table id="admin-cat-add" data-userno="${blog.userId}">
                <tr>
                    <td class="t">카테고리명</td>
                    <td><input type="text" name="name" value=""></td>
                </tr>
                <tr>
                    <td class="t">설명</td>
                    <td><input type="text" name="desc"></td>
                </tr>
                <tr>
                    <td class="s">&nbsp;</td>
                    <td><input id="btnAddCate" type="submit" value="카테고리 추가"></td>
                </tr>
            </table>

        </div>
    </div>
    <div id="footer">
        <p>
            <strong>Spring 이야기</strong> is powered by JBlog (c)2016
        </p>
    </div>
</div>
</body>


<script type="text/javascript">

    $(document).ready(function () {
        fetchList();
    });


    //카테고리 등록
    $("#btnAddCate").on("click", function () {
        let cateName = $("[name=name]").val();
        let description = $("[name=desc]").val();
        let userId = `${blog.userId}`;
        console.log(cateName);
        console.log(description);
        console.log(userId);

        let category = {
            categoryName: cateName,
            categoryDescription: description,
            userId: userId
        };
        $.ajax({
            url: "${pageContext.request.contextPath }/api/category/add",
            type: "post",
            data: category,
            dataType: "json",
            success: function (category) {
                console.log(category);
                render(category, "up");
                $("[name=name]").val("");
                $("[name=desc]").val("");

            },
            error: function (XHR, status, error) {
                console.error(status + " : " + error);
            }
        });

    });


    //카테고리 삭제
    $("#cateList").on("click", ".btn_cateDel", function () {
        let $this = $(this)
        let categoryNo = $this.data("categoryNo");
        let cnt = $this.data("cnt");
        console.log(cnt);
        if (cnt > 0) {
            alert("삭제할 수 없습니다.")
        } else {
            $.ajax({
                url: "${pageContext.request.contextPath }/api/category/remove",
                type: "post",
                data: {categoryNo: categoryNo},
                dataType: "json",
                success: function (result) {
                    if (result == 1) {
                        $this.parents("tr").remove();
                    } else {
                        console.log("삭제실패");
                    }
                },
                error: function (XHR, status, error) {
                    console.error(status + " : " + error);
                }
            });
        }


    });


    function fetchList() {

        $.ajax({
            url: "${pageContext.request.contextPath }/api/category/list",
            type: "post",
            dataType: "json",
            success: function (categories) {
                console.log(categories)
                for (var i = 0; i < categories.length; i++) {
                    render(categories[i], "down");
                }
            },
            error: function (XHR, status, error) {
                console.error(status + " : " + error);
            }
        });

    }


    /* 게시물을 화면에 표현합니다. */
    function render(category, updown) {

        console.log(category)

        var str = "" +
            "<tr>" +
            // "<td>" + category.categoryNo + "</td>" +
            "<td>" + category.categoryName + "</td>" +
            "<td>" + category.cnt + "</td>" +
            "<td>" + category.categoryDescription + "</td>" +
            "<td><img class='btn_cateDel' data-cateno='" + "'  data-cnt='" + category.cnt + "'  src='${pageContext.request.contextPath}/assets/images/delete.jpg'></td>" +
            "</tr>"

        console.log(str);

        if (updown == "up") {
            $("#cateList").prepend(str);
        } else if (updown == "down") {
            $("#cateList").append(str);
        } else {
            console.log("updown 오류")
        }
    }


</script>


</html>