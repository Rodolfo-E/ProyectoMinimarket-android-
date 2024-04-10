<?php

include 'conexion.php';
$usu=$_POST["Usu"];
$cla=$_POST["Cla"];


$consulta="select * from usuario where Usuario= '$usu' and Clave= '$cla'";
$resultado = mysqli_query($conexion,$consulta);
if($resultado ->num_rows >0){
	echo "ingresos";
}else{
	echo "no Ingreso";
}



?>