<?php

$con = mysqli_connect ("localhost","bakhoijae","oexis7831","bakhoijae");
//4����  ȸ�������� �Է¹޾����� 
$userID = $_POST["userID"];
$userPassword = $_POST["userPassword"];

//User��� ��� ���̺� �ȿ� �ش� ������ �Է��Ҽ� �ֵ��� �Ѵ�.  
$statement = mysqli_prepare($con, "SELECT * FROM M_USER WHERE userID = ? AND userPassword = ?");
mysqli_stmt_bind_param($statement, "ss", $userID, $userPassword);
mysqli_stmt_execute($statement);

mysqli_stmt_store_result($statement);
mysqli_stmt_bind_result($statement, $userID);

//ȸ������� �Ϸ�� ���Ŀ� success��� ������ true���� �־��־� ȸ������ ���� �� response�� �ؼ� ȸ�������� ���������� �˷��ش�.
$response = array();
$response["success"] = false;

while(mysqli_stmt_fetch($statement)){
$response["success"] = true;
$response["userID"] = $userID;

}

echo json_encode($response);
?>