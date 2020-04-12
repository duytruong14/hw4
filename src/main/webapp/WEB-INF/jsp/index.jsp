<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>hw4</title>
    <style>
        table {
            font-family: "Times New Roman", sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        H2{

        }
        H1{

        }
        textarea{
            alignment: center;
        }

        td {
            border: 3px solid #2b0808;
            padding: 8px;
            width: 160px;

        }
        th{
            border: 4px solid #dddddd;
            alignment: center;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body style="background:#FBF8EF">
<H1 align="center">Duy Report on Chuck </H1>
<H2 align="left">Chuck Norris Random Fact</H2>



<form method="post" action="/save">
<textarea  rows="10" cols="40" type="text" name="old" >${rando}</textarea>

<br></br>
<input type="button" value="Load" onclick="load()">
    <input type="submit" value="Submit (Click on this before click load to save the value)" >
    <div id="div" style="display: none">
    <table>
<c:forEach var = "listitem" items = "${Apilist}">

    <tc>
        <td>${listitem.getOld()}</td>


        <td><a href="/delete/${listitem.getOld()}"><img src="../../img/delete2.png" style="width:101px;height:101px;" ></a></td>
    </tc>
</c:forEach>
    </table>
    </div>
</form>
<table id="chuck" style="display: none">
    <c:forEach var = "listitem" items = "${Apilist}">

        <tc>

            <td>${listitem.getOld()}</td>



            <td><a href="/delete/${listitem.getOld()}"><img src="../../img/delete2.png" style="width:101px;height:101px;" ></a></td>

        </tc>
    </c:forEach>
</table>
<script>
    function load() {document.getElementById('chuck').style.display="grid";};
</script>
</body>
</html>
