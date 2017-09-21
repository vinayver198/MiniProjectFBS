
<body>
<div align="left" style="padding: 2%;">Welcome : ${sessionScope.userName}</div>
<div>

<div style="
    width: 30%;
    background-color: white;
    position: absolute;
    padding-left: 2%;
    float: left;">

<a href="LoginController?action=back">Back</a>
<a href="LoginController?action=home">Home</a>

</div>

<div style="
    width: 60%;
    background-color: white;
    float: right;">
    <div align="right" style="padding: 1%;"><a align="" href="LoginController?action=logout">Logout</a></div>
</div>

</div>

<div align="center"><h1 style="margin: 4%;">${pageHeading}</h1></div>

</body>
