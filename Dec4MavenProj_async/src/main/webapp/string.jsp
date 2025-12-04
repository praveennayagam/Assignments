<!DOCTYPE html>
<html>
<head>
    <title>Async File Processor</title>
</head>
<body>
    <h2>Async File Processor Demo</h2>
    <form>
        Enter Text: <input id="inputText" type="text" name="inputText">
        <button type="button" onclick="processText()">Process</button>
    </form>

    <div id="output"></div>

    <script type="text/javascript">
        async function processText() {
            let text = document.getElementById("inputText").value;

            let resp = await fetch("AsyncFileProcessor", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
                body: "inputText=" + text
            });

            let result = await resp.text();
            document.getElementById("output").innerHTML = result;
        }
    </script>
</body>
</html>
