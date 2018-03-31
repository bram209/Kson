# Kson

## Example
```kotlin
val json = kson {
    o {
        "user" eq "bram"
        "username" eq "bram209"
        "password" eq "password123"
    }

    o {
        "errorCode" eq 5
        "error" eq "Something went wrong"
        "messages" eq a {
            o {
                "validation" eq "Username is too long!"
                "code" eq 5004
            }
            o {
                "validation" eq "Email is incorrect"
                "code" eq 4003
            }
        }

        "someArray" eq a { !2 + 3 + "test" }

        "someNestedArray" eq a {
            a { !"test" + 2 + 3 }
            a { !4 + "test" + 6 }
            a { !10 + -3 + 8 + "test" }
        }
    }

    a {
        !1 + 2 + 3
    }
}

println(json)
```

Outputs:

```json
[
  {
    "user": "bram",
    "username": "bram209",
    "password": "password123"
  },
  {
    "errorCode": 5,
    "error": "Something went wrong",
    "messages": [
      {
        "validation": "Username is too long!",
        "code": 5004
      },
      {
        "validation": "Email is incorrect",
        "code": 4003
      }
    ],
    "someArray": [
      2,
      3,
      "test"
    ],
    "someNestedArray": [
      [
        "test",
        2,
        3
      ],
      [
        4,
        "test",
        6
      ],
      [
        10,
        -3,
        8,
        "test"
      ]
    ]
  },
  [
    1,
    2,
    3
  ]
]
```