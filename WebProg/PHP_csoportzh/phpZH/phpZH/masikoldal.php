<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php 
        include_once 'jsonstorage.php';

        $jstore = new JsonStorage('autok.json');
        $cars = $jstore->all();

    ?>
       
    <form action="" method="get">
            <label for="gyartoFilter">gyarto</label>
            <input type="text" name="gyartoFilter" id="gyartoFilter" value="">
            <button type="submit">send</button>
    </form>
    
    <table>
    <?php foreach ($cars as $car): ?>
        <tr>
        <?php 
            if(isset($_GET['gyartoFilter'])): ?>
                <?php if($car['gyarto'] == $_GET['gyartoFilter']): ?>
                    <td><?=$car['rendszam']?></td> 
                    <td><?=$car['szin']?></td>    
                    <td><?=$car['gyarto']?></td>    
                    <td><?=$car['gyartasiev']?></td> 
                <?php endif;?>
            <?php endif;?>  
            <?php if(!isset($_GET['gyartoFilter'])): ?>  
                    <td><?=$car['rendszam']?></td> 
                    <td><?=$car['szin']?></td>    
                    <td><?=$car['gyarto']?></td>    
                    <td><?=$car['gyartasiev']?></td> 
            <?php endif;?>    
        </tr>
    <?php endforeach;?>
    </table>
    
</body>
</html>