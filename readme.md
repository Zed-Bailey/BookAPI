# Book API

This is a book api built
on [top of this kaggle dataset](https://www.kaggle.com/datasets/jealousleopard/goodreadsbooks?resource=download). The
data has been cleaned due to mismatched columns in the original dataset

Built to learn java and spring boot

## Response

all endpoints are `GET` endpoints and will return a json response similar to the following

```json
{
  "count": 3,
  "results": [{}, {}, {}],
  "error": "error string"
}
```

`count` the number of results in `results`

`results` An array of book models

`error` if response status code == 404, then the error string will be filled with an error

#### Book Model

```json
{
  "bookID": 0,
  "title": "",
  "authors": "",
  "average rating": 0.0,
  "isbn": "",
  "isbn13": "",
  "language_code": "eng",
  "num_pages": 0,
  "ratings_count": 0,
  "text_reviews_count": 0,
  "publication_date": "yyyy-MM-dd",
  "publisher": ""
}

```

## Endpoints

#### Get endpoints

```
GET /books # returns all the books
GET /books/{id} # get book by id
GET /books?query={search query} # returns all books with the query in the title

GET /books/isbn/{isbn} # get book by isbn
GET /books/isbn13/{isbn13} # get book by isbn13

GET /books/author?v={author name} # get book by author

GET /books/rating?gt={greater then} # return all books with rating greater than
GET /books/rating?lt={less then} # return all books with ratings less than

GET /books/languagecodes # returns all the language codes
GET /books?language={language code} # return books by language code

GET /books/published?on={date} # returns all books published on this date
GET /books/published?after={date} # returns all books published after this date
GET /books/published?before={date} # returns all books published before this date

GET /books/publishers # return all publishers
GET /books/published?by={publisher} # returns all books published by publisher
```

The endpoints `/books/publishers` and `/books/languagecodes` will both return a 'list response' containing the
number of results and a list of strings

```json
{
  "count": 3,
  "results": [
    "",
    "",
    ""
  ]
}
```

#### Post endpoints

note: as h2 is used as a database any data posted to the database will not be persisted over application restarts

```
POST /books
```

JSON request body

```json
{
  "title": "",
  "authors": "",
  "average rating": 0.0,
  "isbn": "",
  "isbn13": "",
  "language_code": "eng",
  "num_pages": 0,
  "ratings_count": 0,
  "text_reviews_count": 0,
  "publication_date": "yyyy-MM-dd",
  "publisher": ""
}
```

#### Delete Endpoints

```
DELETE /books/{id} # deletes book with corresponding ID
```