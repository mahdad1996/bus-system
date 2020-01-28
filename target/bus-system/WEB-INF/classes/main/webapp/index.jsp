<html lang="fa">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="resources/css/Style.css">
    <link rel="stylesheet" href="resources/css/bootstrap.css">


</head>
<body>

<%@ page pageEncoding="UTF-8" %>

<jsp:include page="masterHeaderMenu.jsp"></jsp:include>


<div class="container">

    <div class="row">

        <div class="search-form">
            <form>
                <div class="form-group">
                    <label class="form-control">انتخاب مبدا</label>
                    <input list="browsers" name="myBrowser" /></label>
                    <datalist id="browsers">
                        <option value="Chrome">
                        <option value="Firefox">
                        <option value="Internet Explorer">
                        <option value="Opera">
                        <option value="Safari">
                        <option value="Microsoft Edge">
                    </datalist>
                </div>
            </form>


        </div>


    </div>
</div>

<jsp:include page="masterFooter.jsp"></jsp:include>





  <script type="javascript" src="resources/js/jquery-3.4.1.slim.min.js"></script>
  <script type="javascript" src="resources/js/popper.min.js"></script>
  <script type="javascript" src="resources/js/bootstrap.js"></script>

</body>
</html>
