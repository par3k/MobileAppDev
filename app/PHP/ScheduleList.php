<?php
    header("Content-Type: text/html; charset=UTF-8");
    $con = mysqli_connect("localhost","bakhoijae","oexis7831","bakhoijae");

    $userID = $_GET["userID"];

    $result = mysqli_query($con, "SELECT M_COURSE.courseID, M_COURSE.courseTime, M_COURSE.courseProfessor, M_COURSE.courseTitle FROM M_USER,M_COURSE,
M_SCHEDULE WHERE M_USER.userID = '$userID' AND M_USER.userID = M_SCHEDULE.userID AND M_SCHEDULE.courseID = M_COURSE.courseID");
    $response = array();
    while($row = mysqli_fetch_array($result)){
        array_push($response, array("courseID"=>$row[0], "courseTime"=>$row[1], "courseProfessor"=>$row[2], "courseTitle"=>$row[3]));
    }

    echo json_encode(array("response"=>$response), JSON_UNESCAPED_UNICODE);
    mysqli_close($con);
?>