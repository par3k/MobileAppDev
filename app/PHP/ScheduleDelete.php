<?php
    $con = mysqli_connect("localhost","bakhoijae","oexis7831","bakhoijae");

    $userID = $_POST["userID"];
    $courseID = $_POST["courseID"];

    $statement = mysqli_prepare($con,"DELETE FROM M_SCHEDULE WHERE userID = ? AND courseID = ?");
    mysqli_stmt_bind_param($statement,"si",$userID,$courseID);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>