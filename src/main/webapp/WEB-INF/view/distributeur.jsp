<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri= "http://www.springframework.org/tags/form" prefix = "form" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>           
            <title>Distributeur</title>
        </head>
        <body>
            <h1>Distributeur Spring</h1>
            <h2>Votre crédit est de  : ${balance} €</h2>
            
            <table>
                <legend>Nos produits</legend>
                <tr>
                     <th>Id</th>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>Quantité</th>                   
                </tr>               
                
                 <c:forEach items = "${products}" var="product" >
                      <tr>
                          <td>${product.id}</td>
                          <td>${product.name}</td>
                          <td>${product.price} €</td>
                          <td>${product.quantity}</td>
                      </tr>
                 </c:forEach>
                            
            </table>
            
            <form:form method="POST"  action="/addBalance"  modelAttribute="userForm" >
                 <fieldset>
                        <legend>Ajout de crédit </legend>
                <form:label path="balance">Montant :</form:label>
                <br>
                <form:input path="balance" type="number" />
                <form:errors path="balance" />
                
                <input type="submit" value="Ajouter">
                 </fieldset>
            </form:form>
                
            
            <form:form method="POST"  action="/addProducts"  modelAttribute="productForm" >
                 <fieldset>
                        <legend>Création de produit</legend>
                <form:label path="name">Nom :</form:label>
                <br>
                <form:input path="name" type="text" />
                <form:errors path="name" />
                <br>
                <form:label path="price">Prix :</form:label>
                <br>
                <form:input path="price" type="number" />
                <form:errors path="price" />
                <br>
                <form:label path="quantity">Quantité :</form:label>
                <br>
                <form:input path="quantity" type="number" />
                <form:errors path="quantity" />
                <br>
                <input type="submit" value="Ajouter">
                 </fieldset>
            </form:form>
                
                
                
                
                
                <form:form method="POST"  action="/buyProducts" modelAttribute="buyForm"  >
                    <fieldset>
                        <legend>Achat de produit</legend>
                    <form:label path="id"> Choisissez votre produit :</form:label>
                    <br>
                    
                    
                    <form:select path="id" multiple="false" > 
                        <c:forEach items = "${products}" var="product" >
                            <c:if test="${product.quantity > 0}">
                            <form:option   value="${product.id}"  label="${product.name}"  />   
                            </c:if>
                        </c:forEach>
                    </form:select> 
                    
                    <form:errors path="id" />
                   
                    <br>
                    <input type="submit" value="Acheter">
                    
                    </fieldset> 
               </form:form>
         
        </body>
    </html>

