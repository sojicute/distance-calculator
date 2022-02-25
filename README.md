# distance-calculator


#### `GET` /api/v1/city
##### Example: http://localhost:8080/api/v1/city

**Response:**
```json
[
  {
    "id": 1,
    "name": "Paris"
  },
  {
    "id": 2,
    "name": "Berlin"
  },
  {
    "id": 3,
    "name": "Samara"
  },
  {
    "id": 4,
    "name": "Toliatty"
  }
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
##### Example: http://localhost:8080/api/v1/distance-calculator/calculate?fromCity=Paris,Berlin&toCity=Samara,Toliatty&type=MATRIX

```json
[
    {
        "from_city": "Berlin",
        "to_city": "Samara",
        "matrix_distance": 2444.61
    },
    {
        "from_city": "Berlin",
        "to_city": "Toliatty",
        "matrix_distance": 2380.74
    },
    {
        "from_city": "Paris",
        "to_city": "Samara",
        "matrix_distance": 3317.0
    },
    {
        "from_city": "Paris",
        "to_city": "Toliatty",
        "matrix_distance": 3254.53
    }
]
```

##### Example: http://localhost:8080/api/v1/distance-calculator/calculate?fromCity=Paris,Berlin&toCity=Samara,Toliatty&type=ALL

```json
[
  {
    "from_city": "Berlin",
    "to_city": "Samara",
    "crowflight_distance": 2444.3749772594965,
    "matrix_distance": 2444.61
  },
  {
    "from_city": "Berlin",
    "to_city": "Toliatty",
    "crowflight_distance": 2380.760202439124,
    "matrix_distance": 2380.74
  },
  {
    "from_city": "Paris",
    "to_city": "Samara",
    "crowflight_distance": 3317.279170679178,
    "matrix_distance": 3317.0
  },
  {
    "from_city": "Paris",
    "to_city": "Toliatty",
    "crowflight_distance": 3254.268899902258,
    "matrix_distance": 3254.53
  }
]
```

#### `POST` /api/v1/upload/city
##### Example http://localhost:8080/api/v1/upload/city
Upload XML file with cities
```XML
<?xml version="1.0" encoding="UTF-8"?>
<cities>
    <city>
        <name>Paris</name>
        <latitude>48.864716</latitude>
        <longitude>2.349014</longitude>
    </city>
    <city>
        <name>Berlin</name>
        <latitude>52.520008</latitude>
        <longitude>13.404954</longitude>
    </city>
    <city>
        <name>Samara</name>
        <latitude>53.241505</latitude>
        <longitude>50.221245</longitude>
    </city>
    <city>
        <name>Toliatty</name>
        <latitude>53.5303</latitude>
        <longitude>49.3461</longitude>
    </city>
</cities>
```
#### `POST` /api/v1/upload/distance
##### Example http://localhost:8080/api/v1/upload/distance
Upload XML file with distance
```XML
<?xml version="1.0" encoding="UTF-8"?>
<distances>
    <distance>
        <fromCity>Paris</fromCity>
        <toCity>Samara</toCity>
        <distance>3317</distance>
    </distance>
    <distance>
        <fromCity>Paris</fromCity>
        <toCity>Toliatty</toCity>
        <distance>3254.53</distance>
    </distance>
    <distance>
        <fromCity>Berlin</fromCity>
        <toCity>Samara</toCity>
        <distance>2444.61</distance>
    </distance>
    <distance>
        <fromCity>Berlin</fromCity>
        <toCity>Toliatty</toCity>
        <distance>2380.74</distance>
    </distance>
</distances>
```
