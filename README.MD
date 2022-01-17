# Grocerylist generator

## Introduction
This is a school project for our complex Java programming course.
The meaning with this application is to help the user to make grocery shopping easier.
The idea is that the user can pick recipes in the application and the ingredients needed is automatically added in the users grocery list. It is also possible to search for recipes by ingredients. The user can save favorite recipes and also add a favorite grocery store.

**Tools**
* Java 17
* Spring Boot
* Maven
* AWS database with PostgreSQL
* Docker
* JMS - Artemis

## Endpoints
### Explanation of endpoints
* Users that are allowed to access endpoint
* Request method for endpoint + `http://localhost:8080/api/example`
* Don't forget: authorization needed for each endpoint (excluding signup and login) by entering
`Authorization  : Bearer jwttoken` in the http header for each request you make. You will receive the JWT token after logging in with valid username and password.

### Creating account and logging in

#### Create an account
Open to all:   
POST `http://localhost:8080/signup`  
Request body
```
{
  "username": "my_username",
  "password": "my_password"
}
```  

#### Login to your account
Open to all:     
POST `http://localhost:8080/login`  
Form (URL encoded)  
username &emsp; my_username  
password &emsp; my_password

JWT token will be given in the response body for future requests.


### Manage account

#### Get your information
USER, ADMIN    
GET `http://localhost:8080/persons`  

#### Add ingredients from a recipe to your grocery list
USER, ADMIN  
POST `localhost:8080/api/persons/grocerylist/recipes/{recipeId}`

#### Add ingredient to your grocery list
USER, ADMIN  
POST `localhost:8080/api/persons/grocerylist/ingredients/{ingredientId}/{recipeId}`

#### Add recipe to your recipe list
USER, ADMIN  
POST `localhost:8080/api/persons/recipes/{recipeId}`

#### Add your favorite store
USER, ADMIN  
POST `localhost:8080/api/persons/stores/{storeId}`

#### Delete ingredient from your grocery list
USER, ADMIN  
DELETE `localhost:8080/api/persons/grocerylist/ingredients/{ingredientId}`

#### Delete recipe from your recipe list
USER, ADMIN  
DELETE `localhost:8080/api/persons/recipes/{recipeId}`

#### Get all persons
ADMIN  
GET `localhost:8080/api/persons/all`
   

### Ingredients
#### Create an ingredient
ADMIN  
POST `http://localhost:8080/api/ingredients`  
Request body
```json
{
  "name": "cheddar cheese"
}
```  

####  Add a category to an ingredient by entering the ingredient id and the corresponding category id in the url
ADMIN  
POST `http://localhost:8080/api/ingredients/{ingredientId}/category/{categoryId}`  
Request body

#### Get all ingredients that are in the database
ADMIN, USER  
GET `http://localhost:8080/api/ingredients`  

#### Get information of a specific ingredient by entering its ingredient id in the url
ADMIN  
GET `http://localhost:8080/api/ingredients/{ingredientId}`

### Category
#### Create a category
ADMIN  
POST `http://localhost:8080/api/category`  
Request body
```json
{
  "name": "dairy"
}
```  

#### Get all categories that are in the database
ADMIN, USER  
GET `http://localhost:8080/api/categories`  

#### Get information of a specific category by entering its category id in the url
ADMIN  
GET `http://localhost:8080/api/categories/{categoryId}`




