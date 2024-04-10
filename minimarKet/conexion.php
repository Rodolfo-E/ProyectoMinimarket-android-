<?php
$hostname="localhost";
$database="minimarket";
$username="root";
$password="";
$conexion=new mysqli($hostname,$username,$password,$database);
if($conexion->connect_errno){
	echo "Lo sentimos, el sitio de la web está experimentando problemas";
}
