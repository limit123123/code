<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="zh">
    <head>
        <meta charset="utf-8" />
        <title>Custom keyboard shortcuts - Editor.md examples</title>
       <link rel="stylesheet" href="css/mdstyle.css" />
        <link rel="stylesheet" href="/css/editormd.css" />
        <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon" />
    </head>
    <body>
        <div id="layout">
            <header>
                <h1>Custom keyboard shortcuts</h1>
            </header>
            <div id="test-editormd">
                <textarea >#### Default

> If Editor.md code editor is on focus, you can use keyboard shortcuts.
> Editor.md have the default keyboard shortcuts handle. Plaese open the help dialog, can see all default keyboard shortcuts.

#### Example

```javascript
var testEditor = editormd("test-editormd", {
    width: "90%",
    height: 720,
    path : '../lib/',
    disabledKeyMaps : [
        "Ctrl-B", "F11", "F10"  // disable some default keyboard shortcuts handle
    ],
    onload : function() {
        var keyMap = {
            "Ctrl-S": function(cm) {
                alert("Ctrl+S");
            },
            "Ctrl-A": function(cm) { // default Ctrl-A selectAll
                // custom
                alert("Ctrl+A");
                cm.execCommand("selectAll");
            }
        };

        // setting signle key
        var keyMap2 = {
              "Ctrl-T": function(cm) {
                alert("Ctrl+T");
              }
        };

        this.addKeyMap(keyMap);
        this.addKeyMap(keyMap2);
        this.removeKeyMap(keyMap2);  // remove signle key
    }
});
```
</textarea>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/editormd.js"></script>
        <script type="text/javascript">
			var testEditor;

            $(function() {   
                var widgets = [];
                
                testEditor = editormd("test-editormd", {
                    width: "90%",
                    height: 720,
                    path : '../lib/',
                    disabledKeyMaps : [
                        "Ctrl-B", "F11", "F10"  // disable some default keyboard shortcuts handle
                    ],
                    onchange : function() {
                                $("#test").remove();
                                var cm = this.cm;
                                var cursor = cm.getCursor();

                                //cm.replaceSelection("@");
                                
                                widgets.push(cm.addWidget({line : cursor.line, ch : cursor.ch}, $("<p style='z-index:100000;background:red;color:#fff;padding:5px;' id='test'>fsdfsdfsdf</p>")[0], true));
                                console.log(cm.getCursor(), cm.getLine(cursor.line), cm.getLineTokens(cursor.line));   
                    },
                    onload : function() {
                        var keyMap = {
                            "Ctrl-S": function(cm) {
                                alert("Ctrl+S");
                                //return false;
                            },
                            "Ctrl-A": function(cm) { // default Ctrl-A selectAll
                                // custom
                                alert("Ctrl+A");
                                cm.execCommand("selectAll");
                            },
                            //"Shift-2" : function(cm){
                            //}
                        };
                        
                        this.cm.on("keyup", function(cm){
                            //$("#test").remove();
                        });
                        
                        // setting signle key
                        var keyMap2 = {
                              "Ctrl-T": function(cm) {
                                alert("Ctrl+T");
                              }
                        };
                        
                        this.addKeyMap(keyMap);
                        this.addKeyMap(keyMap2);
                        this.removeKeyMap(keyMap2);  // remove signle key
                    }
                });    
            });
        </script>
    </body>
</html>