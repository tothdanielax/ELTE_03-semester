<?php
    include_once 'alap/jsonstorage.php';
    session_start();

    $auth = new Auth();
    $auth->logout();

    session_destroy();
    
    header("Location: index.php");
    exit();
?>