# FairytaleFlavorsRepo
 Web application which allows users to manage their favorite recipes.

# Instructions

# How to run
###Build Spring Boot Project with Maven
- clone the project
- cd FairytaleFlavors
- mvn install
- java -jar target/FairytaleFlavors-0.0.1-SNAPSHOT.jar


#Run Spring Boot app using Eclipse
- Alternatively, any IDE could be used to run the FairytaleFlavorsApplication.


#SampleRequests(Postman recommended):
##CreateRecipe:
###SampleRequest:
-http://localhost:8080/createRecipe
-RequestBody:
{
    "recipeName":"Kabab",
    "isVegetarian":"true",
    "servingSize":"4",
    "ingredients":["oil", "onion"],
    "cookingInstructions":["add oil", "add onion"]
}
-Authorization:Basic Auth
-Username:USER
-Password:USER

###SampleResponse:
{
    "id": 3,
    "recipeName": "Kabab",
    "createDate": "24-09-2021, 12:21",
    "isVegetarian": true,
    "servingSize": 4,
    "ingredients": [
        "oil",
        "onion"
    ],
    "cookingInstructions": [
        "add oil",
        "add onion"
    ]
}

###StatusCode:
- 201 created

##GetRecipeById:
###SampleRequest:
-http://localhost:8080/getRecipeById?id=3

###SampleResponse(if data is present inside the database wih given id):
{
    "id": 3,
    "recipeName": "Kabab",
    "createDate": "24-09-2021, 12:21",
    "isVegetarian": true,
    "servingSize": 4,
    "ingredients": [
        "oil",
        "onion"
    ],
    "cookingInstructions": [
        "add oil",
        "add onion"
    ]
}

###status code:
- 200 Ok

###SampleResponse(if data is not present inside the database wih given id):
{
    "statusCode": 404,
    "timestamp": "2021-09-24T12:27:22.5875773",
    "message": "Recipe Not Found with Id: 3"
}

##GetRecipeByName:
###SampleRequest:
-http://localhost:8080/getRecipeByName?recipeName=Kabab

###SampleResponse:
{
    "id": 2,
    "recipeName": "Kabab",
    "createDate": "24-09-2021, 12:29",
    "isVegetarian": true,
    "servingSize": 4,
    "ingredients": [
        "oil",
        "onion"
    ],
    "cookingInstructions": [
        "add oil",
        "add onion"
    ]
}

##GetRecipeByType:
###SampleRequest:
-http://localhost:8080/getRecipeByType?isVegetarian=true

###SampleResponse:
[
    {
        "id": 2,
        "recipeName": "Kabab",
        "createDate": "24-09-2021, 12:29",
        "isVegetarian": true,
        "servingSize": 4,
        "ingredients": [
            "oil",
            "onion"
        ],
        "cookingInstructions": [
            "add oil",
            "add onion"
        ]
    },
    {
        "id": 3,
        "recipeName": "Kabab",
        "createDate": "24-09-2021, 12:31",
        "isVegetarian": true,
        "servingSize": 4,
        "ingredients": [
            "oil",
            "onion"
        ],
        "cookingInstructions": [
            "add oil",
            "add onion"
        ]
    }
]

##GetRecipeByServingSize:
###SampleRequest:
-http://localhost:8080/getRecipeByServingSize?servingSize=4

###SampleResponse:
[
    {
        "id": 2,
        "recipeName": "Kabab",
        "createDate": "24-09-2021, 12:29",
        "isVegetarian": true,
        "servingSize": 4,
        "ingredients": [
            "oil",
            "onion"
        ],
        "cookingInstructions": [
            "add oil",
            "add onion"
        ]
    },
    {
        "id": 3,
        "recipeName": "Kabab",
        "createDate": "24-09-2021, 12:31",
        "isVegetarian": true,
        "servingSize": 4,
        "ingredients": [
            "oil",
            "onion"
        ],
        "cookingInstructions": [
            "add oil",
            "add onion"
        ]
    }
]

##GetRecipeList:
###SampleRequest:
- http://localhost:8080/getRecipeList

###SampleResponse:
[
    {
        "id": 2,
        "recipeName": "Kabab",
        "createDate": "24-09-2021, 12:29",
        "isVegetarian": true,
        "servingSize": 4,
        "ingredients": [
            "oil",
            "onion"
        ],
        "cookingInstructions": [
            "add oil",
            "add onion"
        ]
    },
    {
        "id": 3,
        "recipeName": "Kabab",
        "createDate": "24-09-2021, 12:31",
        "isVegetarian": true,
        "servingSize": 4,
        "ingredients": [
            "oil",
            "onion"
        ],
        "cookingInstructions": [
            "add oil",
            "add onion"
        ]
    },
    {
        "id": 4,
        "recipeName": "Kabab",
        "createDate": "24-09-2021, 12:34",
        "isVegetarian": true,
        "servingSize": 3,
        "ingredients": [
            "oil",
            "onion"
        ],
        "cookingInstructions": [
            "add oil",
            "add onion"
        ]
    }
]

##UpdateRecipeById:
###SampleRequest:
- http://localhost:8080/UpdateRecipeById

###RequestBody:
{
    "id":"2",
    "recipeName": "Kheer"
}
###SampleResponse:
{
    "id": 2,
    "recipeName": "Kheer",
    "createDate": "24-09-2021, 12:29",
    "isVegetarian": true,
    "servingSize": 4,
    "ingredients": [
        "oil",
        "onion"
    ],
    "cookingInstructions": [
        "add oil",
        "add onion"
    ]
}

##DeleteRecipeById:
###SampleRequest:
- http://localhost:8080/deleteRecipeById?id=2

###Basic Auth:
- USER, USER

###SampleResponse:
- Deleted Id: 2

##Database console link:
- http://localhost:8080/h2-console
##configurations:
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa

# Notes:
- Used Authentication on create, update and delete operations.
- Read operations are Authentication free.
- Used Embedded database for simplicity.
- Currently data is not persisted, could use file storage to persist the data.



