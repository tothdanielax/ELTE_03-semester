<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <?php
        require_once "alap/auth.php";
        session_start();
        $auth = new Auth();

        function is_empty($input, $key) {
            return !(isset($input[$key]) && trim($input[$key]) !== "");
        }
        
        function validate($input, &$errors, $auth) {

            if(is_empty($input, "username")) {
                $errors[] = "Username is empty";
            }

            if (is_empty($input, "password")) {
                $errors[] = "Password is empty";
            }

            if(count($errors) == 0) {
                if(!$auth -> check_credentials($input['username'], $input['password'])) {
                    $errors[] = "Username/password not ok";
                }
            }
            
    
            return !(bool) $errors;
        }

        $errors = [];
        if (count($_POST) !== 0) {
            if(validate($_POST, $errors, $auth)) {
                $auth->login($_POST);
                header("Location: posts.php");
                die();
            }
         } 
    
    ?>

    <h2>Login</h2>
    <?php if ($errors) {?>
    <ul>
        <?php foreach ($errors as $error) {?>
        <li><?=$error?></li>
        <?php }?>
    </ul>
    <?php }?>
    <form action="" method="post">
        <label for="username">username: </label><input type="text" name="username" id="username" > <br>
        <label for="password">password: </label><input type="password" name="password" id="password">
        <button type="submit">submit</button>
    </form>

    <a href="reg.php">registration</a>
    
</body>
</html>