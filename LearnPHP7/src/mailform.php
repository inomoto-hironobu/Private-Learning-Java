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
        <form method="POST" action="acceptmail.php" enctype="multipart/form-data">
            <label>窓</label>
            <input type="number" name="tate"><input type="number" name="yoko"><br>
            <label>部屋</label>
            <input type="hidden" name="MAX_FILE_SIZE" value="30000" />
            <input type="file" name="heya_photo">
            <label></label>
            <input type="file" name="mado_photo">
            <select name="ko-su">
                <option>test</option>
            </select>
            <button type="submit">submit</button>
        </form>
        <?php
        // put your code here
        ?>
    </body>
</html>
