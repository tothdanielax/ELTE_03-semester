<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<?php 
    function validate() {

        if(!isset($_GET['rendszam']) || !isset($_GET['szin']) || !isset($_GET['gyarto']) || !isset($_GET['gyartasiev'])) {
            return false;
        }

        if(strlen($_GET['rendszam']) == 0 || strlen($_GET['szin']) == 0 || strlen($_GET['gyarto']) == 0 || strlen($_GET['gyartasiev']) != 4) {
            return false;
        }

        return true;
    }
    ?>

    <?php

    $error;
    if (count($_GET) !== 0) {
       $error = !(validate()); 
    } else {
        $error = false;
    }
    
    if ($error): ?>
    <ul>
        <li>Error</li>
    </ul>
    <?php endif;?>

    <form action="" method="get">
        <label for="rendszam">rendszam</label><input type="text" name="rendszam" id="rendszam" value="<?= $error ? $_GET["rendszam"] : ''?>">
        <label for="szin">szin</label><input type="text" name="szin" id="szin" value="<?= $error? $_GET["szin"] : ''?>">
        <label for="gyarto">gyarto</label><input type="text" name="gyarto" id="gyarto" value="<?= $error ? $_GET["gyarto"] : ''?>">
        <label for="gyartasiev">gyartasiev</label><input type="text" name="gyartasiev" id="gyartasiev" value="<?= $error ? $_GET["gyartasiev"] : ''?>">
        <button type="submit">Send</button>
    </form>

    <?php 
    include_once 'jsonstorage.php';

    $jstore = new JsonStorage('autok.json');

    if(validate()) {
        $rendszam = $_GET['rendszam'];
        $szin = $_GET['szin'];
        $gyarto = $_GET['gyarto'];
        $gyartasiev = $_GET['gyartasiev'];

        $obj = (object) array(
                "rendszam" => $rendszam,
                "szin" => $szin,
                "gyarto" => $gyarto,
                "gyartasiev" => $gyartasiev
            );

        $jstore->insert($obj);
    }
    
    ?>

    <a href="masikoldal.php">Irany a masik oldalra</a>     
</body>
</html>