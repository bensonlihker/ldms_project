The api mainly require to use json input and output


localhost:8080/create/
this api for create schedule

please use post and with application/json Content-Type
Sample Data:
(with balloon)
{
"assetCost" : 25000 ,
"deposit" : 5000 ,
"interestRate" : 7.5,
"numberOfTerm": "60",
"balloon" : 10000
}

Expired result:
[
    {
        "period": 1,
        "payment": 262.88,
        "principal": 137.88,
        "interest": 125,
        "balance": 19862.12
    },
  ...
    {
        "period": 60,
        "payment": 262.88,
        "principal": 199.14,
        "interest": 63.74,
        "balance": 9999.97
    }
]


(without balloon)
{
"assetCost" : 25000 ,
"deposit" : 5000 ,
"interestRate" : 7.5,
"numberOfTerm": "60"
}

Expired result:
[
    {
        "period": 1,
        "payment": 400.76,
        "principal": 275.76,
        "interest": 125,
        "balance": 19724.24
    },
  ...
   {
        "period": 60,
        "payment": 400.76,
        "principal": 398.27,
        "interest": 2.49,
        "balance": -0.09
    }
]


localhost:8080/list_all/
this api for list all previously created schedules

Expired result:
[
    {
        "id": 1,
        "assetCost": 25000,
        "deposit": 5000,
        "interestRate": 7.5,
        "numberOfTerm": 12,
        "balloon": 10000,
        "monthlyRepayment": 930.07,
        "totlaInteresDue": 1160.89,
        "totlaPaymentDue": 11160.84
    },
...
    {
        "id": 4,
        "assetCost": 25000,
        "deposit": 5000,
        "interestRate": 7.5,
        "numberOfTerm": 60,
        "balloon": 10000,
        "monthlyRepayment": 262.88,
        "totlaInteresDue": 5772.77,
        "totlaPaymentDue": 15772.8
    }
]


localhost:8080/get/?id=2
this api for retrieve the full details of an individual schedule 
with using get method and id = x

{
    "scheduleData": {
        "id": 1,
        "assetCost": 25000,
        "deposit": 5000,
        "interestRate": 7.5,
        "numberOfTerm": 12,
        "balloon": 10000,
        "monthlyRepayment": 930.07,
        "totlaInteresDue": 1160.89,
        "totlaPaymentDue": 11160.84
    },
   "resultList": [
        {
            "period": 1,
            "payment": 930.07,
            "principal": 805.07,
            "interest": 125,
            "balance": 19194.93
        },
        ...
        {
            "period": 12,
            "payment": 930.07,
            "principal": 862.18,
            "interest": 67.89,
            "balance": 10000.05
        }
    ]
}
