<?php
include 'conexion.php';


$stm=$conexion->prepare("SELECT Codigo,Cliente,Descripcion,Fecha,Cantidad,Precio,Monto from compras");
$stm->execute();	
$stm->bind_result($Codigo,$Cliente,$Descripcion,$Fecha,$Cantidad,$Precio,$Monto);
$compra=array();
while($stm->fetch()){
	$temp=array();
	$temp['Codigo']=$Codigo;
	$temp['Cliente']=$Cliente;
	$temp['Descripcion']=$Descripcion;
	$temp['Fecha']=$Fecha;
	$temp['Cantidad']=$Cantidad;
	$temp['Precio']=$Precio;
	$temp['Monto']=$Monto;
	array_push($compra, $temp);

}
echo json_encode($compra);
?>