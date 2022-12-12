<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php 
        include_once 'alap/jsonstorage.php';

        $jstore = new JsonStorage('posts.json');

        $posts = $jstore->all();

        include_once 'alap/auth.php';
        
        $auth = new Auth();
        session_start();

        if($auth->is_authenticated()): ?>
            <?php
            $username = $_SESSION["user"]["username"]; ?>
            <h2> User: <?= $username ?> </h2>
            <a href="login.php">Kijelentkezes</a> <br> <br>
        
        <?php endif; ?>

    
    <a href="posts.php">posztolo oldal</a><br> <br>
    <table>
    <?php foreach ($posts as $post): ?>
        <?php $post = get_object_vars($post) ?> 
        <tr>
            <td><?=$post['cim']?></td> 
            <td><?=$post['szoveg']?></td>    
            <td><?=$post['username']?></td>    
            <td><?=$post['date']?></td> 
        </tr>
    <?php endforeach;?>
    </table>
    
</body>
</html>