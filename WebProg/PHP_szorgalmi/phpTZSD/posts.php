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

            if(!$auth->is_authenticated()) {
                header("Location: login.php");
                exit();
            }
    ?>

    <form action="" method="post">
        <label for="cim">Cím: </label> <br>
        <input type="text" name="cim" id="cim"> <br>
        <label for="szoveg">Szöveg: </label> <br>
        <textarea name="szoveg" id="szoveg" cols="30" rows="10"></textarea> <br> <br>
        <button type="submit">Submit</button>
    </form>

    <?php

        function is_empty($input, $key) {
            return !(isset($input[$key]) && trim($input[$key]) !== "");
        }

        function validate($input, &$errors) {

            if(is_empty($input, "cim") || is_empty($input, "szoveg")) {
                $errors[] = "Cim/szoveg ures";
            }
    
            return !(bool) $errors;
        }

      

        $errors = [];
        
        if(count($_POST) !== 0) {
            if(validate($_POST,$errors)) {
                $time = date('Y/m/d h:i', time());

                $obj = (object) array(
                    "cim" => $_POST['cim'],
                    "szoveg" => $_POST['szoveg'],
                    "username" => $_SESSION["user"]['username'],
                    "date" => $time
                );   

                $jstore = new JsonStorage("posts.json");
                $jstore->insert($obj);

                header("Location: main.php");
                exit();
            } 
        }
    ?>

    <?php if ($errors) {?>
    <ul>
        <?php foreach ($errors as $error) {?>
        <li><?=$error?></li>
        <?php }?>
    </ul>
    <?php }?>
    
</body>
</html>