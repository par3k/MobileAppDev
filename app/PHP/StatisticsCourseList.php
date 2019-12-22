<?php
    header("Content-Type: text/html; charset=UTF-8");
    $con = mysqli_connect("localhost","bakhoijae","oexis7831","bakhoijae");

    $userID = $_GET["userID"];

    $result = mysqli_query($con, "SELECT M_COURSE.courseID, M_COURSE.courseTitle, M_COURSE.coursePersonnel
        , COUNT(M_SCHEDULE.courseID), M_COURSE.courseCredit FROM M_SCHEDULE, M_COURSE WHERE M_SCHEDULE.courseID IN (SELECT M_SCHEDULE.courseID FROM
        M_SCHEDULE WHERE M_SCHEDULE.userID = '$userID') AND M_SCHEDULE.courseID = M_COURSE.courseID GROUP BY M_SCHEDULE.courseID");
    $response = array();
    while($row = mysqli_fetch_array($result)){
        array_push($response, array("courseID"=>$row[0], "courseTitle"=>$row[1],
         "coursePersonnel"=>$row[2], "COUNT(M_SCHEDULE.courseID)"=>$row[3],"courseCredit"=>$row[4]));
    }

    echo json_encode(array("response"=>$response), JSON_UNESCAPED_UNICODE);
    mysqli_close($con);
?>
