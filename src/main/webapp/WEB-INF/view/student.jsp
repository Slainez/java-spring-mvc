<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri= "http://www.springframework.org/tags/form" prefix = "form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Student form</title>
        </head>
        <body>
            <h1>Student information</h1>
            
            <form:form method="POST" action = "/addStudent" modelAttribute="studentForm">
                <table>
                   
                     <tr>
                        <td><form:label path="age">Age</form:label></td>
                        <td>
                            <form:input path="age" type="number" />
                            <form:errors path="age"  />
                        </td>
                     </tr>
                      <tr>
                        <td><form:label path="name">name</form:label></td>
                        <td>
                            <form:input path="name" />
                            <form:errors path="name" />
                        </td>
                    </tr>
                     <tr>
                         <td><input type="submit" value="Save"></td>
                    </tr>
                </table>
            </form:form>
        </body>
    </html>

