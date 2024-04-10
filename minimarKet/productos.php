<?php
include 'conexion.php';


$stm=$conexion->prepare("SELECT Codigo,Descripcion,Foto,Stock,Precio_Compra,Precio_Venta from productos");
$stm->execute();	
$stm->bind_result($Codigo,$Descripcion,$Foto,$Stock,$Precio_compra,$Precio_venta);
$producto=array();
while($stm->fetch()){
	$temp=array();
	$temp['Codigo']=$Codigo;
	$temp['Descripcion']=$Descripcion;
	$temp['Foto']=$Foto;
	$temp['Stock']=$Stock;
	$temp['Precio_Compra']=$Precio_compra;
	$temp['Precio_Venta']=$Precio_venta;
	array_push($producto, $temp);

}
echo json_encode($producto);
?>