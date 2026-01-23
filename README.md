# Rafatoração by Martin Fowller

*Estudo do capitúlo 4: teste*


### Para rodar os exemplos dessa API, utilize os seguintes dados de entrada:

POST: localhost:8080/api/statement

Com o json abaixo no corpo da requisição:
```json
{
  "invoice": {
    "customer": "Maria",
    "performances": [
      { "playID": "hamlet", "audience": 55 },
      { "playID": "as-like", "audience": 35 },
      { "playID": "othelo", "audience":40}
    ]
  },
  "plays": {
    "hamlet": { "name": "Hamlet", "type": "tragedy" },
    "as-like": { "name": "As You Like It", "type": "comedy" },
    "othelo":{"name": "Othelo", "type": "tragedy"}
  }
}

