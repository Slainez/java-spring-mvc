<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri= "http://www.springframework.org/tags/form" prefix = "form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Student form</title>
        </head>
        <body>
            <h1>Student information send </h1>
            
            
                <table>
                    <tr>
                        <td>Id</td>
                        <td>${id}</td>
                    </tr>
                     <tr>
                        <td>Age</td>
                        <td>${age}</td>
                     </tr>
                      <tr>
                        <td>Name</td>
                        <td>${name}</td>
                    </tr>
                     
                </table>
            
        </body>
    </html>
</f:view>
