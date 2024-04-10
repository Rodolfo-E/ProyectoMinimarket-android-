<?php
include 'conexion.php';


$stm=$conexion->prepare("SELECT Codigo,Nombre,Apellido,Direccion,Correo,Celular,Distrito from cliente");
$stm->execute();	
$stm->bind_result($Codigo,$Nombre,$Apellido,$Direccion,$Correo,$Celular,$Distrito);
$cliente=array();
while($stm->fetch()){
	$temp=array();
	$temp['Codigo']=$Codigo;
	$temp['Nombre']=$Nombre;
	$temp['Apellido']=$Apellido;
	$temp['Direccion']=$Direccion;
	$temp['Correo']=$Correo;
	$temp['Celular']=$Celular;
	$temp['Distrito']=$Distrito;
	array_push($cliente, $temp);

}
echo json_encode($cliente);
?>