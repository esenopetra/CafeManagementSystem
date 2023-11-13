To create a quiz type in post man
path: http://localhost:8080/quiz/create?category=Java&numQ=5&tittle=JQuiz [In Post]

****************************************************************************************************************************

To view the quiz that generated
path: http://localhost:8080/quiz/get/1  [In Get]

****************************************************************************************************************************

To submit the answer
path: http://localhost:8080/quiz/submit/1  [In Post]
json: [
    {
        "id":"1",
        "response":"128"
    },
     {
        "id":"16",
        "response":"Java Virtual Machine"
    },
     {
        "id":"20",
        "response":"int"
    },
     {
        "id":"18",
        "response":"Object-Oriented Programming"
    },
     {
        "id":"22",
        "response":"ArrayIndexOutOfBoundsException"
    }
]

****************************************************************************************************************************

