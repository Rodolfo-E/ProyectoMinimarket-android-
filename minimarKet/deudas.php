<?php
include 'conexion.php';


$stm=$conexion->prepare("SELECT Codigo,Cliente,Deuda,Fecha from deudas");
$stm->execute();	
$stm->bind_result($Codigo,$Cliente,$Deuda,$Fecha,);
$deuda=array();
while($stm->fetch()){
	$temp=array();
	$temp['Codigo']=$Codigo;
	$temp['Cliente']=$Cliente;
	$temp['Deuda']=$Deuda;
	$temp['Fecha']=$Fecha;
	
	array_push($deuda, $temp);

}
echo json_encode($deuda);
?>