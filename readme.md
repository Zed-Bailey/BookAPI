# Book API

This is a book api built
on [top of this kaggle dataset](https://www.kaggle.com/datasets/jealousleopard/goodreadsbooks?resource=download)

Built to learn java and spring boot

## Response

all endpoints are `GET` endpoints and will return a json response similar to the following

```json
{
  "count": 20,
  "results": [],
  "error": "error string"
}
```

`count` the number of results in `results`

`results` An array of book models

`error` if response status code == 404, then the error string will be filled with an error
```json
{
  "bookID" : 0,
  "title" : "",
  "authors": "",
  "average rating": 0.0,
  "isbn": "",
  "isbn13": "",
  "language": "eng",
  "num_pages": 0,
  "publication_date": "",
  "publisher": ""
}
```

## Endpoints

```
/books/{id} # get book by id

/books/isbn/{isbn} # get book by isbn
/books/isbn13/{isbn13} # get book by isbn13

/books/author?v={author name} # get book by author

/books/rating?gt={greater then} # return all books with rating greater then
/books/rating?lt={less then} # return all books with ratings less then

/books/languagecodes # returns all the language codes
/books?language={language code} # return books by language code

/books/published?on={date} # returns all books published on this date
/books/published?after={date} # returns all books published after this date
/books/published?before={date} # returns all books published before this date

/books/publisher/{publisher} # return all books by publisher
```
