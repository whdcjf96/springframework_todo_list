<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>detail.jsp</title>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>
    <table>
        <tr>
            <th>id</th>
            <td>${detail.id}</td>
        </tr>
        <tr>
            <th>writer</th>
            <td>${detail.boardWriter}</td>
        </tr>
        <tr>
            <th>date</th>
            <td>${detail.boardCreatedTime}</td>
        </tr>
        <tr>
            <th>hits</th>
            <td>${detail.boardHits}</td>
        </tr>
        <tr>
            <th>title</th>
            <td>${detail.boardTitle}</td>
        </tr>
        <tr>
            <th>contents</th>
            <td>${detail.boardContents}</td>
        </tr>
    </table>
    <button onclick="listFn()">목록</button>
    <button onclick="updateFn()">수정</button>
    <button onclick="deleteFn()">삭제</button>

<div>
    <input type="text" id="commentWriter" placeholder="작성자">
    <input type="text" id="commentContents" placeholder="내용">
    <button id="comment-write-btn" onclick="commentWrite()">댓글작성</button>
</div>


</body>

</html>