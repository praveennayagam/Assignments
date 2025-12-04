<form action="UserServlet" method="post">
    <table border="0" cellpadding="8" cellspacing="0">
        <tr>
            <td><label for="id">ID:</label></td>
            <td><input type="text" id="id" name="id" required></td>
        </tr>
        <tr>
            <td><label for="uname">User Name:</label></td>
            <td><input type="text" id="uname" name="uname" required></td>
        </tr>
        <tr>
            <td><label for="pwd">Password:</label></td>
            <td><input type="password" id="pwd" name="pwd" required></td>
        </tr>
        <tr>
            <td><label for="email">Email:</label></td>
            <td><input type="email" id="email" name="email" required></td>
        </tr>
        <tr>
            <td><label for="phone">Phone Number:</label></td>
            <td><input type="tel" id="phone" name="phone" pattern="[0-9]{10}" placeholder="1234567890"></td>
        </tr>
        <tr>
            <td><label for="address">Address:</label></td>
            <td><input type="text" id="address" name="address"></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center;">
                <button type="submit" name="action" value="insert">Insert</button>
                <button type="submit" name="action" value="update">Update</button>
                <button type="submit" name="action" value="delete">Delete</button>
                <button type="submit" name="action" value="read">Read</button>
            </td>
        </tr>
    </table>
</form>
