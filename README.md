# distance-calculator


#### `GET` /api/v1/city
##### Example: http://localhost:8080/api/city

**Response:**
```json
    [
        {
            "id": 1,
            "name": "Paris",
            "latitude": 48.864716,
            "longitude": 2.349014
        },
        {
            "id": 2,
            "name": "Berlin",
            "latitude": 52.520008,
            "longitude": 13.404954
        },
    ]
```
#### `POST` /api/v1/distance-calculator/calculate
##### Example: http://localhost:8080/api/v1/distance-calculator/calculate?fromCity=Paris,Berlin&toCity=Samara,Toliatty&type=CROWFLIGHT

*  **URL Params**
`fromCity=[List of City>]`
`toCity=[List of City]`
`type=[MATRIX or CROWFLIGHT or ALL]`

**Response:**
```json
[
    {
        "from_city": "Paris",
        "to_city": "Samara",
        "crowflight_distance": 3317.279170679178
    },
    {
        "from_city": "Paris",
        "to_city": "Toliatty",
        "crowflight_distance": 3254.268899902258
    },
    {
        "from_city": "Berlin",
        "to_city": "Samara",
        "crowflight_distance": 2444.3749772594965
    },
    {
        "from_city": "Berlin",
        "to_city": "Toliatty",
        "crowflight_distance": 2380.760202439124
    }
]
```
#### `POST` /api/v1/upload/city
Uploads XML file with cities and distances 
##### Example http://localhost:8080/api/v1/upload/city

#### `POST` /api/v1/upload/distance
##### Example http://localhost:8080/api/v1/upload/distance

