<?php

$con = mysqli_connect ("localhost","bakhoijae","oexis7831","bakhoijae");

$userID = $_POST["userID"];
$userPassword = $_POST["userPassword"];
$userGender = $_POST["userGender"];
$userEmail = $_POST["userEmail"];

$checkedPassword = password_hash($userPassword, PASSWORD_DEFAULT); // Encryption
$statement = mysqli_prepare($con, "INSERT INTO M_USER VALUES (?, ?, ?, ?)");

mysqli_stmt_bind_param($statement, "ssss", $userID, $checkedPassword, $userGender, $userEmail);
mysqli_stmt_execute($statement);

$response = array();
$response["success"] = true;

echo json_encode($response);
?>
