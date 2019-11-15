<?php
    header("Content-Type: text/html; charset=UTF-8");
    $con = mysqli_connect("localhost","bakhoijae","oexis7831","bakhoijae");

    $courseUniversity = $_GET["courseUniversity"];
 

    $result = mysqli_query($con,"SELECT * FROM M_COURSE WHERE courseUniversity = '$courseUniversity'");
    $response = array();
    while($row = mysqli_fetch_array($result)){
        array_push($response,array("courseID"=>$row[0],"courseUniversity"=>$row[1],"courseArea"=>$row[2],"courseTitle"=>$row[3],"courseCredit"=>$row[4],"courseProfessor"=>$row[5],"courseTime"=>$row[6]));

    }

    echo json_encode(array("response"=>$response),JSON_UNESCAPED_UNICODE);
    mysqli_close($con);

    ?>