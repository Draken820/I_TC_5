<?php
// 1. Conexión a la base de datos 

$conexion = mysqli_connect("localhost", "root", "", "I_TC_5");

if (!$conexion) {
    die("Error al conectar con la base de datos: " . mysqli_connect_error());
}

// 2. Traer los datos que el usuario en el login
$email = $_POST['email'];
$pass = $_POST['pass'];

// 3. Buscar si el correo y contraseña existen en la tabla 'usuarios'
$consulta = "SELECT * FROM usuarios WHERE email = '$email' AND pass = '$pass'";
$resultado = mysqli_query($conexion, $consulta);

// 4. Revisar si encontramos al menos 1 fila que coincida
if (mysqli_num_rows($resultado) > 0) {
    // Si los datos son correctos, iniciamos la sesión del usuario
    session_start();
    $_SESSION['usuario'] = $email;
    
    echo "¡Inicio de sesión exitoso! Bienvenido.";
    // En el futuro, aquí puedes redirigir a la página principal de tarjetas:
    // header("Location: tarjetas.php");
} else {
    // Si los datos están mal, lanza una alerta y regresa al login
    echo "<script>
            alert('El correo o la contraseña son incorrectos.');
            window.location.href = 'login.php';
          </script>";
}

// 5. Cerrar la conexión limpia
mysqli_close($conexion);
?>