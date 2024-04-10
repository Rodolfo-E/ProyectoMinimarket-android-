<?php
include "conexion.php";
$usu=$_POST["Usu"];
$cla=$_POST["Cla"];
$consulta="insert into usuario values ('".$usu."','".$cla."')";
mysqli_query($conexion,$consulta)or die(mysql_errno());
mysqli_close($conexion);
?>