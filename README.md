Given four files `SongController.java`, `SongRepository.java`, `SongService.java`, and  `Song.java`.
The `SongService` class has a variable named `playlist`, which is a HashMap that holds `Integer`s as keys and `Song` objects as values. Initially, it contains data of 5 songs.

### Completion Instructions

- `Song.java`: The `Song` class should contain the following attributes.

    | Attribute     | Type   |
    | ------------- | ------ |
    | songId        | int    |
    | songName      | String |
    | lyricist      | String |
    | singer        | String |
    | musicDirector | String |

- `SongRepository.java`: Create an interface containing required methods.
- `SongService.java`: Update the service class with logic for managing song data.
- `SongController`: Create the controller class to handle HTTP requests.  

Implement the following APIs.

### API 1

#### Path: `/songs`

#### Method: `GET`

#### Description:

Returns a list of all songs in the `playlist`.

#### Response

```
[
    {
        "songId": 1,
        "songName": "Butta Bomma",
        "lyricist": "Ramajogayya Sastry",
        "singer": "Armaan Malik",
        "musicDirector": "Thaman S"
    },
   ...
]
```

### API 2

#### Path: `/songs`

#### Method: `POST`

#### Description:

Creates a new song in the `playlist`. `songId` is auto-incremented.

#### Request

```
{
    "songName": "Bala", 
    "lyricist": "Siddharth-Garima", 
    "singer": "Sachin-Jigar", 
    "musicDirector": "Sachin-Jigar"
}
```

#### Response

```
{
    "songId": 6,
    "songName": "Bala",
    "lyricist": "Siddharth-Garima",
    "singer": "Sachin-Jigar",
    "musicDirector": "Sachin-Jigar"
}
```

### API 3

#### Path: `/songs/{songId}`

#### Method: `GET`

#### Description:

Returns a song based on a `songId`. If the given `songId` is not found in the `playlist`, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

#### Response

```
{
    "songId": 3,
    "songName": "Tum Hi Ho",
    "lyricist": "Mithoon",
    "singer": "Arijit Singh",
    "musicDirector": "Mithoon"

}
```

### API 4

#### Path: `/songs/{songId}`

#### Method: `PUT`

#### Description:

Updates the details of a song in the `playlist` based on the `songId`. If the given `songId` is not found in the `playlist`, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

#### Request

```
{
    "singer": "Atif Aslam"
}
```

#### Response

```
{
    "songId": 3,
    "songName": "Tum Hi Ho",
    "lyricist": "Mithoon",
    "singer": "Atif Aslam",
    "musicDirector": "Mithoon"
}

```

### API 5

#### Path: `/songs/{songId}`

#### Method: `DELETE`

#### Description:

Deletes a song from the `playlist`  based on the `songId`. If the given `songId` is not found in the `playlist`, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

**Do not modify the code in the `SongApplication.java`.**