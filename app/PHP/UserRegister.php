<?php

$con = mysqli_connect ("localhost","bakhoijae","oexis7831","bakhoijae");
//4����  ȸ�������� �Է¹޾����� 
$userID = $_POST["userID"];
$userPassword = $_POST["userPassword"];
$userGender = $_POST["userGender"];
$userEmail = $_POST["userEmail"];

//User��� ��� ���̺� �ȿ� �ش� ������ �Է��Ҽ� �ֵ��� �Ѵ�.  
$statement = mysqli_prepare($con, "INSERT INTO M_USER VALUES (?, ?, ?, ?)");
//������ ������ �� ���ڿ� �����̱⋚���� sssss�̴�. 
mysqli_stmt_bind_param($statement, "ssss", $userID, $userPassword, $userGender, $userEmail);
mysqli_stmt_execute($statement);

//ȸ������� �Ϸ�� ���Ŀ� success��� ������ true���� �־��־� ȸ������ ���� �� response�� �ؼ� ȸ�������� ���������� �˷��ش�.
$response = array();
$response["success"] = true;

echo json_encode($response);
?>