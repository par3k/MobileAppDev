<?php
    header("Content-Type: text/html; charset=UTF-8");
    $con = mysqli_connect("localhost","bakhoijae","oexis7831","bakhoijae");

    $result = mysqli_query($con, "SELECT M_COURSE.courseID, M_COURSE.courseTitle, M_COURSE.courseProfessor, M_COURSE.courseCredit, M_COURSE.coursePersonnel, M_COURSE.courseTime
    FROM M_COURSE, M_SCHEDULE, M_USER WHERE M_USER.userGender = 'Female' AND M_USER.userID = M_SCHEDULE.userID AND M_COURSE.courseID = M_SCHEDULE.courseID
    GROUP BY M_SCHEDULE.courseID ORDER BY COUNT(M_SCHEDULE.courseID) DESC LIMIT 5");

    $response = array();
    while($row = mysqli_fetch_array($result)){
        array_push($response, array("courseID"=>$row[0], "courseTitle"=>$row[1], "courseProfessor"=>$row[2], "courseCredit"=>$row[3],
        "coursePersonnel"=>$row[4], "courseTime"=>$row[5]));
    }

    echo json_encode(array("response"=>$response), JSON_UNESCAPED_UNICODE);
    mysqli_close($con);
?>