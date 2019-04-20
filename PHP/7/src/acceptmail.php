<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        $tate = $_POST['tate'];
        $hp = $_FILES['heya_photo'];
        $hp = filter_input(INPUT_POST, 'heya_photo');
        echo $tate;
        echo $hp;
        echo $heyaphoto === null;
        ?>
    </body>
</html>
