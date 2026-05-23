<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión - Ring-CARDS</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f4f9; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;">

    <div style="background: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); width: 100%; max-width: 350px; text-align: center;">
        <h2 style="margin-bottom: 20px; color: #333;">Iniciar Sesión</h2>
        
        <form action="validar.php" method="POST">
            <div style="margin-bottom: 15px; text-align: left;">
                <label for="email" style="font-weight: bold; color: #555;">Usuario (Email):</label>
                <input type="email" id="email" name="email" required style="width: 100%; padding: 10px; margin-top: 5px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box;">
            </div>
            
            <div style="margin-bottom: 20px; text-align: left;">
                <label for="pass" style="font-weight: bold; color: #555;">Contraseña:</label>
                <input type="password" id="pass" name="pass" required style="width: 100%; padding: 10px; margin-top: 5px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box;">
            </div>
            
            <button type="submit" style="width: 100%; background-color: #28a745; color: white; padding: 10px; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; font-weight: bold;">
                SUBMIT
            </button>
        </form>
        
        <br>
        <a href="#" style="color: #007bff; text-decoration: none; font-size: 14px;">olvidé contraseña</a>
    </div>

</body>
</html>